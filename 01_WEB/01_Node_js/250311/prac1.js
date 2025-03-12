const add1 = (a, b) => {
  return a + b;
};

const toUpperCase1 = (str) => {
  return str.toUpperCase();
};

const sumArray1 = (arr) => {
  let sum = 0;
  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
  }
  return sum;
};

res1 = add1(3, 7);
console.log(res1);

res2 = toUpperCase1('abcd');
console.log(res2);

arr = [1, 23, 4, 5, 5, 6];
res3 = sumArray1(arr);
console.log(res3);
