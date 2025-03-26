<script setup>
import { ref } from 'vue';
import CheckList from './components/CheckList.vue';
import TodoProps from './components/TodoProps.vue';
import EventProps from './components/EventProps.vue';
import PropsList from './components/PropsList.vue';
import PropsList2 from './components/PropsList2.vue';
import SendNameComponent from './components/SendNameComponent.vue';
import ColorEmit from './components/ColorEmit.vue';
</script>

<template>
  <div :style="{ backgroundColor: color }">
    <h1>저의 색상을 정해주세요</h1>
    <ColorEmit v-on:colorChange="onColorChangeHandler" />
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {};
  },
  methods: {},
};
</script>

<style scoped></style>
