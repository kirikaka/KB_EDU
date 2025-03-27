<template lang="">
  <div><ProvideGrandChild :drilling="drilling" /></div>
</template>
<script>
import ProvideGrandChild from './ProvideGrandChild.vue';

export default {
  name: 'ProvideChild',
  components: { ProvideGrandChild },

  props: ['drilling'],
};
</script>
<style></style>
