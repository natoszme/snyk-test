node {
    stage('Checkout') {
        checkout scm
    }

    stage('Snyk verify') {
        snykSecurity additionalArguments: '--docker kariae/symfony-php', snykInstallation: 'Snyk', snykTokenId: 'SNYK_TOKEN'
    }
}
