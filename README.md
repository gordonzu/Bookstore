# Bookstore
Java implementation of Layka's Bookstore application in Java for Web Development

### Requirements
JDK 1.8 - is the baseline JDK against which this project is developed.

### Current Release: 1.0
#### 1.0 : June 3 2017
 
## Details

### Build Instructions
To build from the command line:
* Ensure you have JDK 1.8+ installed.
* Ensure you have [maven](http://maven.apache.org/) installed.
* Download the release archive.
* Unzip
* Go to the Bookstore directory
* Type 'mvn install'. This will generate a build directory, which will include the following sub-directories:
  * target/ will contain all the main and test Java classes and the jar file
  
### Database generation
Application is programmed to a PostgreSQL 9.5 database, but any SQL compliant database should do fine. Run sql files 
to setup tables, sequences, and test data. 

## Running the tests

Unit tests: mvn test
Integration tests: mvn verify



