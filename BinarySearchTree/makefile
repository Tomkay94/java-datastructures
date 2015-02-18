#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: Node.java BinarySearchTree.java BinarySearchTreeTest.java
	$(JC) Node.java && \
	$(JC) BinarySearchTree.java && \
	$(JC) BinarySearchTreeTest.java && \
	$(JVM) $(TEST) BinarySearchTreeTest

#
# Compile the class files
#
main: BinarySearchTree.java Node.java
	$(JC) BinarySearchTree.java && \
	$(JC) Node.java

#
# Clean for recompile
#
clean:
	rm *.class
