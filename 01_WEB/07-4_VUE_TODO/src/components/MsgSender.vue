<template>
  <div>
    <h1>Msg Sender</h1>
    <input type="text" v-model.trim="userInput" />
    <button @click="editMsg(userInput)">메시지 공간 이동!</button>
  </div>
</template>

<script setup>
import { computed, ref } from 'vue';
import { useMessageStore } from '@/stores/msg';
const messageStore = useMessageStore();
const { editMsg } = messageStore; //pinia가 인정한 유일한 상태변환 방법.

const userInput = ref('');
</script>

<style lang="scss" scoped></style>
