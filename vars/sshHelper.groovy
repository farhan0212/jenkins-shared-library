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