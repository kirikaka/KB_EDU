<template>
  <SlotChild>
    <h1>슬롯 테스트!</h1>
    <img
      src="C:\fullstack\KB_EDU\01_WEB\07_Vue_App\src\components\turkey_me.jpg"
      alt="aws"
      width="500px"
      height="500px"
    />
    <h1>테스트2</h1>
    <input type="text" />
    <button>닫기</button>
    <button>Dont close.</button>
  </SlotChild>
</template>
<script>
import SlotChild from './SlotChild.vue';

export default { name: 'SlotParent', components: { SlotChild } };
</script>
<style lang=""></style>
