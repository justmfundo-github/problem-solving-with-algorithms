/*
  Given a target sum and an array of numbers, determine what combination (if any) of numbers in the array 
  can lead to the target sum when added together? Return an array of the numbers that can be added together to 
  give the target sum. 

  This tree can be represented in the same way as the canSum problem. Starting with a node of the target sum, subract each 
  value in the numbers array from the node(as a branch). Recursively.

  Note that as the targetSum grows, the ability to compute this value diminishes exponentially. To combat that, we use memoisation.
*/

const howSum = (targetSum, numbers, memo = {}) => {
  //base cases
  if (targetSum in memo) return memo[targetSum];
  if (targetSum === 0) return []; //return empty array
  if (targetSum < 0) return null; //return null

  for (let num of numbers) {
    const remainder = targetSum - num;
    const remainderResult = howSum(remainder, numbers, memo);
    if (remainderResult !== null) {
      //add the remainder to the return array
      memo[targetSum] = [...remainderResult, num];
      return memo[targetSum];
    }
  }
  memo[targetSum] = null;
  return memo[targetSum];
};

// m = target sum
// n = numbers length

// Brute force space and time complexity
// time = O(m^n * m)
// space = O(m)

// Memoised space and time complexity
// time = O(n * m^2)
// space = O(m^2)

console.log(howSum(7, [2, 3]));
console.log(howSum(7, [5, 3, 4, 7]));
console.log(howSum(7, [2, 4]));
console.log(howSum(8, [2, 3, 5]));
console.log(howSum(300, [7, 14]));
console.log(howSum(0, [7, 14, -11]));
console.log(howSum(230, [7, 14, -11]));
