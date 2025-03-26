<template>
  <div>
    <h2>{{ siteINfo.siteName }}</h2>
    <a :href="siteINfo.siteUrl">{{ siteINfo.siteUrl }}</a>
    <h2>방문여부 : {{ siteINfo.visited }}</h2>
    <hr />
  </div>
</template>
<script>
export default {
  name: 'PropsList2',
  props: ['siteINfo'],
};
</script>
<style lang=""></style>
