# Synopsis
This project is used to automatically test the CompleteMarketplace

It is written in a BDD style using [cucumber-jvm](https://github.com/cucumber/cucumber-jvm)

# Building
This project is built using a gradle wrapper. This means you do not need anything installed on your machine except a recent java version (~1.8.0...)
 
 All you need to do is checkout the code and in the root of the project run gradlew tasks (./gradlew tasks on a mac or unix) to see a list of available tasks you can run

# Running
To run this project, edit src/main/resources/local-configuration.properties  to fill in the correct settings 

Then, in the root directory run 

`gradlew clean test generateCompleteMarketPlaceJooqSchemaSource cucumber`

 This will generate the needed db files and run all of the cucumber tests in test/resources/
 
 To use one of the other -configuration.xml files such as staging-configuration.xml (see [here](docs/resource_files.md) for some detail on these files) you need to pass a variable to gradle
 
 You need to pass the variable *environment*  which should be set to the initial part of the -configuration.xml filename 
  
  e.g. if you pass -Denvironment=staging it will load it's properties from the file staging-configuration.xml, 
  
  if you passed -Denvironment=production it would try to load production-configuration.xml
  
  If you do not pass any -Denvironment= variable it will use local-configuration.xml by default
    
# Details
The only part of the code you need to work with is the src/ folder, it contains ...

#####main/java/
The main/java structure contains the bulk of the project code.  
It contains both the main logic code and the step classes that map the features to java code (see the cucumber site above for details on this)

#####main/resources/ 
The main/resources structure contains required configs and files  
as well as the *-configuration.properties files
 
See [here](docs/resource_files.md) for details on the resources and properties files  

#####test/java/
The test/java directory contains the unit test classes 

#####test/resources/
This resources directory contains the structures for the feature files

    @TODO
     Details on taging the tests (see https://github.com/cucumber/cucumber/wiki/Tags)
     Details on Jooq (see https://www.jooq.org)


# Notes
This project makes use of [editorconfig](http://editorconfig.org/) and [lombok](https://projectlombok.org/)

So depending on your IDE, you may need to install plugins - see the respective sites for details
