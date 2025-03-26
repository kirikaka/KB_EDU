<template>
  <div>
    <h2>{{ siteName }}</h2>
    <a :href="siteUrl">{{ siteUrl }}</a>
    <h2>방문여부 : {{ visited }}</h2>
    <hr />
  </div>
</template>
<script>
export default {
  name: 'PropsList',
  props: ['siteName', 'siteUrl', 'visited'],
};
</script>
<style lang=""></style>
