const fib = (n, memo = {}) => {
  //memo is an empty opbject that will be filled as the program runs
  if (n in memo) {
    return memo[n];
  }
  if (n <= 2) {
    return 1;
  }

  memo[n] = fib(n - 1, memo) + fib(n - 2, memo); // without memoisation, the program cannot process high values of n quickly
  return memo[n];
};

console.log(fib(1));
console.log(fib(2));
console.log(fib(3));
console.log(fib(4));
console.log(fib(5));
console.log(fib(6));
console.log(fib(20));
