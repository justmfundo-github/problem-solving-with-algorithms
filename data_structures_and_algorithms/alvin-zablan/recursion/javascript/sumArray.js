//o(n^2) time complexity

const sumArray = (array) => {
  if (array.length === 0) return 0;

  const restofArray = array.slice(1);
  return array[0] + sumArray(restofArray);
};

const startTime = Date.now();
const input = new Array(5000).fill(1);
//console.log(sumArray([1, 5, 7, -2], 0));
console.log(sumArray(input, 0));
const endTime = Date.now();
console.log(`n finished in ${endTime - startTime}ms`);
