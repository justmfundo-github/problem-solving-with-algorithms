//Assessing the time complexity of the below code

const bar = (n) => {
  for (let i = 0; i < 3; i++) {
    // Time complexity for this loop is O(1) because loop occurs a constant number of times
    for (let j = 0; j < n; j++) {
      // Time complexity for this loop is O(n)
      console.log(j); // Time complexity of the above nested for loop is: 3*n
    }
  }

  for (let k = 0; k < 10000; k++) {
    console.log(k);
  }

  // In the end if you consider all the above code, time complexity is: 10000 + 3n -----> sum rule ------> n
};

bar(10);
