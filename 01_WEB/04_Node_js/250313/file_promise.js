const fs = require('fs').promises;

fs.readFile('./Readme.md')
  .then(function (data) {
    console.log(`1번`, data.toString());
    return fs.readFile('./Readme.md');
  })
  .then(function (data) {
    console.log('2번', data.toString());
    return fs.readFile('./Readme.md');
  })
  .then(function (data) {
    console.log('3번', data.toString());
    return fs.readFile('./Readme.md');
  })

  .then(function (data) {
    console.log('4번', data.toString());
    return fs.readFile('./Readme.md');
  })
  .catch(function (err) {
    console.error(err);
    throw err;
  });
