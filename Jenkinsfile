
pipeline {
  agent any

  tools {nodejs "20.6.1"}

  stages {


    stage('Postman CLI Login') {
      steps {
        bat 'postman login --with-api-key PMAK-656a2a5afc60c0003135be75-826634f810fb96ceec478e5ae0b3480f3f'
      }
    }

    stage('Running collection') {
      steps {
        bat 'newman run "https://api.getpostman.com/collections/11910468-b34b376d-3830-4708-86d2-c2497e0d847d?apikey=PMAK-656a2a5afc60c0003135be75-826634f810fb96ceec478e5ae0b3480f3f" --environment "https://api.getpostman.com/environments/11910468-0a4b96cc-63ae-4dec-a32f-17510bbd05ce?apikey=PMAK-656a2a5afc60c0003135be75-826634f810fb96ceec478e5ae0b3480f3f" -d "src/test/resources/postmanResource/userInfo.json" -r htmlextra --reporter-htmlextra-export "target/reports/postman.html"'
      }
    }
  }
}