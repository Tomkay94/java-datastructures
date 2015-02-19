#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: Node.java LinkedListTest.java
	$(JC) Node.java && \
	$(JC) LinkedListTest.java && \
	$(JVM) $(TEST) LinkedListTest

#
# Compile the class files
#
main: Node.java
	$(JC) Node.java

#
# Clean for recompile
#
clean:
	rm *.class
