const locationOne = {
  country: 'korea',
};

const locationTwo = {
  country: 'korea',
};

console.log(locationOne === locationTwo);

const jsonLocationOne = JSON.stringify(locationOne);
const jsonLocationTwo = JSON.stringify(locationTwo);
console.log(jsonLocationOne === jsonLocationTwo);
