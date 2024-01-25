pipeline {
    agent any
    tools { 
        maven 'Maven_3.9.6' 
        jdk 'jdk17' 
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
                    sh 'mvn clean compile'
                }
                echo 'Compile Stage completed'
            }
        }
        stage('Test') {
            steps {
                echo 'Starting Test Stage'
                dir('Sums') {
                    sh 'mvn test'
                }
                echo 'Test Stage completed'
            }
        }
        //you can add more stages like deployment, SonarQube scan etc.
    }
    post {
        always {
            echo 'Jenkins Pipeline completed'
        }
    }
}
