pipeline {
    agent any
    stages {
        stage("git") {
            steps {
                // Checkout code from the 'main' branch of the GitHub repository
                script {
                    def gitBranch = 'main'
                    def gitRepoUrl = 'https://github.com/Rosenrot3585/CI_Globant_EGG.git'
                    git branch: gitBranch, url: gitRepoUrl
                }
                // Navigate to the subdirectory where the Java file is located
                dir('src') {
                    // Compile the Java source code
                    sh "javac -cp . App.java"

                    // Execute the compiled Java program
                    sh "java -cp . App"
                }
            }
        }
        // You can define more stages for build, test, and deployment here
    }
}
