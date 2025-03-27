<template>
  <div class="topSlot">
    <h1>여기는 탑슬롯, 뭐든지 기울임</h1>
    <slot name="top">
      <!-- 여기에 부모가 보낸 html코드가 소환-->
    </slot>
  </div>
  <div class="bottomSlot">
    <h1>This is bottom slot. We underline all of things</h1>
    <slot name="bottom">
      <!-- 여기에 부모가 보낸 html코드가 소환-->
    </slot>
  </div>
</template>
<script>
export default { name: 'NamedSlotChild' };
</script>
<style scoped>
.topSlot {
  font-style: italic;
  background-color: darksalmon;
}
.bottomSlot {
  text-decoration: underline;
  background-color: lightslategrey;
}
</style>
