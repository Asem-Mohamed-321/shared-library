#!/usr/bin/env groovy

// ocCredentialsID 'openshift'
def call(String imageName) {


     withCredentials([string(credentialsId: 'jsa2', variable: 'OC_TOKEN')]) {
     // Login to OpenShift using the service account token
        sh "oc login https://console-openshift-console.apps.ocp-training.ivolve-test.com/  --token=${OC_TOKEN} --insecure-skip-tls-verify "
    }

     sh "sed -i 's|image:.*|image: ${imageName}:${BUILD_NUMBER}|g' deployment.yml"  // change the image tag in the deployment file
     
    // Deploy the image on the project
    sh "oc apply -f deployment.yml -n asemmohamed"
    sh "oc apply -f service.yml -n asemmohamed"
    
}
