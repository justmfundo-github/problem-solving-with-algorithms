// Write a function that takes in an array, and returns a new arraying
// containing only the unique elements.

// Example: unique(['cat', 'dog', 'rat', 'dog', 'cat', 'bird']);
// Returns ['cat', 'dog', 'rat', 'bird']

const unique = (animals) => {
  /* BUT, let's do things in an efficient way this time removing the potential bottleneck */
  // start by using a different data structure to store the new array

  let uniqueAnimalsSet = new Set();

  // iterate through the animals and store only unique animals to the new array

  for (let i = 0; i < animals.length; i++) {
    // O(n) for this loop
    uniqueAnimalsSet.add(animals[i]); // A set won't add an element if it isn't unique to the set
    // So set uses constant time to insert and handles the unique requirement
  }
  // The above for loop now creates a total time complexity of O(n)
  return Array.from(uniqueAnimalsSet); // Conversion uses O(n) time to iterate through the set and add elements to returned array
  /* Final Time complexity: O(n + n) -------> sum rule --------> O(n) */
};

console.log(unique(["cat", "dog", "rat", "dog", "cat", "bird"]));
