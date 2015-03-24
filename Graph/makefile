#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: GraphAdjacencyMatrix.java GraphAdjacencyList.java Node.java GraphTest.java
	$(JC) GraphAdjacencyMatrix.java && \
	$(JC) GraphAdjacencyList.java && \
	$(JC) Node.java && \
	$(JC) GraphTest.java && \
	$(JVM) $(TEST) GraphTest

#
# Compile the class files
#
main: GraphAdjacencyMatrix.java
	$(JC) GraphAdjacencyMatrix.java

#
# Clean for recompile
#
clean:
	rm *.class
