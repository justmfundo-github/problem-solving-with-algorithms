const doubler = (items) => {
  let newArray = [];

  for (let i = 0; i < items.length; i++) {
    // space complexity array of n length
    newArray.push(items[i]);
    newArray.push(items[i]); // addition to array twice
  }
  // final space complexity is O(2n) -----> removing constants -------> O(n)
  return newArray;
};

console.log(doubler(["a", "b", "c"]));
