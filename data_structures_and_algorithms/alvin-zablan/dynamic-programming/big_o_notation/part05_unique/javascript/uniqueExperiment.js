// Let's compare the speed of the unique.js function and the uniqueOptimised.js function

// Unique
const uniqueSlow = (animals) => {
  let newArray = [];

  for (let i = 0; i < animals.length; i++) {
    if (!newArray.includes(animals[i])) {
      newArray.push(animals[i]);
    }
  }
  return newArray;
};

// UniqueOptimised
const uniqueFast = (animals) => {
  const uniqueAnimalsSet = new Set();

  for (let i = 0; i < animals.length; i++) {
    const ele = animals[i];
    uniqueAnimalsSet.add(ele);
  }
  return Array.from(uniqueAnimalsSet);
};

// Randomised test array data
const randomArray = [];

for (let i = 0; i < 10000000; i++) {
  randomArray.push(Math.floor(Math.random() * 100));
}

// Function tests using above randomArray

const startSlow = new Date();
console.log(uniqueSlow(randomArray));
const endSlow = new Date();
//console.log("Slow finished in: " + (endSlow - startSlow) + "ms"); // also works
console.log(`Slow finished in: ${endSlow - startSlow} ms`);

const startFast = new Date();
console.log(uniqueFast(randomArray));
const endFast = new Date();
//console.log("Fast finished in: " + (endFast - startFast) + "ms"); // also works
console.log(`Fast finished in: ${endFast - startFast} ms`);
