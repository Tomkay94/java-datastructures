# Java Datastructures
Java implementations of various data structures and their operations.
These data structures are implemented for fun and reviewing purposes. The [Java API](http://docs.oracle.com/javase/7/docs/api/) already provides most, if not all, of the data structures which are listed here.

## Running Tests

Before running these tests, you must first open a terminal and clone the repo:

`git clone https://github.com/Tomkay94/java-datastructures.git`

##### For A _Specific_ Data Structure
To run all tests for a certain data structure:
 - `cd` to the specific data structure's folder
 - run `make tests`.

##### For _All_ Data Structures

Before you run all tests for the first time, you must first globally install
`shelljs`, a test script dependency. To do so, run:
- `npm install -g shelljs`

To run all tests for _all_ data structures:
 - `cd` to the root of the repo folder
 - run `shjs runTests.js`.
