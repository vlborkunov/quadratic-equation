FROM tomcat:10
MAINTAINER Borkunov Vladimir <vlborkunov@gmail.com>

ARG WAR_FILE=build/libs/*.war
COPY ${WAR_FILE} /usr/local/tomcat/webapps/ROOT.war

CMD ["catalina.sh", "run"]