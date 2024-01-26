pipeline {
    agent any
    tools { 
        maven 'Maven-3.9.6' 
        jdk 'jdk17' 
    }
    triggers { 
        pollSCM('H/15 * * * *')  // Polls every 15 minutes
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Starting Checkout Stage'
                checkout scm
                echo 'Checkout Stage completed'
            }
        }

        stage('Compile') {
            steps {
                echo 'Starting Compile Stage'
                dir('Sums') {
                    bat 'mvn clean compile'
                }
                echo 'Compile Stage completed'
            }
        }

        stage('Test') {
            steps {
                echo 'Starting Test Stage'
                dir('Sums') {
                    bat 'mvn test'
                }
                echo 'Test Stage completed'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    dir('Sums') {
                        bat 'mvn clean verify org.jacoco:jacoco-maven-plugin:prepare-agent install sonar:sonar'
                    }
                }
            }
        }

/*
        stage('Quality Gate') {
            steps {
                timeout(time: 300, unit: 'SECONDS') {
                }
                waitForQualityGate abortPipeline: true
            }
        }
*/
        stage('Build') {
            steps {
                dir('Sums') {
                    echo "Creating the WAR file..."
                    bat 'mvn package -DskipTests'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying to Tomcat'
                script {
                    deploy adapters: [tomcat9(credentialsId: 'tomcat', path: '', url: 'http://localhost:9090/')], contextPath : 'Sums', war : '**/*.war'
                }
            }
        }
    }

    post {
        always {
            echo 'Jenkins Pipeline completed'
        }
    }
}
