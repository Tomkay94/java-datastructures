#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
nodeTests: Node.java NodeTest.java
	$(JC) Node.java && $(JC) NodeTest.java && $(JVM) $(TEST) NodeTest

#
# Clean for recompile
#
clean:
	rm *.class
