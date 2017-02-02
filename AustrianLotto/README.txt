================================================================================


			1. Challenge description

The challenge description can be found in the following link:
http://community.topcoder.com/stat?c=problem_statement&pm=1934



================================================================================



			2. Source code & Complied solution
I have completed all the tasks. The program can be compiled and it is working correctly.
All the source code is inside the zip file I sent.
	1. AustrianLotto program files is in "src" folder
	2. Unit-testing files is in "test" folder
As for the complied solution, the zip file also contains all .class and .jar files. These
files can be found in "build" or "dist" folder.(under the same directory as this README.txt)




================================================================================



			3. Java Version Information						
Java: 1.8.0_40; Java HotSpot(TM) 64-Bit Server VM 25.40-b25
Runtime: Java(TM) SE Runtime Environment 1.8.0_40-b26



================================================================================


			4. How to run?
>>>>>>>>>>>>>>>>>>>>>>>>>>method_one<<<<<<<<<<<<<<<<<<<<<<<<<<<<
I have provided two ant files and they are called
build.XML  			<-------------Please use this one 

CustomerBuild_Backup.XML	<-------------This is mainly to show that I am capable of writing ant file, in case you need to examine 					      relevant skills
								  
To run the project from the Windows command line, 
go to the dist folder (under the same directory as this README.txt) and type:

java -jar "AustrianLotto.jar" 

*If you find that this isn't working, you then need to use the build.XML ant file,
that is you need to clean and build once again. Once you have done this, you can 
repeat the above command by going to the dist folder and typing the command again.


>>>>>>>>>>>>>>>>>>>>>>>>>>method_two<<<<<<<<<<<<<<<<<<<<<<<<<<<<
If you happen to have IDE such as netbean or eclipse, you can always do 
1. import the whole zip file into IDE and run
OR
2. create new project and copy&paste all classes into this new project and run

Just in case method_one is not working.




================================================================================



		5. Unit tests and demonstration of TDD practices
I have created two Junit (version 4.0.X ) testing java files, they are called

1.AustrianLottoUnitTestBoundaryValueAnalysis.java 	<----------Boundary analysis
2.AustrianLottoUnitTestEquivalencePartitioning.java 	<----------Equivalence partitioning

Comments in these two files can help me explain my testing strategy easily, please
take a look at them.

How to run?
I tried to find command line for you, so you can run these from Windows command
line directly. But later on, I found out that the location of junit.jar could be 
different in your computer, therefore it is really not recommended to run tests
from command line.

The best way is simple import the whole project into IDE, and then run these
Junit test cases.

I also have attached images of results of testing in a folder called 
Austrian_Lotto_Junit_Test_results(under the same directory as this README.txt).
You can see the results there too.


================================================================================



			6. Demonstration of OOP
In the Zip file I sent, I have also included 3 diagrams - namely module, 
sequence and class diagram. These can be found in a folder called 
Austrian_Lotto_OOP_Diagrams(under the same directory as this README.txt).

They help me explain the process of design, that is the demonstration of OOP.




================================================================================



			7. Ant file
As mentioned in section 4 in this README.txt file, I have provided runnable 
ant files.




================================================================================



			8. Additional information
For unit-testing, I was unable to test user inputs since I was required to 
generate valid random picks and drawing, instead of reading inputs from users
(in the Email you sent me). So I had to cut this part of testing out.

Strictly speaking, picks are selected by user with string inputs. But we are
using randomly generated numbers here. So I hope that you can understand.
