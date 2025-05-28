<template>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <span class="navbar-brand ps-2">TodoList App</span>
        <div :class="isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse'">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <router-link class="nav-link" to="/">Home</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" to="/about">About</router-link>
                </li>
                <li class="nav-item">
                    <router-link class="nav-link" to="/todos">TodoList</router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script setup>
    import { ref } from 'vue';
    const isNavShow = ref(true);
</script>