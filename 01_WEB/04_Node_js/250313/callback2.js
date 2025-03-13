function generateRandomNumber(cb) {
  console.log('숫자 생성 중');

  setTimeout(function () {
    const randNum = Math.floor(Math.random() * 10) + 1;
    console.log(`생성된 숫자 : ${randNum}`);
    const result = randNum >= 5 ? '통과' : '탈락';

    cb(result);
  }, 1000);
}

generateRandomNumber(function (result) {
  console.log(`결과 : ${result}`);
  console.log('결과 확인 완료!');
});
