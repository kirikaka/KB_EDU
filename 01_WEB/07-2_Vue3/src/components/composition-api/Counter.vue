<template>
  <div>
    <h1>카운터</h1>
    <h1>Count : {{ count }}</h1>
    <h1>Double : {{ double }}</h1>
    <h1>지금까지 클릭 횟수 : {{ num }}</h1>
    <button @click="increment">increment</button>
    <button @click="decrement">decrement</button>
  </div>
</template>

<script setup>
import { ref, computed, watch } from 'vue';

const count = ref(0);
const num = ref(0);
const double = computed(() => count.value * 2);
function increment() {
  count.value++;
  num.value++;
}
function decrement() {
  count.value--;
  num.value++;
}
watch(num, function (newValue, oldValue) {
  console.log(`Num is changing from ${oldValue} to ${newValue}`);
  if (newValue % 10 === 0 && newValue !== 0) return alert('Congratuate');
});
</script>

<style lang="scss" scoped></style>
