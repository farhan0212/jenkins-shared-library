def world() {
    echo("Hello, World!")
} 

def npm_do(List commands) {
   sh('npm ci')
   sh('npm run build')
}