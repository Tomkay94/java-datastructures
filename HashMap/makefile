#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: HashMap.java HashMapTest.java
	$(JC) HashMap.java && \
	$(JC) HashMapTest.java && \
	$(JVM) $(TEST) HashMapTest

#
# Compile the class files
#
main: HashMap.java
	$(JC) HashMap.java

run: main HashMap.class
	$(JVM) HashMap

#
# Clean for recompile
#
clean:
	rm *.class