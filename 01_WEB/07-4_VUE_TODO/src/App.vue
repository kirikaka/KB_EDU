<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <nav>
    <RouterLink to="/">Home</RouterLink>
    /
    <RouterLink to="/login">Login</RouterLink>
    /
    <RouterLink to="/todo">Todo</RouterLink>
  </nav>

  <RouterView />
</template>
