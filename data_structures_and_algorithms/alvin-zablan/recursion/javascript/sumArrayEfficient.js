//in this case we are going to perform the sumArray again but without making a copy of the array that leads to a performance hit
//o(n)  time complexity
const sumArray = (array) => {
  return sumArrayEfficient(array, 0);
};

const sumArrayEfficient = (array, idx) => {
  if (idx == array.length) return 0;

  return array[idx] + sumArrayEfficient(array, idx + 1);
};

const startTime = Date.now();
const input = new Array(5000).fill(1);
//console.log(sumArray([1, 5, 7, -2], 0));
console.log(sumArray(input, 0));
const endTime = Date.now();
console.log(`n finished in ${endTime - startTime}ms`);
