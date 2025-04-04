// Analysing the space complexity of the belwo code

const calculateAverage = (numbers) => {
  let sum = 0; // one variable created

  for (let i = 0; i < numbers.length; i++) {
    // counter variable created once
    let number = numbers[i]; // one variable created and used several times however no additional memory required
    sum += number; // because the same variable just changes
  }
  // Space complexity O(3) ------> simplify --------> O(1) (constant time complexity)
  return sum / numbers.length;
};
