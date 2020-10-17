node {
    stage('Checkout') {
        checkout scm
    }
    
    stage('Download Snyk CLI') {
            sh '''
                latest_version=$(curl -Is "https://github.com/snyk/snyk/releases/latest" | grep "Location" | sed s#.*tag/##g | tr -d "\r")
                echo "Latest Snyk CLI Version: ${latest_version}"
                snyk_cli_dl_linux="https://github.com/snyk/snyk/releases/download/${latest_version}/snyk-linux"
                echo "Download URL: ${snyk_cli_dl_linux}"
                curl -Lo ./snyk "${snyk_cli_dl_linux}"
                chmod +x snyk
                ls -la
                ./snyk -v
            '''
    }

    // Run snyk test to check for vulnerabilities and fail the build if any are found
    // Consider using --severity-threshold=<low|medium|high> for more granularity (see snyk help for more info).
    stage('Snyk Test using Snyk CLI') {
            sh './snyk test --json'
    }

    /*stage('Snyk verify') {
        snykSecurity additionalArguments: '--docker kariae/symfony-php', snykInstallation: 'Snyk', snykTokenId: 'SNYK_TOKEN'
    }*/
}
