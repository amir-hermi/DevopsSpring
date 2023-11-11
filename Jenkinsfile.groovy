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
        stage('Maven clean/Compile') {
            steps {
                script {
                    sh 'mvn clean compile verify'
                }
            }
        }
        stage('Maven test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Sonar Analysis') {
            steps {
                withSonarQubeEnv('sonarSpring') {
                script {
                    sh 'mvn sonar:sonar'
                }
                }
            }
        }
        stage('Maven package') {
            steps {
                script {
                    sh 'mvn package -DskipTests'
                }
            }
        }
        stage('Nexus Deployement') {
            steps {
                script {
                    sh 'mvn deploy -DskipTests'
                }
            }
        }
       
      
        
    }
}
