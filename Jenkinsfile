#!/usr/bin/env groovy
pipeline {

    agent any
    options {
        ansiColor('xterm')
    }

    tools {
        jdk 'JDK16'
    }

    stages {
        stage('Construcción del proyecto') {
            steps{
                echo 'Construyendo...'
                sh 'docker-compose build'               
            }    
        }

        stage('Guardar Imagn GitLab'){
            steps{
                script{
                    withDockerRegistry([url:'http://10.250.11.3:5050',credentialsId:'deployToken']) {
                        sh "docker tag hello-final:latest 10.250.11.3:5050/vurvachov/hello-final/hello-final:${env.BUILD_NUMBER}"
                        sh "docker push 10.250.11.3:5050/vurvachov/hello-final/hello-final:${env.BUILD_NUMBER}"
                        
                        sh "docker image rm -f 10.250.11.3:5050/vurvachov/hello-final/hello-final:${env.BUILD_NUMBER}"
                        sh "docker image rm -f hello-final:latest"
                    } 
                }

            }
                                                                    
        }

        stage('Pruebas del proyecto') {
            steps{
                echo 'Probando....'
            }
        }

        stage('Despliegue del proyecto') {
            steps{
                echo 'Desplegando...'
                sh 'docker-compose up -d'               
            }    
        }
    }
}