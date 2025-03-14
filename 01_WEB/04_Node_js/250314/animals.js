// const animals = ['dog', 'cat'];

// exports.animals=animals
// // 선언하고 넣기

// exports.showAnimals=function showAnimals() {
//   animals.map(function (el) {
//     console.log('🚀 ~ animals.map ~ el:', el);
//   });
// }
// // 선언하면서 export

const animals = {
  animals: ['dog', 'cat'],
  showAnimals() {
    this.animals.map((el) => {
      console.log('🚀 ~ this.animals.map ~ el:', el);
    });
  },
};
module.exports = animals;
