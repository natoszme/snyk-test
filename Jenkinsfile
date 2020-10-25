​final isThereAConexion( def host){    
   try {
        def url = new URL(host)         
        url.getContent()
        return true
    } catch(Exception ex) {
        return false
    }
}
node {
    stage('Checkout') {
        checkout scm
    }
    stage('Priviliges groups') {
        sh 'groups'
    }
    stage('Priviliges groups whoami') {
        sh 'groups `whoami`'
    }
    stage('Priviliges permisos') {
        sh 'ls -l'
    }
    /*stage('Download Snyk CLI') {
            sh '''
                latest_version=v1.414.1
                echo "Latest Snyk CLI Version: ${latest_version}"
                snyk_cli_dl_linux="https://github.com/snyk/snyk/releases/download/${latest_version}/snyk-linux"
                echo "Download URL: ${snyk_cli_dl_linux}"
                curl -Lo ./snyk "${snyk_cli_dl_linux}"
                chmod +x snyk
                ls -la
                ./snyk -v
            '''
    }*/

    // Run snyk test to check for vulnerabilities and fail the build if any are found
    // Consider using --severity-threshold=<low|medium|high> for more granularity (see snyk help for more info).
    /*stage('Snyk Test using Snyk CLI') {
            sh './snyk auth 04dd0216-08cd-4bc1-8b29-15398683eefb'
            //sh './snyk test --docker kariae/symfony-php'
    }*/

    stage('Snyk verify') {
        snykSecurity additionalArguments: '--debug --docker kariae/symfony-php', snykInstallation: 'Snyk', snykTokenId: 'SNYK_TOKEN'
    }
}
