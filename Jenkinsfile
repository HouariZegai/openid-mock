pipeline {

    agent any
    environment {
        NEW_VERSION = '1.3.0'
    }
    stages {

        stage("build") {
            steps {
                echo 'build the app..'
                echo "building version ${NEW_VERSION}"
            }
        }

        stage("test") {
            when {
                expression {
                    BRANCH_NAME == 'dev' || BRANCH_NAME == 'master'
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
                    usernamePassword(credentials: 'server-credentials', usernameVariable: USER, passwordVariable: PASS)
                ]) {
                    sh "my script here ${USER} ${PASS}"
                }
            }
        }
    }

    post {
        always {

        }

        failure {

        }
    }

}