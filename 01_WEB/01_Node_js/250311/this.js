const say_hello = () => {
  console.log(`Hello, I'm ${this.name}`);
};

let boy = {
  name: 'Mike',
  say_hello,
};

let girl = {
  name: 'Mike',
  say_hello,
};

boy.say_hello();
