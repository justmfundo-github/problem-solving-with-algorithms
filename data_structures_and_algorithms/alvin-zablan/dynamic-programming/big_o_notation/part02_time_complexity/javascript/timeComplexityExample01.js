//Assessing the time complexity of the below code

const foo = (n) => {
  for (let a = 0; a < n / 2; a++) {
    // if you consider this for loop in isolation, time complexity is: O(n)
    console.log(a);
  }

  for (let b = 0; b < n; b++) {
    // Time complexity for this loop is O(n)
    for (let c = 0; c < n; c++) {
      // Time complexity for this loop is O(n)
      console.log(b + ", " + c); // HOWEVER, becuase this is a nested loop time complexity of the two loops is: n * n
    }
  } // In the end if you consider all the above code, time complexity is: n + n*n -----> sum rule ------> n^2
};

foo(10);
