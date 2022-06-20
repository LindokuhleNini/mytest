# mytest
# JAR files used:
- mysql-connector-java-8.0.26.jar
- opencsv-5.6.jar
- commons-validator-1.7.jar

# Database used:
- MySQL database

# How to deploy solution:
- Clone the entire project into IntelliJ
- Download the listed jar files

# How to run it:
- To generate random records and store them into CSV file, run MyTest.java
- To create a table in the database, go to MyTestDB.java, uncomment the //createTable() line on the main method and run the code
- To store the data that is in the CSV file into the database run the saveDataToDB() method in MyTestDB.java 

# Con:
- Due to all the conditions that are checked before storing the data into the CSV file, it takes a long time to store 1000000 records.
