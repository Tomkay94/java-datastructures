#
# Default definitions
#
JC = javac
JVM = java
TEST = org.junit.runner.JUnitCore

#
# Run the test suite
#
hashTests: HashTable.java HashTableTest.java
	$(JC) HashTable.java && $(JC) HashTableTest.java && $(JVM) $(TEST) HashTableTest

#
# Clean for recompile
#
clean:
	rm *.class
