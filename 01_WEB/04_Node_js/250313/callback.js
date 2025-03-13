function sayMyName() {
  console.log('엄,,,,제 이름은 안태현입니다.');
}

function sayMyDinner() {
  console.log('내가 이따 먹을 저녁 메뉴는 카레 입니다.');
}

youKnow(sayMyName);
youKnow(sayMyDinner);

function youKnow(func) {
  console.log('You Know~');
  func();
}

youKnow(function () {
  console.log('내일 아침은 굶겠습니다.');
});
