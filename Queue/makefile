#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: Queue.java QueueTest.java
	$(JC) Queue.java && \
	$(JC) QueueTest.java && \
	$(JVM) $(TEST) QueueTest

#
# Compile the class files
#
main: Queue.java
	$(JC) Queue.java

#
# Clean for recompile
#
clean:
	rm *.class
