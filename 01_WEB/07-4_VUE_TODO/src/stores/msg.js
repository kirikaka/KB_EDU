import { ref, computed } from 'vue';
import { defineStore } from 'pinia';
export const useMessageStore = defineStore('Message', () => {
  // 이게 상태가 되는거야
  const msg = ref('기본 메시지 입니다.');
  // 상태를 변경할 수 있는 방법은 내부에 존재해야 함 - 다른 사람은 함수를 가져다 쓰는거야
  function editMsg(editmsg) {
    msg.value = editmsg;
  }

  return { msg, editMsg };
});
