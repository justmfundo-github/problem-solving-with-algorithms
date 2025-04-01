/*
 * Creating a short program to measure the time taken to process the sum of values in an array.
 * By running this program multiple times you should see a variance in the speed taken to complete the task.
 * This illustrates the need to determine some way of measuring how a piece of code should performm.
 */

const doSum = (numbers) => {
  let sum = 0;
  for (let i = 0; i < numbers.length; i++) {
    sum += i;
  }
  return sum;
};

const array = [5, 76, 40, 48, 24, 18, 62, 100, 99, 22, 95, 72, 91];

const starTime = new Date();
console.log(doSum(array));
const endTime = new Date();

const elapsedTime = endTime - starTime;
console.log(`Elapsed time is: ${elapsedTime}ms`);
