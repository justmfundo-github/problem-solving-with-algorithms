const zap = (n) => {
  if (n < 1) {
    console.log("Lift off!!!");
    return;
  }

  console.log(n);
  zap(n - 2);
};

// Both space and time complexity are O(n/2) ------>  with evaluates to ------> O(n)

console.log(zap(10));
