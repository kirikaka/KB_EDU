const name = require('./user');

function hello(name) {
  console.log(name + '님, 안녕하세요?');
}
hello(name);
module.exports = hello; // user
