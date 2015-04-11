#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: QueueStack.java QueueStackTest.java
	$(JC) QueueStack.java && \
	$(JC) QueueStackTest.java && \
	$(JVM) $(TEST) QueueStackTest

#
# Compile the class files
#
main: QueueStack.java
	$(JC) QueueStack.java

#
# Clean for recompile
#
clean:
	rm *.class
