<script setup>
const obj = {
  name: '안태현',
  isSleepy: true,
};

localStorage.setItem('thObj', JSON.stringify(obj));
const getObj = JSON.parse(localStorage.getItem('thObj'));

console.log(getObj.name);
console.log(getObj);
</script>

<template>
  <div>
    <h1>HOME</h1>
  </div>
</template>
