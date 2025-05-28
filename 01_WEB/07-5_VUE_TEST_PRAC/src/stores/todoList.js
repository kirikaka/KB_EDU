import { ref, reactive, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useTodoListStore = defineStore('todoList', () => {
  const BASE_URL = '/api/todos';

  // 반응형 상태
  const state = reactive({
    todoList: [
      // {
      //   id: '2',
      //   todo: 'React학습',
      //   desc: '설명2',
      //   done: false,
      // },
      // {
      //   id: '3',
      //   todo: 'ContextAPI 학습',
      //   desc: '설명3',
      //   done: true,
      // },
      // {
      //   id: '4',
      //   todo: '야구경기 관람',
      //   desc: '설명4',
      //   done: false,
      // },
    ],
  });

  //TodoList 목록을 조회
  const fetchTodoList = async () => {
    try {
      const response = await axios.get(BASE_URL);
      console.log('🚀 ~ fetchTodoList ~ response:', response);
      if (response.status === 200) {
        states.todoList = response.data;
      } else {
        alert('데이터 조회 실패');
      }
    } catch (error) {
      alert('에러발생 in fetch:' + error);
    }
  };

  // 기존 TodoItem을 변경
  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    try {
      const payload = { id, todo, desc, done };
      const response = await axios.put(BASE_URL + `/${id}`, payload);

      if (response.status === 200) {
        let index = states.todoList.findIndex((todo) => todo.id === id);
        states.todoList[index] = payload;
        successCallback();
      } else {
        alert('Todo 변경 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  // 새로운 TodoItem을 추가
  const addTodo = async ({ todo, desc }, successCallback) => {
    try {
      const payload = { todo, desc };
      const response = await axios.post(BASE_URL, payload);

      if (response.status === 201) {
        states.todoList.push({ ...response.data, done: false });
        successCallback();
      } else {
        alert('Todo 추가 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  //기존 TodoItem을 삭제
  const deleteTodo = async (id) => {
    try {
      const response = await axios.delete(BASE_URL + `/${id}`);
      console.log(response.status, response.data);

      if (response.status === 200) {
        let index = states.todoList.findIndex((todo) => todo.id === id);
        states.todoList.splice(index, 1);
      } else {
        alert('Todo 삭제 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  //기존 TodoItem의 완료여부(done) 값을 토글
  const toggleDone = async (id) => {
    try {
      let todo = states.todoList.find((todo) => todo.id === id);
      let payload = { ...todo, done: !todo.done };
      const response = await axios.put(BASE_URL + `/${id}`, payload);

      if (response.status === 200) {
        todo.done = payload.done;
      } else {
        alert('Todo 완료 변경 실패');
      }
    } catch (error) {
      alert('에러발생 :' + error);
    }
  };

  const todoList = computed(() => state.todoList);
  const isLoading = computed(() => state.isLoading);
  const doneCount = computed(() => {
    const filtered = state.todoList.filter(
      (todoItem) => todoItem.done === true
    );
    return filtered.length;
  });
  return {
    todoList,
    isLoading,
    doneCount,
    fetchTodoList,
    addTodo,
    deleteTodo,
    updateTodo,
    toggleDone,
  };
});
