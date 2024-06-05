#!/usr/bin/env groovy

// ocCredentialsID 'openshift'
def call() {

    // login to oc Cluster
    //withCredentials([usernamePassword(credentialsId: "openshift", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
    //   sh "oc login https://api.ocp-training.ivolve-test.com:6443 --username=${USERNAME} --password=${PASSWORD} "
    //}

     withCredentials([string(credentialsId: 'saTocken', variable: 'OpenShift_CREDENTIALS')]) {
    // Login to OpenShift using the service account token
         sh "oc login https://api.ocp-training.ivolve-test.com:6443 --token=${OpenShift_CREDENTIALS} --insecure-skip-tls-verify "
     }
    // Deploy the image on the project
    sh "oc apply -f deployment.yml"
    sh "oc apply -f service.yml"
    
}
