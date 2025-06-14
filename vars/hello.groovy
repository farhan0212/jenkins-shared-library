def world() {
    echo("Hello, World!")
} 

def npm_install() {
    echo(message: 'Running installation node modules')
    sh('npm install')
    sh('npm run build')
    echo(message: 'post installation node modules')
}