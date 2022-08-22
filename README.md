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