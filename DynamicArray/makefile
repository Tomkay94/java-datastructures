#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: DynamicArray.java DynamicArrayTest.java
	$(JC) DynamicArray.java && \
	$(JC) DynamicArrayTest.java && \
	$(JVM) $(TEST) DynamicArrayTest

#
# Compile the class files
#
main: DynamicArray.java DynamicArrayTest.java
	$(JC) DynamicArray.java && \
	$(JC) DynamicArrayTest.java

#
# Clean for recompile
#
clean:
	rm *.class
