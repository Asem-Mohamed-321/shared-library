#!/usr/bin/env groovy

// ocCredentialsID 'openshift'
def call() {


     withCredentials([string(credentialsId: 'jsa2', variable: 'OC_TOKEN')]) {
    // Login to OpenShift using the service account token
         sh "oc login https://api.ocp-training.ivolve-test.com:6443 --token=${OC_TOKEN} --insecure-skip-tls-verify "
     }
    // Deploy the image on the project
    sh "oc apply -f deployment.yml"
    sh "oc apply -f service.yml"
    
}
