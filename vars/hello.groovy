def world() {
    echo("Hello, World!")
} 

def npm_do(List commands) {
    for (command in commands) {
        sh("npm ${command}")
    }
}