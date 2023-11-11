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
                    sh 'docker build -t devops_project_bilel:2.1 .'
                }
            }
        }


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
       
      
        
    }
}
