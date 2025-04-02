<script setup>
import { RouterLink, RouterView, useRouter } from 'vue-router';

const route = useRouter();
</script>

<template>
  <header>
    <nav>
      <RouterLink to="/">Home</RouterLink>
      /
      <RouterLink to="/about">About</RouterLink>
      /
      <RouterLink to="/dynamic/happy">Happy</RouterLink>
      /
      <RouterLink to="/dynamic/exciting">Exciting</RouterLink>
    </nav>

    <div>
      <button v-on:click="route.push('/')">HOME</button>
      <button v-on:click="route.push('/about')">ABOUT</button>
      <button v-on:click="route.back()">BACK</button>
      <button v-on:click="route.forward()">FORWARD</button>
      <button v-on:click="route.go(-2)">뒤로 두번</button>
    </div>
    <nav>
      <RouterLink to="/User/1">User1</RouterLink>
      /
      <RouterLink to="/User/2">User2</RouterLink>
      /
      <RouterLink to="/User/3">User3</RouterLink>
      /
      <RouterLink to="/User/4">User4</RouterLink>
      /
      <RouterLink to="/User/5">User5</RouterLink>
    </nav>
  </header>

  <RouterView />
</template>

<style scoped></style>
