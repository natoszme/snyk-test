node {
    stage('Checkout') {
        checkout scm
    }

    stage('Snyk verify') {
        snykSecurity additionalArguments: '--docker productecaregistry.azurecr.io/producteca/web-client:28f068880685e1790359491544f254d8c8c0156f', snykInstallation: 'Snyk', snykTokenId: 'SNYK_TOKEN'
    }
}
