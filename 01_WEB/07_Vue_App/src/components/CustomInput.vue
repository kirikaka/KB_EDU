<template>
  <div class="custom-input">
    사용자 이름 :
    <input
      type="text"
      :value="inputValue"
      @input="$emit('update:inputValue', $event.target.value)"
      class="input-field"
    />
  </div>
</template>

<script>
export default {
  name: 'CustomInput',
  props: {
    inputValue: String,
    label: String,
  },
  emits: ['update:inputValue'],
};
</script>

<style scoped>
.custom-input {
  margin-bottom: 10px;
}
.input-field {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}
</style>
