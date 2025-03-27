<template>
  <NamedSlotChild>
    <template v-slot:top>
      <h2>This html is for top Slot</h2>
    </template>
    <template #bottom>
      <h2>This html is for bottom Slot</h2>
    </template>
  </NamedSlotChild>
</template>
<script>
import NamedSlotChild from './NamedSlotChild.vue';
import SlotChild from './NamedSlotChild.vue';

export default { name: 'NamedSlotParent', components: { NamedSlotChild } };
</script>
<style lang=""></style>
