FROM openjdk:11

# working directory
WORKDIR /usr/src/myapp

COPY . /usr/src/myapp/

RUN javac Test.java 

CMD ["java", "Test"]