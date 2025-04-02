// Write a function that takes in an array, and returns a new arraying
// containing only the unique elements.

// Example: unique(['cat', 'dog', 'rat', 'dog', 'cat', 'bird']);
// Returns ['cat', 'dog', 'rat', 'bird']

const unique = (animals) => {
  // create the new array to add unique elements to
  let newArray = [];

  // iterate through the animals and store only unique animals to the new array
  for (let i = 0; i < animals.length; i++) {
    // O(n) for this loop
    if (!newArray.includes(animals[i])) {
      // O(n) for the loop within the includes function
      newArray.push(animals[i]); // The if statement is the time complexity bottleneck assuming there is another loop in includes function
    }
  }
  // The above two loops push the time complexity to O(n^2)
  return newArray;
};

console.log(unique(["cat", "dog", "rat", "dog", "cat", "bird"]));
