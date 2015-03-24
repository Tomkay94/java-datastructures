#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: AdjacencyMatrix.java AdjacencyMatrixTest.java
	$(JC) AdjacencyMatrix.java && \
	$(JC) AdjacencyMatrixTest.java && \
	$(JVM) $(TEST) AdjacencyMatrixTest

#
# Compile the class files
#
main: AdjacencyMatrix.java
	$(JC) AdjacencyMatrix.java

#
# Clean for recompile
#
clean:
	rm *.class
