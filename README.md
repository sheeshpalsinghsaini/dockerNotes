# dockerNotes

## What is Docker ?

    Docker is the concept of contanerization of software configuration. where we store 
    software related configuration and we can run that one any one machine or server without
    worry.

    It includes Docker client, Docker server, Docker machine, Docker hub, Docker compose etc.


## Why we use Docker ?

    Docker makes it really easy to install and run software
    without worring about setup or dependencies.




### Flow of installing a software 

                installing software
              |---------------------
              |  Download installer
              |---------------------
              |  Run installer
              |---------------------
              | Get an error msg
              |  during installation
              |=====================
              | Troubleshoot issue      <--|
              |=====================       |
              | Return installer           |
              |---------------------       |
              | Get Another error ---------|
              
              

    This is what Docker is trying to fix.

------------------------------------------------------------------------

# Docker Ecosystem :

        ---------------------------------
       |  Docker Client | Docker Server  |
       | -------------- | -------------  |
       |  Docker Machine| Docker images  | ===> Docker is a platform or ecosystem round creating and  
       | -------------  | -------------  |      running containers.
       | Docker Hub     | Docker Compose |
        ---------------------------------


##  What is container 
        - Running image in memory called continer.

     -------
    | image | =======> single file with all the deps and config required to run a program.
     -------
        |
        |===============> instance of an image Run a program.[Container.]


    

# Docker instalation :


                        Docker for 
                        Window/Mac
                 --------------------
                |                    |
                |    Docker Client   |   ==> Tool that we are going to issue commands to 
                |    Docker CLI      |
                |--------------------
                |                    |
                |    Docker Server   |   ==> Tool that is responsible for creating images, running containers, etc.
                |   (Docker Daemon)  |   
                |                    |
                 --------------------


docker version 

    Client: Docker Engine - Community               // local machine 
    Cloud integration: v1.0.28
    Version:           20.10.17
    API version:       1.41
    Go version:        go1.17.11
    Git commit:        100c701
    Built:             Mon Jun  6 23:02:46 2022
    OS/Arch:           linux/amd64
    Context:           default
    Experimental:      true





    Server: Docker Engine - Community               // run in virtual environment, daemon
    Engine:
    Version:          20.10.17
    API version:      1.41 (minimum version 1.12)
    Go version:       go1.17.11
    Git commit:       a89b842
    Built:            Mon Jun  6 23:00:51 2022
    OS/Arch:          linux/amd64
    Experimental:     false
    containerd:
    Version:          1.6.7
    GitCommit:        0197261a30bf81f1ee8e6a4dd2dea0ef95d67ccb
    runc:
    Version:          1.1.3
    GitCommit:        v1.1.3-0-g6724737
    docker-init:
    Version:          0.19.0
    GitCommit:        de40ad0



## Docker Client and Docker Server 

    -> Docker client is a tool we issue commands to for reaching out to docker daemon.

    -> The Docker daemon is a service that runs on your host operating system. It is 
        responsible for runing containers.



    Docker Client    ================>      Docker Server
       (CLI)                                    (Daemon)


       Docker Hub : Online repo.
       cache : local memory for instance access.




    ----------------------------- some commands 

    docker run hello-world              // run docker hello-world image.

    // if image not present then it pull from docker hub.

output of above command :

    Unable to find image 'hello-world:latest' locally
    latest: Pulling from library/hello-world





##  Image & Container :

    Image :

        -> is a set of configuration file for generate a specific container.

        ----------------------------------------------
        |                     image                  |
        ----------------------------------------------     
        | file system snapshot  |   startup commands |
        |--------------------------------------------|
        | bin,lib,chrome.doc    |   chrome.exe       |
        |---------------------------------------------

        File system snapshot : is required file to run a specific software like bin, xml ,doc, lib etc.
        startup command : help to launch the software.
        
        when run this image kernal allocate some resource to it. 
        this running instance of image called container. this container contain
        


    Container :
        -> container create by image.
        -> is a running instance of image which occupie resource as per 
            image configuration.



## Namespacing and Control groups :

    Namespacing : isolation of resource by process.
    
    Control gorups : Limit resources per process.




docker run busybox 

docker run busybox echo hello sheeshpal             // run echo command as default startup command.

docker run busybox ping google.com

docker run busybox ls           //list all dir of container.


docker ps                       // show all running container 

CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
 

docker ps --all            // show all container which is running or stop.


docker stop containerId         // stop container.


--------------------------------------------------------------------------------
we can override the startup command 


docker run command create by two command 

    docker run = docker create + docker start
                       |            |
                       |            |-> start docker
                       |
                       |-> create docker  
                        
                        
    docker create hello-world               //create container of hello-world

    docker start -a <string:op of docker create>
    //-a/attach show the output.





-------------------------------------------------------------------------------

docker logs containerId                     // print logs of running container.



docker kill contaienrId             // forcefully stop container.



docker exec -i -t containerId  sh           //inside in container.

-i => interactive mode 
-t => formate


ctrl +d   // exit.






-------------------------------------------------------------------------------------------

* Dockerfile, Image and Container

    Dockerfile 
        Text document which contains all the commands that a user can call on the command line to assemble 
        an image.

    Docker Image 
        Template to create docker container. [ just like a class of an object in oops programming ]


    Docker Container 
        Running instance of the docker image. Containers hold entire package to run application.
        [ running image is a container ]



    Ex:
        DockerFile --------> DockerImage -----------> DockerContainer




## Docker Commands 

    1. Docker version

    2. Docker pull <dockerImageName> : download docker image from docker hub
        Docker pull mysql
        Docker pull tomcat
        Docker pull openjdk
        docker pull openjdk:11
        docker pull python:3
    3. Docker images : show all available images in local

    4. docker search <imageName> : will search image

    5. docker ps : show all running containers

    6. docker ps -a : show all running and exit containers.

    7. docker run --env MYSQL_ROOT_PASSWORD      : to provide environment property 

    8. docker run --name pythonContainer -d  python      : will return container id
                                          \_ use for detach mode
    
    9. docker run --name pythonContainer_01 -it -d python       : now container will run in background.
                                              \_ interactive mode

    10. docker exec -it <containerId> python3       : now we will be inside container with python shall.
        docker exec -it 26f9cf0e5101 python3

    11. exit()      : exit from python container.

    12. docker inspect <containerId> : will show all details about container.

    13. docker run --name javaContainer -it -d openjdk  : run openjdk container

        CONTAINER ID   IMAGE     COMMAND     CREATED         STATUS         PORTS     NAMES
        9215cc3d8e98   openjdk   "jshell"    5 seconds ago   Up 4 seconds             javaContainer
        26f9cf0e5101   python    "python3"   7 minutes ago   Up 7 minutes             pythonContainer_01
                                    |
                                     \_ command which we have to exe for run inside container.


    14. docker exec -it 9215cc3d8e98 jshell
        /exit   : exit from openJDK contianer.

    15. docker run --name mysqlDB -e MYSQL_ROOT_PASSWORD=root -d mysql  : running mysqlDB[name of container] container.

        docker exec -it mysqlDB bash
        mysql -p : provide mysql password, which provide at the time of creating container.
        jdbc:mysql://db:3306/DATABASE-NAME  : jdbc:mysql://mysqlDB:3306/DATABASE-NAME.
                     |
                      \_ mysql Container name.

    16. docker run --name nginxServer -d -p 8080:80 nginx 
                                            |     |
                                            |      \_Container port  mapping.
                                             \_ System port

    17. docker run --name httpdServer -d -p 8081:80 httpd

    18. docker stop 68b4bbadcd89  : will stop docker-container of given id

    19. docker rm 68b4bbadcd89 bde4ec37d1a7 : remove past showing running container.[ docker ps -a ]

    20. docker rmi openjdk:11   : remove docker image.

    21. docker restart <containerId or name> : restart container, will run stop container.

    22. docker login : docker hub login, so we can push

    23. docker commit : save the image edited or created in local system.

    24. docker push : push docker image to docker hub

    25. docker copy
     
    26. docker log <containerName>

    27. docker volume : create docker volume to store data for docker container.

    28. docker logout : logout from docker hub





----------------------------------------------------

## create our own docker image.


    
    1. create ubuntu docker image 
        docker build -t myubuntuimage .  [ using current folder]

    2. docker run --name myUbuntuContainer_01 myubuntuimage : running creating docker image

-------------------
    docker build -t myjavaproject .
    docker run --name javaProject myjavaproject

-------------------

    docker run --name springBootProject -it -d bootimage


Note : docker logs springBootProject => for check logs
