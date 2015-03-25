#!/bin/bash

# ################### #
# Run all test suites #
# ################### #

JVM=java
JVC=javac
TEST=org.junit.runner.JUnitCore

for dir in $(ls -d */); do
  dirFile=${dir%%/*} # Remove end slash from dir
  echo '==============================='
  echo "*** Testing: $dirFile ***"
  echo '==============================='
  cd $dirFile && make tests && cd ..
done
