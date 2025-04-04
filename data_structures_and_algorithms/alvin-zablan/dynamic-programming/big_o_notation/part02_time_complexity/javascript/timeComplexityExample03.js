//Assessing the time complexity of the below code

const boom = (n) => {
  for (let i = 0; i < 3; i++) {
    // loop causes a constant time complexity.
    bam(n); // Call to this function has implications on tome complexity depending on what the function does.
  }

  for (let k = 0; k < 10000; k++) {
    console.log(k);
  }

  // In the end if you consider all the above code, time complexity is: 10000 + 3n -----> sum rule ------> n
};

const bam = (m) => {
  // Time complexity for this loop is O(n)
  for (let j = 0; j < m; j++) {
    console.log(j);
  }
};

bar(10);
