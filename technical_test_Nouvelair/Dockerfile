# select parent image
FROM maven:3.8.3-jdk-11
 
# copy the source tree and the pom.xml to our new container
COPY ./ ./

CMD ["mvn", "spring-boot:run"]

