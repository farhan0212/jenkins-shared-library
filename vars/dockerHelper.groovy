def call(dockerCredentialsId, imageName, buildNumber){
        sh("docker build -t ${imageName}:${buildNumber} .")

        withCredentials([usernamePassword(
            credentialsId: dockerCredentialsId,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]){
            sh("echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin")
            sh("docker push ${imageName}:${buildNumber}")
        }
}

def hello(){
    sh(" echo hello world")
}