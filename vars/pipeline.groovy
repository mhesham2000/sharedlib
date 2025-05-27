
def call(){

	node('agent1'){

	withCredentials([
		string(credentialsId: 'dockerhub-user', variable: 'DOCKER_USER'),
		string(credentialsId: 'dockerhub-password', variable: 'DOCKER_PASSWORD')

			]){
			
		 stage('Build Docker image') {
           		    sh "docker build -t mhesham2000/pythonhub:${env.BUILD_NUMBER} ."
   					     }

    	   	 stage('Push Docker image') {
        		    sh "docker login -u ${DOCKER_USER} -p ${DOCKER_PASSWORD}"
          		    sh "docker push mhesham2000/pythonhub:${env.BUILD_NUMBER}"
      						  }
		  		}
}


}