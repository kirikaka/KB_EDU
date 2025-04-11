<template>
  <main>
    <h1>TODO PAGE</h1>
    <!-- 로딩 중에는 아래의 h2 가 출력 되도록 구현 -->
    <h2 v-if="isFetching">데이터 로딩 중</h2>
    <!-- 통신 실패 시 아래의 h2 가 출력 되도록 구현 -->
    <h2 v-else-if="isError">데이터 통신 중 에러 발생</h2>
    <!-- 통신 성공 시 todo 리스트 출력 -->
    <div v-else>
      <ul>
        <li v-for="(element, index) in todolist" v-bind:key="index">
          {{ element.id }} /
          <RouterLink v-bind:to="`/todo/detail/${element.id}`"
            >{{ element.todo }}
          </RouterLink>
          / {{ element.done }}
        </li>
      </ul>
      <button @click="router.push({ name: 'todo/write' })">todo 작성</button>
    </div>
  </main>
</template>

<script setup>
import axios from 'axios';
import { ref, reactive } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const BASE_URL = '/api';
const todolist = ref([]);
let isError = ref(false);
let isFetching = ref(true);
const router = useRouter();

async function fetchTodo() {
  try {
    const todoUrl = BASE_URL + '/todos';
    const todoRes = await axios.get(todoUrl);
    todolist.value = todoRes.data;

    isFetching.value = false;
  } catch (e) {
    alert('TODO DATA FETCH 통신 ERR 발생');
    console.log(e);
    isError.value = true;
    isFetching.value = false;
  }
}

fetchTodo();
</script>
