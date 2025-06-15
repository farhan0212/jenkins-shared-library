def docker_build_push(dockerCredentialsId, imageName, buildNumber){
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

def ssh_action(sshCredentials, SSH_USERNAME, SSH_HOST) {
    sshagent(credentials: [sshCredentials]){
        sh'''
            ssh -o StrictHostKeyChecking=no ${SSH_USERNAME}@${SSH_HOST} '
            echo "Running commands on remote server"
            ls -la
            whoami
            '        
            '''
    }
}