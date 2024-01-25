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
                    bat 'mvn clean compile'  // Use bat instead of sh
                }
                echo 'Compile Stage completed'
            }
        }
        stage('Test') {
            steps {
                echo 'Starting Test Stage'
                dir('Sums') {
                    bat 'mvn test'  // Use bat instead of sh
                }
                echo 'Test Stage completed'
            }
        }
    }
    post {
        always {
            echo 'Jenkins Pipeline completed'
        }
    }
}
