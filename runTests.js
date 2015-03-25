require('shelljs/global');

// ################### //
// Run all test suites //
// ################### //

const
  OMITTED_DIRS = ['node_modules'];

(function main() {
  ls('.').forEach(function(dir) {
    if(exec('test -d ' + dir).code == 0) {
      if(OMITTED_DIRS.indexOf(dir) == -1) {
        cd(dir);
        echo('====================================');
        echo('TESTING: ' + dir);
        echo('====================================');
        exec('make clean');
        exec('make tests');
        cd('..');
      };
    };
  });
})();
