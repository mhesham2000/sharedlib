package org.lab3;

def login(USERNAME , PASSWORD) {
	sh "docker login -u ${USERNAME} -p ${PASSWORD}"
}

def buildDockerImage(IMAGE_NAME , IMAGE_TAG){
	sh 'docker build -t ${IMAGE_NAME}:${IMAGE_TAG} .'
}

def dockerPush(IMAGE_NAME){
	sh 'docker push ${IMAGE_NAME}:${BUILD_NUMBER}'
}




