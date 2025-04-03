<template>
  <div>
    <h1>CORS PAGE</h1>
  </div>
</template>

<script setup>
const CORS_URL =
  'https://port-0-tetz-night-back-m5yo5gmx92cc34bc.sel4.cloudtype.app';

const PROXY_URL = '/api';

async function checkCors() {
  try {
    const corsUrl = PROXY_URL + '/cors/off'; //이미 설정해놓은 엔드포인트
    const corsRes = await fetch(corsUrl);
    const corsData = await corsRes.json();

    console.log('CORS 응답 결과 : ', corsData.message);
  } catch (e) {
    alert('CORS 응답 통신 ERROR 발생');
    consolelog(e);
  }
}
checkCors();
</script>

<style lang="scss" scoped></style>
