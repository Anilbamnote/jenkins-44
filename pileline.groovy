pipeline {
    agent any
    stages {
        stage('pull-stage') {
            steps {
                echo "pull stage sucess"
            }
        }
        stage('Build') {
            steps {
                echo " build sucess"
            }
        }
        stage('test') {
            steps {
                echo "test suecss"
            }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}