#!/usr/bin/env groovy

// KubernetesCredentialsID 'KubeConfig file'
def call(String imageName) {
    
    sh "sed -i 's|image:.*|image: ${imageName}:${BUILD_NUMBER}|g' deployment.yml"  // change the image tag in the deployment file

}
