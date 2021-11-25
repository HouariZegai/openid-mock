pipeline {
    agent any
    tools {
        maven
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: 'skip tests')
    }
    stages {

        stage("build") {
            steps {
                echo 'build the app..'
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
                    sh "my script here ${USER} ${PASS}"
                }
            }
        }
    }
}