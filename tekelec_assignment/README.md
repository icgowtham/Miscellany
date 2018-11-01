# tekelec_assignment
Disclaimer:
The source code is made available as is. 


Licensing:
The source code can be used and distributed freely with no restrictions.


Development Environment:
This program was developed using JDK version 1.7 on Windows 7.


Folder structure and contents:
src/test - The program contains a single Java file called "RomanNumeralBarcodeGenerator.java" located under src/test.
bin/test - The class file is located under bin/test.


Steps for compiling the program (assuming we are currently in the 'src' directory):
1. On Windows:
javac -d ..\bin test\RomanNumeralBarcodeGenerator.java

2. On UNIX based systems:
javac -d ../bin test/RomanNumeralBarcodeGenerator.java


Steps for running the program using the '.class' file (assuming we are currently in the 'src' directory):
1. On Windows:
java -cp ..\bin test.RomanNumeralBarcodeGenerator 1971

2. On UNIX based systems:
java -cp ../bin test.RomanNumeralBarcodeGenerator 1971


Steps for running the program using the '.jar' file (assuming we are currently in the 'bin' directory):
java -jar assignment.jar 1971