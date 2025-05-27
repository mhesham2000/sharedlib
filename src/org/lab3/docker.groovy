package org.lab3;

def login(USERNAME , PASSWORD) {
	sh "docker login -u ${USERNAME} -p ${PASSWORD}"
}
