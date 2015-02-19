#!/bin/bash

# ################### #
# Run all test suites #
# ################### #

JVM=java
TEST=org.junit.runner.JUnitCore

# Loop over all data structure directories and run their tests

for dir in $(ls -d */); do
  dirFile=${dir%%/*} # Remove end slash from dir
  echo "======================="
  echo "*** Testing: $dirFile ***"
  echo "======================="
  testSuffix="Test"
  testFile="$dirFile$testSuffix"
  cd $dir && $JVM $TEST $testFile && cd ..
done
