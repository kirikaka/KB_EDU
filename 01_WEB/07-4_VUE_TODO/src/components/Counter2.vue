<template>
  <div>
    <h1>Counter2</h1>
    <h1>Count : {{ count }}</h1>
    <h1>DoubleCountx2 : {{ doubleCount }}</h1>
    <button @click="increment">+1</button>
    <button @click="decrement">-1</button>
  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useCounterStore } from '@/stores/counter';

const counterStore = useCounterStore();
const { increment, decrement } = counterStore; //pinia가 인정한 유일한 상태변환 방법.

// 단방향성을 유지하기 위해 꺼내쓰는 computed를 사용한다.
const count = computed(() => {
  return counterStore.count;
});
const doubleCount = computed(() => {
  return counterStore.doubleCount;
});
</script>

<style lang="scss" scoped></style>
