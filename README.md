# SampleProjectTabcorp1
This application exposes api to process orders for customers.
It also have 3 GET apis to get transactions on the basis of customer, product and country.

# Specifications
This Micro service is developed using JDK 1.8, h2 (in memory) database, flyway migration, gradle, spring boot, jpa etc.

# Running locally
Before cloning you must have gradle and JDK installed on your machine and should be accessible from any location

Please clone the repo on your local and run below command.

* gradle clean build : This will clean and build the package including running tests

* gradle bootRun --args='--spring.profiles.active=h2' : This will spin up the server.

Once server is up, apis can be accessed via swagger ui using [path](http://localhost:8013/api/tas/swagger-ui/index.html) 

Database can be accessed via [Path](http://localhost:8013/api/tas/h2-console/login.do) . 

Please note as its in memory database it will have data till server is running, post shutdown it will be no longer accessible

To generate the swagger, you access it using [Path](http://localhost:8013/api/tas/v2/api-docs)


