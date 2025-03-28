<template>
  <div>
    <h1>아아 꿈을 꾸었습니다. 제가 나비가 되는 꿈을 꾸었씁니다.</h1>
    <p>그런데 어찌하여 우느냐</p>
    <h2>그것은 제가 {{ refData.name }}이기 때문입니다.</h2>
    <p>사실은 전 {{ reactiveData.name }}</p>
    <button v-on:click="changeRef">Change RefDATA</button>
    <button v-on:click="changeReactive">Change Reactive</button>
  </div>
</template>

<!-- Vue3 -->
<script setup>
import { ref, reactive } from 'vue';

let refData = ref({ name: 'Antaehyun' });
let reactiveData = reactive({
  name: 'antaehyun',
});
const changeRef = () => {
  // refData.value = { name: '안태현' };
  refData.value.name = '안태현';
};
const changeReactive = () => {
  reactiveData = { name: '왜바뀜?' };
};
</script>
