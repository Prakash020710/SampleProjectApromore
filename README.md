# SampleProjectApromore
This application exposes api to process enrolment for student.
It have 3 GET apis to enrol student, get student and delete enrolment

# Specifications
This Micro service is developed using JDK 1.8, h2 (in memory) database, flyway migration, gradle, spring boot, jpa etc.

# Running locally
Please clone the repo on your local and run below command.

* gradle clean build : This will clean and build the package including running tests

* gradle bootRun --args='--spring.profiles.active=h2' : This will spin up the server.

Once server is up, apis can be accessed via swagger ui using [path](http://localhost:8013/api/apm/swagger-ui/index.html) 

Database can be accessed via [Path](http://localhost:8013/api/apm/h2-console/login.do) . 

Please note as its in memory database it will have data till server is running, post shutdown it will be no longer accessible

To generate the swagger, you access it using [Path](http://localhost:8013/api/apm/v2/api-docs)

# Limitation
Student id should be genrated using a sequence, at the moment it is genrated using timestamp and random number.
student id and enrolment id should be used as foreign key in enrolment table to prevent deletion.


