// export const animals = ['dog', 'cat'];

// export function showAnimals() {
//   animals.map((el) => console.log('🚀 ~ animals.map ~ el:', el));
// }

/*
const animals = ['dog', 'cat'];

function showAnimals() {
  animals.map((el) => console.log('🚀 ~ animals.map ~ el:', el));
}
export { animals as ani, showAnimals as show };
*/

// 해당 파일에서 기본적으로 이친구를 가져다 써라.
const animals = {
  animals: ['dog', 'cat'],
  showAnimals() {
    this.animals.map((el) => {
      console.log(el);
    });
  },
};

export default animals;
