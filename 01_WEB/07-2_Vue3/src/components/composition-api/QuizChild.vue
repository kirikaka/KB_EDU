<template>
  <div>
    <input type="text" v-model.number="inputNum" />
    <button @click="sendNum">정답!</button>
  </div>
</template>

<script setup>
import { ref, defineEmits, watch, computed } from 'vue';

const count = ref(0);
const inputNum = ref(0);

const props = defineProps({
  num: {
    type: Number,
    required: true,
  },
});

const emit = defineEmits(['send-Result']);
//  computed 안쓰는 법
// const sendNum = () => {
//   if (inputNum.value > props.num) emit('send-Result', 'DOWN');
//   else if (inputNum.value < props.num) emit('send-Result', 'UP');
//   else emit('send-Result', '정답입니다.');
//   count.value++;
// };
const result = computed(function () {
  if (inputNum.value > props.num) return 'DOWN';
  if (inputNum.value < props.num) return 'UP';
  return '정답입니다.';
});

const sendNum = () => {
  count.value++;
  emit('send-Result', result.value);
};

watch(count, function (newValue, oldValue) {
  console.log(`Num is changing from ${oldValue} to ${newValue}`);
  if (newValue === 3) return alert('3번째 시도입니다.');
});
</script>

<style lang="scss" scoped></style>
