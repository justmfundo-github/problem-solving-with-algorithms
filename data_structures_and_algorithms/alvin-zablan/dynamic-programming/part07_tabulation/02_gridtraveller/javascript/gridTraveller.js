const gridTraveller = (m, n) => {
  const table = Array(m + 1)
    .fill()
    .map(() => Array(n + 1).fill(0));

  table[1][1] = 1;

  for (let i = 0; i <= m; i++) {
    for (let j = 0; j <= n; j++) {
      const current = table[i][j];
      if (j + 1 <= n) table[i][j + 1] += current;
      if (i + 1 <= m) table[i + 1][j] += current;
    }
  }
  //console.log(table);
  return table[m][n];
};

console.log(gridTraveller(1, 1)); // 1
console.log(gridTraveller(2, 3)); // 3
console.log(gridTraveller(3, 2)); // 3
console.log(gridTraveller(3, 3)); // 6
console.log(gridTraveller(18, 18)); // 2333606220
