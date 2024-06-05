#!usr/bin/env groovy
def call(String imageName) {

        // Build and push Docker image
        echo "Building Docker image..."
        sh "docker build -t asemmohamed321/${imageName}:${BUILD_NUMBER} ."
 
}
