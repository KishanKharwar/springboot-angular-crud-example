Sringboot-Angular-crud-example
===============================
This project is about implementing basic insert and get operation on a springboot backend server having h2 as in-memory database, calling from angular front-end.
And also deploying the springboot-project along side with angular in one war application. 

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
 
