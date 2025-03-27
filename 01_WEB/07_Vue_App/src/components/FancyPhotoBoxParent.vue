<template>
  <FancyPhotoBox>
    <template v-slot:title>
      <h1>안태현과 함께하는 터키 여행</h1>
    </template>
    <template #photo>
      <img
        src="C:\fullstack\KB_EDU\01_WEB\07_Vue_App\src\components\turkey_me.jpg"
        alt="안태현 안태현"
        width="500px"
        height="500px"
      />
    </template>
  </FancyPhotoBox>
</template>
<script>
import FancyPhotoBox from './FancyPhotoBox.vue';

export default { name: 'FancyPhotoBoxParent', components: { FancyPhotoBox } };
</script>
<style lang=""></style>
