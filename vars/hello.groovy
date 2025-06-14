def world() {
    echo("Hello, World!")
} 

def npm_do() {
   sh('npm ci')
   sh('npm run build')
}

def docker_build(imageName, buildNumber){
    echo('image name = ${imageName}')
    echo('build number = ${buildNumber}')
    sh('docker build -t ${imageName}:${buildNumber}')
}