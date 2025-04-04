/* Logarithms
   A log is the opposite of an exponent
   An exponent is a repeated multiplication.
   A log is a repeated division. 
   If 2^5 = 32, then log2(32) = 5
*/

const fun = (n) => {
  while (n > 1) {
    console.log(n);
    n /= 2;
  }
  console.log("done");
};

fun(32);

const foo = (n) => {
  if (n <= 1) {
    console.log("hooray");
    return;
  }

  console.log(n);
  foo(n / 2);
};

foo(30);
