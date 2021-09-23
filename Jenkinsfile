
pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                echo 'Clean install being done!'
                sh 'mvn clean install'
            }
        }
    }
}