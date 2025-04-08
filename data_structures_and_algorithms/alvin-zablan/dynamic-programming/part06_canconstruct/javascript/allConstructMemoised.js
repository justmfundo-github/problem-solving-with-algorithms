const allConstruct = (target, wordBank, memo = {}) => {
  if (target in memo) return memo[target];
  if (target === "") return [[]];

  const result = [];

  for (let word of wordBank) {
    if (target.indexOf(word) === 0) {
      const suffix = target.slice(word.length);
      const suffixWays = allConstruct(suffix, wordBank, memo);
      const targetWays = suffixWays.map((way) => [word, ...way]);

      result.push(...targetWays);
    }
  }

  memo[target] = result;
  return result;
};

// Brute force
// time: O(m^n * m)
// space: O(m^2)

// Memoisation
// time: O(n * m^2)
// space: O(m^2)

console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // [abc, def]
console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd", "ef", "c"])); // [[ab, cd, ef][ab, c, def][abc, def][abcd, ef]]
console.log(allConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); // [[purp, le][p, ur, p, le]]
console.log(allConstruct("scateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); //false
console.log(allConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); // true
console.log(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee", "eeeee", "eeeeee"])); //false
