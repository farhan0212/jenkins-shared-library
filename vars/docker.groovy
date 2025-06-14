def call(credentialsId, imageName, buildNumber){
        echo("image name = ${imageName}")
        echo("build number = ${buildNumber}")
        sh("docker build -t ${imageName}:${buildNumber} .")

        withCredentials([usernamePassword(
            credentialsId: credentialsId,
            usernmameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )])
        
        sh("echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin")
        sh("docker push ${imageName}:${buildNumber}")
}