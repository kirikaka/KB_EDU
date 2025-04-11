<template>
  <div>
    <h1>TODO DETAIL</h1>
    <div>
      <h2>{{ todo.id }}</h2>
      <h2>{{ todo.todo }}</h2>
      <h2>{{ todo.desc }}</h2>
      <h2>{{ todo.done }}</h2>
    </div>
    <button @click="router.push({ name: 'todo' })">목록</button>
    <button @click="router.push({ name: 'todo/edit' })">수정</button>
    <button @click="delteTodo">삭제</button>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const router = useRouter();
const curRoute = useRoute();
const id = curRoute.params.id;

const BASE_URL = '/api';
let todo = ref({});
let todoDel = ref({});

async function fetchTodo() {
  try {
    const todoUrl = BASE_URL + `/todos/${id}`;
    const todoRes = await axios.get(todoUrl);
    todo.value = todoRes.data;
    console.log('🚀 ~ todo:', todo.value);
  } catch (e) {
    alert('TODO DATA FETCH 통신 ERR 발생');
    console.log(e);
  }
}
async function delteTodo() {
  try {
    const todoUrl = BASE_URL + `/todos/${id}`;
    const todoRes = await axios.delete(todoUrl);
    todoDel.value = todoRes.data;
    console.log(todoDel.value);

    router.push({ name: 'todo' });
  } catch (e) {
    console.log(e);
    alert('삭제하는 과정에 오류 발생');
  }
}

fetchTodo();
</script>

<style lang="scss" scoped></style>
