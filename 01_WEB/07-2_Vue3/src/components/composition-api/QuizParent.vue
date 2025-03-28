<template>
  <div>
    <h1>{{ msg3 }}</h1>
    <QuizChild :num="num" @send-Result="emitHandler" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import QuizChild from './QuizChild.vue';

const num = ref(parseInt(Math.random() * 20));
const msg3 = ref('랜덤 숫자를 맞춰주세요!');

function emitHandler(value) {
  msg3.value = value; //msg3에넣어줄 value는 EmitChild에 서 받아온 value이다.
}
</script>

<style lang="scss" scoped></style>
