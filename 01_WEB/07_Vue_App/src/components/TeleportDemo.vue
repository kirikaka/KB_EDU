<template>
  <div>
    <button @click="teleportTo('orange')">To Orange</button>
    <button @click="teleportTo('red')">To Red</button>
    <button @click="teleportTo('skyblue')">To SkyBlue</button>
    <div id="orange"></div>
    <div id="red"></div>
    <div id="skyblue"></div>

    <teleport v-bind:to="target">
      <h1>나는 어디로 가는가? 뭘하고 살아야 하나</h1>
    </teleport>
  </div>
</template>
<script>
export default {
  name: 'TeleportDemo',
  data() {
    return {
      target: 'body',
    };
  },
  methods: {
    teleportTo(target) {
      this.target = `#${target}`;
    },
  },
};
</script>
<style>
div {
  height: 200px;
}
#orange {
  background-color: orange;
}
#skyblue {
  background-color: skyblue;
}
#red {
  background-color: red;
}
</style>
