<template>
  <div>
    <h1>TODO EDIT</h1>
    <h2>todo : <input type="text" v-model.trim="editedTodo" /></h2>
    <h2>desc : <input type="text" v-model.trim="editedDesc" /></h2>
    <h2>done : <input type="checkbox" v-model="editedDone" /></h2>
    <button @click="editTodo(todo.id)">수정</button>
    <button
      @click="router.push({ name: 'todo/detail', params: { id: todo.id } })"
    >
      취소
    </button>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const BASE_URL = '/api';
const editedTodo = ref('');
const editedDesc = ref('');
const editedDone = ref();
const todo = ref({});

async function fetchTodo() {
  try {
    const todoUrl = BASE_URL + `/todos/${id}`;
    const todoRes = await axios.get(todoUrl);

    todo.value = todoRes.data;
    editedTodo.value = todo.value.todo;
    editedDesc.value = todo.value.desc;
    editedDone.value = todo.value.done;

    console.log('TODO DETAIL 데이터 : ', todo);
  } catch (e) {
    alert('TODO DETAIL 통신 ERR 발생');
    console.log(e);
  }
}

async function editTodo(id) {
  try {
    const editedTodoUrl = BASE_URL + `/todos/${id}`;

    const editTodoList = {
      todo: editedTodo.value,
      desc: editedDesc.value,
      done: editedDone.value,
    };
    const editedTodoRes = await axios.put(editedTodoUrl, editTodoList);

    console.log('수정 결과 ', editedTodoRes.data);
    router.push({ name: 'todo' });
  } catch (e) {
    console.log(e);
    alert('할일 추가 에러');
  }
}
fetchTodo();
</script>

<style lang="scss" scoped></style>
