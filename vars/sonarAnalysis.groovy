#!usr/bin/env groovy
def call() {

      //Sonar_Analysis
      withSonarQubeEnv(installationName: 'sonarqube-server') { 
      //sh './gradlew clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
       sh './gradlew sonarqube'
      }
}





