<script setup>
import { ref } from 'vue';
import CheckList from './components/CheckList.vue';
import TodoProps from './components/TodoProps.vue';
import EventProps from './components/EventProps.vue';
import PropsList from './components/PropsList.vue';
import PropsList2 from './components/PropsList2.vue';
import SendNameComponent from './components/SendNameComponent.vue';
import ColorEmit from './components/ColorEmit.vue';
import SlotParent from './components/SlotParent.vue';
import NamedSlotParent from './components/NamedSlotParent.vue';
import FancyPhotoBoxParent from './components/FancyPhotoBoxParent.vue';
import ScopedSlotParent from './components/ScopedSlotParent.vue';
import ModalParent from './components/ModalParent.vue';
import TeleportDemo from './components/TeleportDemo.vue';
import CustomInputParent from './components/CustomInputParent.vue';
import ProvideComponent from './components/ProvideComponent.vue';
</script>

<template><ProvideComponent /></template>

<script>
export default {
  name: 'App',
  data() {
    return {};
  },
  methods: {},
};
</script>

<style></style>
