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

        stage('Pruebas') {
            steps {
                
                echo 'Realizando Pruebas...'
                
                withGradle{
                     sh './gradlew clean test'        
                }             
            }
            post{
                always{
                    junit '**/test/TEST-com.viewnext.hellofinal.HelloFinalApplicationTests.xml'
                    jacoco execPattern:'**/jacoco/*.exec'
                }                
            }
        }

        stage('Analysis QA'){
            steps{

                echo 'Realizando Validacion...'

                withGradle{
                    sh './gradlew check'
                }
            }

            post{
                always{
                    recordIssues(
                        tools: [
                            pmdParser(pattern: '**/pmd/*.xml'),
                            spotBugs(useRankAsPriority: true, pattern: '**/spotbugs/*.xml')
                        ],
                        enabledForFailure: true
                    )
                }
            }
        }

        /*stage('Lanzando Pitest'){
            steps{
                withGradle{
                    sh './gradlew pitest'
                }
                
            }
            post{
                always{
                    recordIssues(
                        enabledForFailure: true, 
                        tool: pit(pattern: '/pitest//*.xml') // Acoerdarse volver a poner ** antes de /pitest y despues de /pitest/
                    )
                }
            }
        }*/

        stage('Construcción del proyecto') {
            steps{
                echo 'Construyendo...'
                sh 'docker-compose build'               
            }    
        }

        stage('Seguridad') {
            steps{
                echo 'Comprobando seguridad...'
                sh 'trivy image --format=json --output=trivy-image.json hello-final:latest'
            }
            post{
                always{
                    recordIssues(
                            tool: trivy(pattern: 'trivy-image.json'),
                            enabledForFailure: true,
                            aggregatingResults: true
                    )
                }
            } #P
        }

        stage('Guardar Imagn GitLab'){
            steps{
                script{
                    withDockerRegistry([url:'http://10.250.11.3:5050',credentialsId:'deployToken']) {
                        sh "docker tag hello-final:latest 10.250.11.3:5050/vurvachov/hello-final/hello-final:1.0.${env.BUILD_NUMBER}"
                        sh "docker push 10.250.11.3:5050/vurvachov/hello-final/hello-final:1.0.${env.BUILD_NUMBER}"
                        
                        sh "docker image rm -f 10.250.11.3:5050/vurvachov/hello-final/hello-final:1.0.${env.BUILD_NUMBER}"
                        sh "docker image rm -f hello-final:latest"
                    } 
                }

            }
                                                                    
        }

        stage('Despliege') {
            steps{
                sshagent(credentials: ['appKey']) {
                    sh "ssh -o StrictHostKeyChecking=no app@10.250.11.3 'cd hello-final && docker-compose pull && docker-compose up -d'"
                }
            }  
        }
    }
}