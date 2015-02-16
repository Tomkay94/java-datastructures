#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
tests: HashTable.java HashTableTest.java
	$(JC) HashTable.java && $(JC) HashTableTest.java && $(JVM) $(TEST) HashTableTest

#
# Compile the main files
#
main: HashTable.java
	$(JC) HashTable.java

#
# Clean for recompile
#
clean:
	rm *.class
