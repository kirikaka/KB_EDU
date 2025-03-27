<template>
  <div>
    <button @click="showModal">모달 열기</button>
    <Modal v-bind:visible="isModalVisible" @close="hideModal">
      <h2>모달 내용</h2>
      <p>간단한 태그</p>
      <img
        src="C:\fullstack\KB_EDU\01_WEB\07_Vue_App\src\components\turkey_me.jpg"
        width="500px"
        height="500px"
      />
    </Modal>
  </div>
</template>

<script>
import Modal from './Modal.vue';

export default {
  name: 'ModalParent',
  components: { Modal },
  data() {
    return {
      isModalVisible: false,
    };
  },
  methods: {
    showModal() {
      this.isModalVisible = true;
    },
    hideModal() {
      this.isModalVisible = false;
    },
  },
};
</script>
<style></style>
