<template lang="">
  <div>
    <input type="text" v-model.trim="color" />
    <button @click="$emit('colorChange', { color: color })">색상 전달!</button>
  </div>
</template>
<script>
export default {
  name: 'ColorEmit',
  data() {
    return {
      color: '',
    };
  },
};
</script>
<style lang=""></style>
