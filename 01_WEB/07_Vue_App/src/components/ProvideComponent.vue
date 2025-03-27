<template lang="">
  <div><ProvideChild :drilling="drilling" /></div>
</template>
<script>
import ProvideChild from './ProvideChild.vue';

export default {
  name: 'ProvideComponent',
  components: { ProvideChild },
  data() {
    return {
      drilling: '으아아아아ㅏㅇ어띠가진아ㅜ링ㄴ',
    };
  },
  provide() {
    return {
      fly: '한번에 감',
    };
  },
};
</script>
<style></style>
