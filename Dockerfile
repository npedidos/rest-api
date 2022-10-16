# Stage 1
FROM maven:3.8.5-openjdk-17 as stage1
# [optimization] speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /opt/rest-api-app
# [optimization] I am copying just the pom.xml file using the COPY instruction. Why? Because this file has a smaller rate of change compared to the .java project files.
COPY pom.xml .
# go-offline using the pom.xml
RUN mvn dependency:go-offline
COPY ./src ./src
# compile the source code, package it in a war file + generate server in target/server
RUN mvn clean package -Dmaven.test.skip=true

# Stage 2
FROM quay.io/wildfly/wildfly-runtime-jdk17
COPY --from=stage1 --chown=jboss:root /opt/rest-api-app/target/server $JBOSS_HOME
RUN chmod -R ug+rwX $JBOSS_HOME
