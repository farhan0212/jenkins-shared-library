def world() {
    echo("Hello, World!")
} 

def npm_install() {
    echo(message: 'Running installation node modules')
    sh('npm install')
    echo(message: 'post installation node modules')
}