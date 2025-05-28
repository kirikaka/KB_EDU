import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../pages/AboutPage.vue'),
    },
    {
      path: '/todos',
      name: 'todo',
      component: () => import('../pages/TodoListPage.vue'),
    },
    {
      path: '/todos/add',
      name: 'todo-add',
      component: () => import('../pages/AddTodoPage.vue'),
    },
    {
      path: '/todos/edit/:id',
      name: 'todo-edit',
      component: () => import('../pages/EditPage.vue'),
    },
    {
      path: '/:pathMatch(.*)*',
      name: 'not-found',
      component: () => import('../pages/NotFound.vue'),
    },
  ],
});

export default router;
