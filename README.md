# mytest
# JAR files used:
- mysql-connector-java-8.0.26.jar
- opencsv-5.6.jar
- commons-validator-1.7.jar

# Database used:
- MySQL database

# How to deploy solution:
- Clone project into IntelliJ
- Download the listed jar files
- Download the my-db (database used to store the data)

# How to run it:
- To generate random records and store them into CSV file, run MyTest.java
- To create a table in the database, go to MyTestDB.java, uncomment the //createTable() line on the main method and run the code
- To store the data that is in the CSV file into the database run the saveDataToDB() method in MyTestDB.java 

# Con:
- It takes hours to store 1000000 records on the csv file
