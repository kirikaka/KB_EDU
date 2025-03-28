<script setup>
import Counter from './components/composition-api/Counter.vue';
import EmitParent from './components/composition-api/EmitParent.vue';
import PropsParent from './components/composition-api/PropsParent.vue';
import QuizParent from './components/composition-api/QuizParent.vue';
import RefReactive from './components/composition-api/RefReactive.vue';
</script>

<template><QuizParent /></template>

<script>
export default {
  name: 'App',
  data() {
    return {};
  },
};
</script>

<style></style>
