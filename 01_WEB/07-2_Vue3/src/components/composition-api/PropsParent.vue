<template>
  <div><PropsChild :msg="msg" /></div>
</template>

<script setup>
import { ref } from 'vue';
import PropsChild from './PropsChild.vue';
const msg = ref('props로 전달될 문자열');
</script>

<style lang="scss" scoped></style>
