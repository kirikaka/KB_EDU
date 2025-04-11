<template>
  <div>
    <h1>Msg Reciever</h1>
    <h1>Pinia로 부터 받은 메시지는 "{{ msg }}" 입니다.</h1>
  </div>
</template>

<script setup>
import { computed } from 'vue';
import { useMessageStore } from '@/stores/msg';
const messageStore = useMessageStore();
const msg = computed(() => {
  return messageStore.msg;
});
</script>

<style lang="scss" scoped></style>
