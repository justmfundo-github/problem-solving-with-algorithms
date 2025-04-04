/*




You should be able to represent this problem with a tree structure.
Top level node should be represented by the Sum(number we are trying to check combinations for)
Branches should represent the possible numbers available. I.e can be subtracted from the Sum(node) without going into negative
Further branches should also represent the possible numbers that can be subtracted from the node without going into the negative
The base case occurs when any further subtractions will lead to negative values. 
A node with the value 0(zero) represents a succesful path of nodes leading to the desired sum(I.e answer is True)
canSum(7, [5, 3, 4, 7])
*/

const canSum = (targetSum, numbers, memo = {}) => {
  //Keeping the below line of code as a reminder on how to print out an object
  /*
    str = JSON.stringify(memo, null, 4); // (Optional) beautiful indented output.
    console.log(str);
  */
  if (targetSum in memo) {
    return memo[targetSum];
  }
  if (targetSum === 0) return true;
  if (targetSum < 0) return false;

  for (let num of numbers) {
    const remainder = targetSum - num;
    if (canSum(remainder, numbers, memo) === true) {
      memo[targetSum] = true;
      return true;
    }
  }
  memo[targetSum] = false;
  return false;
};

console.log(canSum(7, [2, 3])); //true
console.log(canSum(7, [5, 3, 4, 7])); //true
console.log(canSum(7, [2, 4])); //false
console.log(canSum(8, [2, 3, 5])); //true
console.log(canSum(300, [7, 14])); //false
