const fibRecursive = (n, memo = {}) => {
  if (n in memo) {
    return memo[n];
  }
  if (n <= 2) {
    memo[n] = 1;
    return 1;
  }
  memo[n] = fibRecursive(n - 1, memo) + fibRecursive(n - 2, memo);
  return memo[n];
};

const fibTabulation = (n) => {
  const fibArray = Array(n + 1).fill(0);
  fibArray[1] = 1;

  for (let i = 2; i <= n; i++) {
    fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
  }
  return fibArray[n];
};

console.log("----------------Recursive------------------");
// console.log(fibRecursive(0)); // 0
// console.log(fibRecursive(6)); // 8
// console.log(fibRecursive(7)); // 13
// console.log(fibRecursive(8)); // 21
// console.log(fibRecursive(50)); // 12586269025

const fibRecursiveStart = new Date();
console.log(fibRecursive(5000)); // 12586269025
const fibRecursiveEnd = new Date();
const fibRecursiveCompletionTime = fibRecursiveEnd - fibRecursiveStart;
console.log(`Recursive process completed in: ${fibRecursiveCompletionTime}ms`);

console.log("----------------Tabulation------------------");
// console.log(fibTabulation(6)); // 8
// console.log(fibTabulation(7)); // 13
// console.log(fibTabulation(8)); // 21
// console.log(fibTabulation(50)); // 12586269025

const fibTabulationStart = new Date();
console.log(fibTabulation(5000)); // 12586269025
const fibTabulationEnd = new Date();
const fibTabulationCompletionTime = fibTabulationEnd - fibTabulationStart;
console.log(`Tabulation process completed in: ${fibTabulationCompletionTime}ms`);
