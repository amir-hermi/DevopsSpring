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
        stage('SonarQube Analysis') {
            def mvn = tool 'Default Maven';
            withSonarQubeEnv() {
            sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=sonarSpring -Dsonar.projectName='sonarSpring'"
    }
  }
    }
}


    }
}

