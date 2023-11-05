pipeline {
    agent any
    stages {
        stage('Pulling..') {
            steps {
                script {
                    git branch: 'bilel',
                    credentialsId: 'spring-access-token',
                    url: 'https://github.com/amir-hermi/DevopsSpring.git'
                }
            }
        }
        stage('Maven clean') {
            steps {
                script {
                    sh 'mvn clean'
                }
            }
        }
        stage('Maven Compile') {
            steps {
                script {
                    sh 'mvn compile'
                }
            }
        }
        stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=213JMT5123T99 -Dmaven.test.skip=true'
            }
        }

        stage('MVN Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('MVN NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
    }
}

