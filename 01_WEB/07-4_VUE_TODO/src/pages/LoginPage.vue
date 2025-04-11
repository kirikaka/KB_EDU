<template>
  <div>
    <h1>LOGIN PAGE</h1>
    아이디 : <input type="text" v-model.trim="userId" /><br />
    비밀번호 : <input type="password" v-model.trim="userPassword" />
    <br />
    <button @click="login">로그인</button> /
    <button @click="logout">로그아웃</button>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const userId = ref('');
const userPassword = ref('');

const BASE_URL = '/api';

const router = useRouter();

async function login() {
  try {
    const loginUrl = BASE_URL + '/users';
    const loginRes = await axios.get(loginUrl);

    const userArr = loginRes.data;
    const findUser = userArr.find((item, index) => {
      return item.id === userId.value;
    });

    if (findUser === undefined)
      return alert('해당 ID를 가진 사용자가 없습니다.');
    if (findUser.password !== userPassword.value)
      return alert('비밀번호가 틀렸습니다.');

    localStorage.setItem('auth', 'true');
    alert('로그인 성공');

    console.log('User data list from back : ', loginRes);

    return router.push({ name: 'todo' });
  } catch (e) {
    alert('로그인 통신 에러 발생');
    console.error(e);
  }
}
function logout() {
  localStorage.removeItem('auth');
  alert('로그 아웃 완료');
}
</script>
