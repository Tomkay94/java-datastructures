#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: Node.java NodeTest.java
	$(JC) Node.java && \
	$(JC) NodeTest.java && \
	$(JVM) $(TEST) NodeTest

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
