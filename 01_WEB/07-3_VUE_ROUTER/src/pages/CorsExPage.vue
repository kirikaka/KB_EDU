<template>
  <div>
    <h1>CORS EX PAGE</h1>
  </div>
</template>

<script setup>
const CORS_EX_URL =
  'https://port-0-tetz-night-back-m5yo5gmx92cc34bc.sel4.cloudtype.app';

// const PROXY_EX_URL = 'practice-api';
const PROXY_EX_URL = '/cors/ex';

async function checkCorsEx() {
  try {
    const corsExUrl = PROXY_EX_URL;
    const corsExRes = await fetch(corsExUrl);
    const corsExData = await corsExRes.json();

    console.log('CORS 응답 결과 : ', corsExData.message);
  } catch (e) {
    alert('콘솔 에러 발생');
    console.log(e);
  }
}
checkCorsEx();
</script>

<style lang="scss" scoped></style>
