<template>
  <div class="container">
    <Header />
    <RouterView />
    <!-- <Loading v-if="states.isLoading" /> -->
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from 'vue-router';
import { reactive, computed, provide, ref } from 'vue';

import { useRoute } from 'vue-router';
import axios from 'axios';

import Header from '@/components/Header.vue';
// import Loading from '@/components/Loading.vue';

import { useTodoListStore } from '@/stores/todoList.js';

const BASE_URL = '/api/todos';

// const states = reactive({
//   todoList: [],
// });

const todoListStore = useTodoListStore();
const isLoading = computed(() => todoListStore.isLoading);
const fetchTodoList = todoListStore.fetchTodoList;
fetchTodoList();
const { todoList, addTodo, deleteTodo, toggleDone } = todoListStore;
console.log('🚀 ~ todoList:', todoList);
const doneCount = computed(() => todoListStore.doneCount); // 기본 타입에 대해서는 계산된 속성을 다시 작성

const addTodoHandler = () => {
  addTodo(todo.value);
  todo.value = '';
};

// provide(
//   'todoList',
//   computed(() => states.todoList)
// );
// provide('actions', {
//   addTodo,
//   deleteTodo,
//   toggleDone,
//   updateTodo,
//   fetchTodoList,
// });
// fetchTodoList();
</script>

<style scoped></style>
