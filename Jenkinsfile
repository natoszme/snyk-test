node {
    stage('Checkout') {
        checkout scm
    }

    stage('Snyk verify') {
        snykSecurity snykInstallation: 'Snyk Latest', snykTokenId: 'SNYK_TOKEN', targetFile: './server'
    }
}