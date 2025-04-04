/* Polynomial O(n^c)
   n is the size of the input
   c is some constant
   includes O(n^2) quadratic, O(n^3) cubic, etc.
*/

const bar = (str) => {
  if (str.length === 0) {
    return;
  }

  const firstChar = str[0];
  const rest = str.slice(1); // Note that slice() is a reason for O(n) complexity
  console.log(firstChar);
  bar(rest); // Recursive call in this case requres O(n) complexity
  // Total complexity is n * n --------> O(n^2)
};

bar("coderbyte");
