#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: Graph.java Node.java AdjacencyListTest.java
	$(JC) Node.java && \
	$(JC) Graph.java && \
	$(JC) AdjacencyListTest.java && \
	$(JVM) $(TEST) AdjacencyListTest

#
# Compile the class files
#
main: Graph.java Node.java
	$(JC) Node.java && \
	$(JC) Graph.java

#
# Clean for recompile
#
clean:
	rm *.class
