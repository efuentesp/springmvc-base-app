FROM tomcat:8.5.11-jre8
COPY /target/SADF.war /usr/local/tomcat/webapps/SADF.war
