#!/usr/bin/env groovy
pipeline {
    agent any
    options {
        ansiColor('xterm')
    }

    stages {
        stage('Construcción del proyecto') {
            steps{
                echo 'Construyendo...'
                sh 'docker-compose build'               
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