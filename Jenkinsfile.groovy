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
        /*
        stage('Maven clean/Compile') {
            steps {
                script {
                    sh 'mvn clean compile verify'
                }
            }
        }
        */
         stage('Maven package') {
            steps {
                script {
                    sh 'mvn package -DskipTests'
                }
            }
        }
      
      stage('MVN SONARQUBE') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=213JMT5123T99 -Dmaven.test.skip=true'
            }
        }
         stage('Publish to Nexus') {
             steps {
                sh "mvn deploy -DskipTests"
        
                }
            }
        
         stage('Maven test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        

        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t bilel656/devops_project .'
                }
            }
        }

        stage('Run Docker Compose') {
            steps {
                script {
                    sh "docker compose up -d"
                }
            }
        }

       
/*
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    sh "docker login -u bilel656 -p 213JMT5123T99"
                    sh "docker push bilel656/devops_project"
                }
            }
        }
*/
/*
        stage('GRAFANA') {
    steps {
        script {
            def grafanaUrl = 'http://192.168.0.18:3000'
            def username = 'admin'
            def password = '213JMT5123T99'
            
            sh "curl -u $username:$password -X POST $grafanaUrl/api/dashboards/db -d @grafana_dashboard.json"
        }
    }
}
*/
       
      
        
    }
}
