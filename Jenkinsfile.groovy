pipeline {
    agent any
    stages {
        stage('Pulling..') {
            steps {
                script {
                    git branch: 'master',
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

        stage('MVN NEXUS') {
            steps {
                sh 'mvn deploy -Dmaven.test.skip=true'
            }
        }
    }
}

