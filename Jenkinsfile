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

        stage('Setup Python Virtualenv') {
                    steps {
                        sh '''
                        python3 -m venv ~/ansible-venv
                        source ~/ansible-venv/bin/activate
                        pip install --upgrade pip
                        pip install ansible requests docker
                        '''
                    }
                }

        stage('Ansible Deployment'){
          steps{
             sh '''
                             source ~/ansible-venv/bin/activate
                             ansible-playbook -i inventory.ini deploy.yml
                             deactivate
                             '''
          }
        }
    }
    post {
        success {
            mail to: 'bkapadia04@gmail.com',
                 subject: "✅ Jenkins Pipeline Succeeded: ${currentBuild.fullDisplayName}",
                 body: """
                 <html>
                 <body style="font-family: Arial, sans-serif; color: #333;">
                     <h2 style="color: green;">Pipeline Succeeded ✅</h2>
                     <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                     <p><strong>Build #:</strong> ${env.BUILD_NUMBER}</p>
                     <p><strong>Status:</strong> SUCCESS</p>
                     <p>View build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                 </body>
                 </html>
                 """,
                 mimeType: 'text/html'
        }

        failure {
            mail to: 'bkapadia04@gmail.com',
                 subject: "❌ Jenkins Pipeline Failed: ${currentBuild.fullDisplayName}",
                 body: """
                 <html>
                 <body style="font-family: Arial, sans-serif; color: #333;">
                     <h2 style="color: red;">Pipeline Failed ❌</h2>
                     <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                     <p><strong>Build #:</strong> ${env.BUILD_NUMBER}</p>
                     <p><strong>Status:</strong> FAILURE</p>
                     <p>Check build details: <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                 </body>
                 </html>
                 """,
                 mimeType: 'text/html'
        }
    }
}