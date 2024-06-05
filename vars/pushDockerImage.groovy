#!usr/bin/env groovy
def call(String imageName) {

	// Log in to DockerHub 
	withCredentials([usernamePassword(credentialsId: "dockerhub", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
		sh "docker login -u ${USERNAME} -p ${PASSWORD}"
        }
        
        // Build and push Docker image
        echo "Pushing Docker image..."
        sh "docker push asemmohamed321/${imageName}:${BUILD_NUMBER}"	 
}
