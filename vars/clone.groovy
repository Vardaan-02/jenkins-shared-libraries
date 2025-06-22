def call(String url, String branch){
  echo "Cloning the Code"
  git url: url, branch:branch
  echo "Code Cloned"
}
