<template>
  <slot :msg="data1"></slot>
  <slot name="named" :msg="data2"></slot>
</template>
<script>
export default {
  name: 'ScopedSlotChild',
  data() {
    return {
      data1: '과연 나는 어떻게 이동할까 궁금',
      data2: '그럼 나는?',
    };
  },
};
</script>
