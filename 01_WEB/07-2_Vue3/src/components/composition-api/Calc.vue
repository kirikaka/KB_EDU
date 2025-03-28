<template lang="">
  <div>
    X:<input type="text" v-model.number="x" /><br />
    Y:<input type="text" v-model.number="y" /><br />
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc',
  setup() {},
};
</script>
<style lang=""></style>
