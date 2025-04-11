import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
export const useCounterStore = defineStore('counter', () => {
  // 이게 상태가 되는거야
  const count = ref(0);
  const doubleCount = computed(() => count.value * 2);
  // 상태를 변경할 수 있는 방법은 내부에 존재해야 함 - 다른 사람은 함수를 가져다 쓰는거야
  function increment() {
    count.value++;
  }
  function decrement() {
    count.value--;
  }
  return { count, doubleCount, increment, decrement };
});
