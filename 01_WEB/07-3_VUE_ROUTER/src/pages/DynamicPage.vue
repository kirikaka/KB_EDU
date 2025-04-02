<template>
  <div>
    <h1>Today, I'm {{ msg }}</h1>
    <img :src="imgSrc" :alt="msg" />
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRouter, useRoute } from 'vue-router';

const currentRoute = useRoute();
const router = useRouter();

const mood = computed(() => currentRoute.params.mood);
// const msg = computed(() => {
//   mood.value === 'happy' ? '행복합니다' : '신납니다';
// });

const msg = computed(() => {
  if (mood.value === 'happy') return '행복합니다';
  if (mood.value === 'exciting') return '신납니다';

  return router.push('/404NotFound');
});
const imgSrc = computed(() =>
  mood.value === 'happy'
    ? 'https://i.namu.wiki/i/gtw865yWr-k2eTtkRK3JxGsRgk8MzwTLo1A_cjcmh2JNhwoijepVIkg3w3905kOlZP5s1RzhHzcndzWFzgjZbw.webp'
    : 'https://www.imaeil.com/photos/2013/06/10/2013061016365151147_m.jpg'
);
</script>

<style lang="scss" scoped></style>
