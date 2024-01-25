# Task-1-Jenkins

1. Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and developer user (build job, cancel builds). Add Jenkins credentials to Readme file in your git repository.  (20 points)
   - admin:
       - username: admin
       - password: admin
    - developer:
        - username: developer
        - password: developer


![image](https://github.com/DerekAyala/Task-1-Jenkins/assets/89038565/4cd16949-0dc4-41cf-85a7-0fbce6226261)

3. Configure Jenkins build job (poll, run test, build) to checkout your repository, use polling interval. (20 points)

4. Install SonarQube. Configure Jenkins to use local SonarQube installation. Analyze your source code with SonarQube after Maven builds your project. Use JaCoCo for code coverage. (30 points)

5. Jenkins should deploy your application (after passing SonarQube quality gate) under your local tomcat server. Please use Deploy to container Plugin. (max - 30 points, If an optional task is completed, then for this task a max - 20 points)

6. (Optional task) Create a Pipeline to complete the above tasks (build, run SonarQube, deploy to Tomcat). Jenkinsfile should be committed to the GitHub repository and pulled up from there. Try out Blue Ocean plugin for pipelines. (max - 10 points)

## General requirements

1. Jenkins have to build your project according to the Maven/Gradle build script.

2. Project is deployed at your local Tomcat Server by Jenkins job.

3. Jenkins should be integrated with SonarQube.

## Application requirements

- Build tool: Maven/Gradle.
- Tomcat Server - should be installed as Service and start automatic.
- Unit testing framework: JUnit (the latest version).
- Database: MySQL or PostgreSQL (the latest version).
- Continuous Integration server: Jenkins LTS
- Code analysis tool: SonarQube
