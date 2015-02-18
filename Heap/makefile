#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: MinHeap.java MinHeapTest.java
	$(JC) MinHeap.java && \
	$(JC) MinHeapTest.java && \
	$(JVM) $(TEST) MinHeapTest

#
# Compile the class files
#
main: MinHeap.java
	$(JC) MinHeap.java

#
# Clean for recompile
#
clean:
	rm *.class
