#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: Stack.java StackTest.java
	$(JC) Stack.java && \
	$(JC) StackTest.java && \
	$(JVM) $(TEST) StackTest

#
# Compile the class files
#
main: Stack.java
	$(JC) Stack.java

#
# Clean for recompile
#
clean:
	rm *.class
