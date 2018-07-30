# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="narenrana02@gmail.com"

# Add a volume pointing to /tmp
#VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/sailor-microservice-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# Run the jar file 

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -DMONGO_URL=mongodb+srv://narenrana02:karnal1984@cluster0-szgdc.mongodb.net/test?retryWrites=true -Daws.accessKeyId=AKIAJ5E4F6LRUWGOYLXQ -Daws.secretKey=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 -Daws.region=us-east-1","-jar","/app.jar"]
