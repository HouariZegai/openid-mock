pipeline {
    agent {
        docker {
            image "maven:3.8.4-openjdk-17-slim"
            label "docker"
        }
    }

    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'skip tests')
    }

    stages {

        stage("build") {
            steps {
                echo "building the app version: ${VERSION}"
                sh "mvn -version"
                sh "mvn clean install"
            }
        }

        stage("test") {
            when {
                expression {
                    params.executeTests
                }
            }
            steps {
                echo 'test the app..'
            }
        }

        stage("deploy") {
            steps {
                echo 'deploy the app..'
                withCredentials ([
                    usernamePassword(credentialsId: 'server-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')
                ]) {
                    echo "my script here ${USER} ${PASS}"
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}