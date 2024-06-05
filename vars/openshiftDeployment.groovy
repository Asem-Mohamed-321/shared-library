#!/usr/bin/env groovy

// ocCredentialsID 'openshift'
def call() {

    // login to oc Cluster
    withCredentials([usernamePassword(credentialsId: "openshift", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        sh "oc login https://api.ocp-training.ivolve-test.com:6443 --username=${USERNAME} --password=${PASSWORD} "
    }

    // Deploy the image on the project
    sh "oc apply -f deployment.yml"
    
}
