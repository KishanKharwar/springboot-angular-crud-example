Sringboot-Angular-crud-example
===============================
This project is about implementing basic insert and get operation on a springboot backend server having h2 as in-memory database, calling from angular front-end.
And also deploying the springboot-project along side with angular in one war application. 
This project is used in deployment [Angular Form Example][git@github.com:KishanKharwar/angular-form-textbox-submit.git]
# Basic logic to connect angular-ui with springboot backend
For basic understanding please follow this link [Baeldung Springboot Angular][https://www.baeldung.com/spring-boot-angular-web]

# Installing and Deploying Applications to JBoss/WildFly server : 
1. Download JBOSS file from here [Wildfly Server][https://www.wildfly.org/downloads/]
1. Extract and run `standalone` batch file from `bin` directory
1. For deployment of any project :
    1. For Java-Springboot project deployment
        1. run `mvn clean package`
        1. take jar/war file from `{project.dir}/target` folder
        1. copy the jar/war and place inside `{jboss/wildfly}/standlone/deployments/{project-name}`
    1. For angular deployment : 
        1. create the project 
        1. build the project to create dist files using command `ng build --prod --base-href /<context-path> --deploy-url /<context-path>` eg. `ng build --prod --base-href /spring-angular --deploy-url /spring-angular`
1. Need to add maven-resource plugin pointing to the front-end/angular files i.e., present in `{project.dir}/src/main/resources/public` folder       
 
# Enabling logger compatible with the jboss/wildfly server
In the project we have followed : 
1. disabled the logger class supported by jboss server by adding a file `src/main/webapp/WEB-INF/jboss-deployment-structure.xml`.
1. added our own `src/main/resources/logback.xml` for enabling the logs. 
1. At jboss level :
    1. need to add the logger level information inside `wildfly-24.0.0.Final/standalone/configuration/standlone.xml`
        ```
        <logger category="com.iedr">
            <level name="INFO"/>
        </logger> 
        ```
    1. log-files will be generated at server level i.e., `wildfly-24.0.0.Final/bin`, here in this project we are extracting the logs in `logs/app.log` file. the same will be present at server layer inside `wildfly/bin` directory.
