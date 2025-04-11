<template>
  <div>
    <h1>TODO WRITE</h1>
    <h2>todo : <input type="text" v-model.trim="todo" /></h2>
    <h2>desc : <input type="text" v-model.trim="desc" /></h2>
    <button @click="addTodo">작성</button>
    <button @click="router.push({ name: 'todo' })">취소</button>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const BASE_URL = '/api';
const todo = ref('');
const desc = ref('');

async function addTodo() {
  try {
    const todoUrl = BASE_URL + '/todos';
    const newTodo = {
      todo: todo.value,
      desc: desc.value,
      done: false,
    };
    const todoRes = await axios.post(todoUrl, newTodo);
    console.log('추가 결과 ', todoRes.data);
    router.push({ name: 'todo' });
  } catch (e) {
    console.log(e);
    alert('할일 추가 에러');
  }
}
</script>

<style lang="scss" scoped></style>
