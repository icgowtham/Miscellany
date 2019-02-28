Disclaimer:
The source code is made available as is. 

Licensing:
The source code can be used and distributed freely with no restrictions (except for the Open Source libraries used. Check their license).

Development Environment:
This program was developed using JDK version 1.7 on Windows 7.


Folder structure and contents:
src/com/eroad/assignment - source Java files.
lib - Open source JAR files used in the project.

Steps for compiling the program (assuming we are currently in the 'src' directory):
javac -cp "../lib/*;" com/eroad/assignment/TestRestClient.java

Steps for running the program using the '.class' file (assuming we are currently in the 'src' directory):
java -cp "../lib/*;" com.eroad.assignment.TestRestClient <path_to_input_CSV_file>