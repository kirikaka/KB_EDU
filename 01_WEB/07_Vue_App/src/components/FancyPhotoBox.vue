<template>
  <div class="titleSlot">
    <slot name="title"> </slot>
  </div>
  <div class="photoSlot">
    <slot name="photo"></slot>
  </div>
</template>
<script>
export default { name: 'FancyPhotoBox' };
</script>
<style scoped></style>
