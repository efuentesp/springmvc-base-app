pipeline {
    agent none
    stages {
        stage('Compile & Build') {
            agent {
                docker {
                    image 'maven:3-alpine' 
                    args '-v /root/.m2:/root/.m2' 
                }
            }
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
         stage('Deploy Develop') { 
            agent any
            steps {
                echo "Deploying in development environment"
                sh '(docker stop $(docker ps -q --filter ancestor=sadfback)) || true'
                sh '(docker rmi -f sadfback) || true'
                sh 'docker build -t sadfback .'
                sh 'docker run -d --name back --rm -p 8082:8080 sadfback'
            }
        }

    }
}
