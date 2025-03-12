for (let i = 1; i < 10; i++) {
  if (i === 4) {
    continue;
  }
  console.log('구구단', i, '단');
  for (let j = 1; j < 10; j++) {
    console.log(i, 'X', j, '=', i * j);
  }
  console.log();
}
