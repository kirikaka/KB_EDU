<template>
  <div>
    <h1>{{ msg3 }}</h1>
    <EmitChild v-on:send-msg="emitHandler" />
  </div>
</template>

<script setup>
import { ref } from 'vue';
import EmitChild from './EmitChild.vue';

const msg3 = ref('자식이 바꿔줄 메시지 입니다.');
function emitHandler(value) {
  msg3.value = value; //msg3에넣어줄 value는 EmitChild에서 받아온 value이다.
}
</script>

<style lang="scss" scoped></style>
