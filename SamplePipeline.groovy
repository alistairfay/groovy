pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/alistairfay/groovy.git']]])
            }
        }
        stage('Run') {
            steps {
                echo 'Running..'
                sh 'chmod 700 hello-world.sh
                ./hello-world.sh'
            }
        }
    }
}