const countConstruct = (target, wordBank, memo = {}) => {
  if (target in memo) return memo[target];
  if (target === "") return 1;

  let totalCount = 0;

  for (let word of wordBank) {
    if (target.indexOf(word) === 0) {
      const numWaysForRest = countConstruct(target.slice(word.length), wordBank, memo);
      totalCount += numWaysForRest;
    }
  }
  memo[target] = totalCount;
  return totalCount;
};

// Brute force
// time: O(m^n * m)
// space: O(m^2)

// Memoisation
// time: O(n * m^2)
// space: O(m^2)

console.log(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // 1
console.log(countConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); // 2
console.log(countConstruct("scateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); //false
console.log(countConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); // true
console.log(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee", "eeeee", "eeeeee"])); //false
