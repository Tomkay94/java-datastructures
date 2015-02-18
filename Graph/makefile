#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: GraphAdjacencyMatrix.java GraphAdjacencyMatrixTest.java
	$(JC) GraphAdjacencyMatrix.java && \
	$(JC) GraphAdjacencyMatrixTest.java && \
	$(JVM) $(TEST) GraphAdjacencyMatrixTest

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
