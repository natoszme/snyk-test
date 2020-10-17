node {
    stage('Checkout') {
        checkout scm
    }

    stage('Snyk verify') {
        snykSecurity snykInstallation: 'Snyk', snykTokenId: 'SNYK_TOKEN'
    }
}
