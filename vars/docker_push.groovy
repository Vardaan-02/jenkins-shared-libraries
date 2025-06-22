def call(String imageName, String tag = "latest", String credentialsId = "docker-hub") {
    echo "📦 Starting Docker Push for image: ${imageName}:${tag}"

    withCredentials([usernamePassword(credentialsId: credentialsId,
                                       usernameVariable: 'dockerHubUser',
                                       passwordVariable: 'dockerHubPass')]) {
        sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
        sh "docker tag ${imageName} \$dockerHubUser/${imageName}:${tag}"
        sh "docker push \$dockerHubUser/${imageName}:${tag}"
    }

    echo "✅ Pushed image to Docker Hub successfully"
}
