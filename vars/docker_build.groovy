def call(String ProjectName, String ImageTag, String DockerHubUser){
  echo "Staring Build"
  sh "docker build -t ${DockerHubUser}/${ProjectName}:${ImageTag} ."
  echo "Image Build Completed"
}
