#!/bin/bash

# ################### #
# Run all test suites #
# ################### #

JVM=java
TEST=org.junit.runner.JUnitCore
testSuffix="Test"

for dir in $(ls -d */); do
  dirFile=${dir%%/*} # Remove end slash from dir
  echo "======================="
  echo "*** Testing: $dirFile ***"
  echo "======================="
  testFile="$dirFile$testSuffix"
  cd $dir && $JVC *.java && $JVM $TEST $testFile && cd ..
done
