def world() {
    echo("Hello, World!")
} 

def npm_do() {
   sh('npm ci')
   sh('npm run build')
}