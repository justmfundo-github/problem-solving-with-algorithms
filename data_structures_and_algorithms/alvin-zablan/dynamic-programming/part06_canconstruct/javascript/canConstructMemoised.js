const canConstruct = (target, wordBank, memo = {}) => {
  if (target in memo) return memo[target];
  if (target === "") return true;

  for (let word of wordBank) {
    // checking to see if word is a prefix of wordBank
    if (target.indexOf(word) === 0) {
      const suffix = target.slice(word.length);
      if (canConstruct(suffix, wordBank, memo) === true) {
        memo[target] = true;
        return true;
      }
    }
  }

  memo[target] = false;
  return false;
};

// Brute force
// time: O(m^n * m)
// space: O(m^2)

// Memoisation
// time: O(n * m^2)
// space: O(m^2)

console.log(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); //true
console.log(canConstruct("scateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); //false
console.log(canConstruct("enterapotentpot", ["a", "p", "ent", "enter", "ot", "o", "t"])); //true
console.log(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", ["e", "ee", "eee", "eeee", "eeeee", "eeeeee"])); //false
