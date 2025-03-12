const user = {
  id: 1,
  name: 'tetz',
  email: 'xenosign@naver.com',
};

const { id, name, email } = user;

const string = 'apple';
const strArr = string.split('');
const strArr2 = [...string];

const arr = [1, 2, 3, 4];
const copyArr = arr; //메모리 카피
const hardCopyArr = [...arr]; //값 카피

console.log(arr === copyArr); //true
console.log(arr === hardCopyArr); //false
console.log(copyArr == hardCopyArr); //false
