#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: BSTNode.java BinarySearchTree.java BinarySearchTreeTest.java
	$(JC) BSTNode.java && \
	$(JC) BinarySearchTree.java && \
	$(JC) BinarySearchTreeTest.java && \
	$(JVM) $(TEST) BinarySearchTreeTest

#
# Compile the class files
#
main: BinarySearchTree.java BSTNode.java
	$(JC) BinarySearchTree.java && \
	$(JC) BSTNode.java

#
# Clean for recompile
#
clean:
	rm *.class
