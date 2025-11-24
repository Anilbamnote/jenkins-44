pipeline {
    agent {label 'slave'}
    stages {
        stage('pull-stage') {
            steps {
                git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('Build') {
            steps {
                sh '/opt/maven/bin/mvn clean package'
            }
        }
        stage('test') {
            steps {
                withSonarQubeEnv(installationName: 'sonar',credentialsId: 'sonar-cred',variable: 'SONAR_CRED') {
                   sh '/opt/maven/bin/mvn sonar:sonar'
               }
                    //  sh '/opt/maven/bin/mvn sonar:sonar -Dsonar.projectKey=studentapp -Dsonar.host.url=http://35.74.27.54:9000  -Dsonar.login=9c547e0733545b5a64a73f56e83c0169e6b5e1d7'
            }
        }
        stage('deploy') {
            steps {
                echo "deploy sucess"
            }
        }
    }
}


// pipeline {
//     agent {label 'slave'}
//     stages {
//         stage('pull-stage') {
//             steps {
//                 echo "git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'"
//             }
//         }
//         stage('Build') {
//             steps {
//                 echo " build sucess"
//             }
//         }
//         stage('test') {
//             steps {
//                 echo "test suecss"
//             }
//         }
//         stage('deploy') {
//             steps {
//                 echo "deploy sucess"
//             }
//         }
//     }
// }