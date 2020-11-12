final isThereAConexion( def host){    
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
   
    stage('Snyk verify') {
       if(isThereAConexion('https://snyk.io')){
          snykSecurity additionalArguments: '--debug', snykInstallation: 'Snyk', snykTokenId: 'SNYK_TOKEN'
       }else{
          echo "Skipped, no connection to snyk.io"
          currentBuild.result = 'UNSTABLE'
       }
    }
}
