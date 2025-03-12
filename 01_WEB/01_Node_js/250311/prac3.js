const personalInfo = {
  name: '이효석',
  age: "Don't ask this",
  email: 'xenosign@naver.com',
};

const jobInfo = {
  position: '코딩 강사',
  experience: '?년',
};

const profile = { ...personalInfo, ...jobInfo, addr: '서대문구' };
const { name, age, email, position, experience, addr } = profile;

console.log(name);
console.log(age);
console.log(email);
console.log(position);
console.log(experience);
console.log(addr);
