
def call(){
	pipeline{
	agent any

	environment{
		DOCKER_USER = credentials('dockerhub-user')
		DOCKER_PASSWORD = credentials('dockerhub-password')
		}
	
	stages{
		stage("build Docker image"){
			steps{
				sh 'docker build -t mhesham2000/pythonhub:${BUILD_NUMBER} .'
				}
					}


			
		}
	}


}