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
      path: '/login',
      name: 'login',
      component: () => import('@/pages/LoginPage.vue'),
    },
    {
      path: '/todo',
      name: 'todo',
      component: () => import('@/pages/todo/TodoPage.vue'),
      meta: { requiresAuth: true },
    },
    {
      path: '/todo/detail/:id',
      name: 'todo/detail',
      component: () => import('@/pages/todo/TodoDetailPage.vue'),
      meta: { requiresAuth: true },
      props: true,
    },
    {
      path: '/todo/write',
      name: 'todo/write',
      component: () => import('@/pages/todo/TodoWritePage.vue'),
      meta: { requiresAuth: true },
      props: true,
    },
    {
      path: '/todo/edit',
      name: 'todo/edit',
      component: () => import('@/pages/todo/TodoEditPage.vue'),
      meta: { requiresAuth: true },
      props: true,
    },
    {
      path: '/pinia',
      name: 'pinia',
      component: () => import('@/pages/pinia/PiniaPage.vue'),
    },
  ],
});


router.beforeEach((to, from, next) => {
  if (to.matched.some((record) => record.meta.requiresAuth)) {
    if (localStorage.getItem('auth') === 'true') {
      console.log('로그인 한 사용자.');
      next();
    } else {
      alert('로그인이 필요합니다.');
      next({ name: 'login' }); //라우터 푸시랑 같은 개념.
    }
  } else {
    next();
  }
});

export default router;
