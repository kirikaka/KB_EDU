<template>
  <div>
    <h2>일반 v-model 예시</h2>
    <input type="text" v-model="text" />
    <p>일반 v-model 값: {{ text }}</p>

    <h2>사용자 정의 모델 예시</h2>
    <CustomInput v-model:inputValue="username" />
    <p>사용자 정의 model 값: {{ username }}</p>
  </div>
</template>

<script>
import CustomInput from './CustomInput.vue';

CustomInput;

export default {
  name: 'App',
  components: {
    CustomInput,
  },
  data() {
    return {
      username: '',
      text: '',
    };
  },
};
</script>
