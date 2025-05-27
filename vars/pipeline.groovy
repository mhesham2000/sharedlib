
def call(script){

	script.node('agent1'){
		script.stage('Checkout App') {
   		   script.checkout script.scm
 		   }
	script.withCredentials([
		string(credentialsId: 'dockerhub-user', variable: 'DOCKER_USER'),
		string(credentialsId: 'dockerhub-password', variable: 'DOCKER_PASSWORD')

			]){
			
		 script.stage('Build Docker image') {
           		    script.sh "docker build -t mhesham2000/pythonhub:${env.BUILD_NUMBER} ."
   					     }

    	   	 script.stage('Push Docker image') {
        		    script.sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASSWORD}"
          		    script.sh "docker push mhesham2000/pythonhub:${env.BUILD_NUMBER}"
      						  }
		  		}
}


}