pipeline {
    agent any

    environment {
        IMAGE_NAME = "bkapadia04/calculator-spe-mini-project"
        IMAGE_TAG  = "latest"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/BKAPADIA04/calculator-spe-mini-project.git'
            }
        }
        stage('Run tests') {
             steps {
               sh 'mvn test'
            }
        }

        stage('Check Docker') {
            steps {
                echo 'Checking Docker version...'
                sh '''
                    docker --version
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
           }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials',
                                                 usernameVariable: 'DOCKER_USER',
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                        docker push ${IMAGE_NAME}:${IMAGE_TAG}
                    '''
                }
            }
        }

        stage('Ansible Deployment'){
          steps{
             sh 'ansible-playbook -i inventory.ini deploy.yml'
          }
        }
    }
    post {
            success {
                echo "✅ Pipeline completed successfully! Image pushed to Docker Hub: ${IMAGE_NAME}:${IMAGE_TAG}"
            }
            failure {
                echo "❌ Pipeline failed! Please check the logs."
            }
        }
}