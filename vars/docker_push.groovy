def call(String imageName, String tag = "latest", String credentialsId = "docker-hub") {
    echo "📦 Starting Docker Push for image: ${imageName}:${tag}"

    withCredentials([usernamePassword(credentialsId: credentialsId,
                                       usernameVariable: 'dockerHubUser',
                                       passwordVariable: 'dockerHubPass')]) {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker push ${dockerHubUser}/${imageName}:${tag}"
    }

    echo "✅ Pushed ${dockerHubUser}/${imageName}:${tag} to Docker Hub"
}
