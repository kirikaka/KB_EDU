import { createApp } from 'vue';
import { createPinia } from 'pinia'; //상태관리 라이브러리

import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(router);
app.use(createPinia());

app.mount('#app');
