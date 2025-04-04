/* Loglinear O(n*log(n)) 
   Has linear behaviour nested in log steps
   Is larger that O(n) but smaller than O(n^2)
*/

const bar = (str) => {
  console.log(str);
  if (str.length <= 1) {
    return;
  }
  const midIdx = Math.floor(str.length / 2); // time complexity log(n) because each iteration halfs the string length
  bar(str.slice(0, midIdx)); // slice time complexity is n/2
};
// Total time complexity: O(n*log(n))
bar("abcdefghijklmnopqrstuvwxyz");

const foo = (charArray) => {
  let str = "";
  for (let i = 0; i < charArray.length; i++) {
    str += charArray[i];
  }
  console.log(str);
  console.log("--------");

  if (charArray.length <= 1) {
    return;
  }

  let midIdx = Math.floor(charArray.length / 2);
  let left = charArray.slice(0, midIdx);
  let right = charArray.slice(midIdx);

  foo(left);
  foo(right);
};

foo(["a", "b", "c", "d", "e", "f", "g", "h"]);
