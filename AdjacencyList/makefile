#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: AdjacencyList.java Node.java AdjacencyListTest.java
	$(JC) Node.java && \
	$(JC) AdjacencyList.java && \
	$(JC) AdjacencyListTest.java && \
	$(JVM) $(TEST) AdjacencyListTest

#
# Compile the class files
#
main: AdjacencyList.java Node.java
	$(JC) Node.java && \
	$(JC) AdjacencyList.java

#
# Clean for recompile
#
clean:
	rm *.class
