<template>
  <div v-if="user">
    <h1>{{ user.name }}의 프로필</h1>
    <div>
      <img :src="user.avatar" :alt="user.name" class="avatar" />
      <div>
        <p>ID : {{ user.id }}</p>
        <p>이메일 : {{ user.email }}</p>
        <p>전화번호 : {{ user.phone }}</p>
        <p>가입일 : {{ user.joinDate }}</p>
        <p>직업 : {{ user.occupation }}</p>
      </div>
    </div>
    <div>
      <h2>자기소개</h2>
      <p>{{ user.bio }}</p>
    </div>
  </div>
  <div v-else>
    <h1>사용자를 찾을 수 없습니다.</h1>
    요청하신 ID : {{ id }}
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const usersData = [
  {
    id: '1',
    name: '김철수',
    email: 'cheolsu.kim@example.com',
    phone: '010-1234-5678',
    joinDate: '2022-01-15',
    occupation: '소프트웨어 개발자',
    bio: '안녕하세요! 저는 프론트엔드 개발을 전문으로 하는 개발자입니다. Vue와 React를 주로 사용하며, 사용자 경험을 향상시키는 UI/UX에 관심이 많습니다.',
    avatar: 'https://randomuser.me/api/portraits/men/1.jpg',
  },
  {
    id: '2',
    name: '이영희',
    email: 'younghee.lee@example.com',
    phone: '010-2345-6789',
    joinDate: '2022-03-22',
    occupation: '그래픽 디자이너',
    bio: '창의적인 디자인을 만드는 것에 열정을 가진 그래픽 디자이너입니다. 다양한 브랜드의 아이덴티티와 UI 디자인 프로젝트를 진행해왔으며, 사용자 중심 디자인을 지향합니다.',
    avatar: 'https://randomuser.me/api/portraits/women/2.jpg',
  },
  {
    id: '3',
    name: '박민준',
    email: 'minjun.park@example.com',
    phone: '010-3456-7890',
    joinDate: '2022-06-10',
    occupation: '마케팅 매니저',
    bio: '디지털 마케팅 전략을 수립하고 실행하는 마케팅 매니저입니다. 데이터 분석을 통한 인사이트 도출과 효과적인 커뮤니케이션 전략 개발에 강점이 있습니다.',
    avatar: 'https://randomuser.me/api/portraits/men/3.jpg',
  },
  {
    id: '4',
    name: '정수미',
    email: 'sumi.jung@example.com',
    phone: '010-4567-8901',
    joinDate: '2022-09-05',
    occupation: '제품 매니저',
    bio: '사용자의 니즈를 파악하고 이를 제품에 반영하는 제품 매니저입니다. 다양한 이해관계자와 협업하여 성공적인 제품을 출시한 경험이 있습니다.',
    avatar: 'https://randomuser.me/api/portraits/women/4.jpg',
  },
];
const currentRouteID = useRoute();

const id = computed(() => currentRouteID.params.id);

const user = computed(() => {
  if (id.value === '1') return usersData[0];
  if (id.value === '2') return usersData[1];
  if (id.value === '3') return usersData[2];
  if (id.value === '4') return usersData[3];
});
</script>

<style scoped></style>
