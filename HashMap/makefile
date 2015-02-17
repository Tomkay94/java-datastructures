#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: HashEntry.java HashMap.java HashMapTest.java
	$(JC) HashEntry.java && $(JC) HashMap.java && $(JC) HashMapTest.java && $(JVM) $(TEST) HashMapTest

#
# Compile the main files
#
main: HashMap.java HashEntry.java
	$(JC) HashMap.java && $(JC) HashEntry.java

#
# Clean for recompile
#
clean:
	rm *.class
