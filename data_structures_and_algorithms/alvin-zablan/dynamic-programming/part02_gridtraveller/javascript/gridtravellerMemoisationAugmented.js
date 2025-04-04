/* Gridtraveller with memoisation */
/* -----------------------------------------------------------------------*/
const gridTraveler = (m, n, memo = {}) => {
  const key = m + "," + n;
  if (key in memo) {
    return memo[key];
  }
  // where m and n represent the grid
  if (m === 1 && n === 1) {
    return 1;
  }

  if (m === 0 || n === 0) {
    return 0;
  }

  memo[key] = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
  return memo[key];
};

/* Gridtraveller with memoisation and an augmentation. Accounts for when the key in reverse 
   I.e. '1,2' yields the same results as '2,1'
   So memoisation should allow us to return the same result for both combinations
*/
/* -----------------------------------------------------------------------*/
const gridTravelerAugmented = (m, n, memo = {}) => {
  const key = m + "," + n;
  const keyRev = n + "," + m;

  // console.log("Checking these keys...." + key + "\t" + keyRev);

  if (key in memo || keyRev in memo) {
    // console.log("returning...");
    return memo[key];
  }

  // where m and n represent the grid
  if (m === 1 && n === 1) {
    return 1;
  }

  if (m === 0 || n === 0) {
    return 0;
  }

  memo[key] = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
  memo[keyRev] = memo[key];
  // console.log(memo);
  return memo[key];
};

/* Memoisation with the augmentation should be faster. Let's perform a test to prove this */
const gridMemoStartTime = new Date();
console.log(gridTraveler(50, 50));
const gridMemoEndTime = new Date();

const gridMemoAugmentStartTime = new Date();
console.log(gridTravelerAugmented(50, 50));
const gridMemoAugmentEndTime = new Date();

console.log(`The simply memoised gridtraveller completed in: ${gridMemoEndTime - gridMemoStartTime}ms`);
console.log(`The simply memoised gridtraveller completed in: ${gridMemoAugmentEndTime - gridMemoAugmentStartTime}ms`);
