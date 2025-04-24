/* Assuming that the grid contains at least one island, Write a function, minimumIsland, 
   that takes in a grid containing Ws and Ls. W represents water and L represents land. 
   The function should return the size of the smallest island. An island is a vertically 
   or horizontally connected region of land.
*/

const minimumIsland = (grid) => {
  let minIslandSize = Infinity;
  const visited = new Set();

  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[0].length; col++) {
      const islandSize = depthFirstExplore(grid, row, col, visited);

      if (islandSize > 0 && islandSize < minIslandSize) {
        minIslandSize = islandSize;
      }
    }
  }

  console.log("The smallest island is: " + minIslandSize);
};

const depthFirstExplore = (grid, row, col, visited) => {
  // Ensure that row and col are within the bounds of the grid
  const rowInbounds = 0 <= row && row < grid.length;
  const colInbounds = 0 <= col && col < grid[0].length;

  if (!rowInbounds || !colInbounds) return false;

  // Ensure that we are processing an island instead of water
  if (grid[row][col] === "W") return 0;

  // Ensure that the grid location has not been visited before
  // Create a unique identifier based on row and col
  const pos = row + "," + col;
  if (visited.has(pos)) return 0;
  visited.add(pos);

  // now to recursively explore each node when we run into "L" land.
  let islandSize = 1;
  islandSize += depthFirstExplore(grid, row - 1, col, visited);
  islandSize += depthFirstExplore(grid, row + 1, col, visited);
  islandSize += depthFirstExplore(grid, row, col - 1, visited);
  islandSize += depthFirstExplore(grid, row, col + 1, visited);

  // console.log(islandSize);
  return islandSize; //for every successful find
};

const grid = [
  ["W", "L", "W", "W", "W"],
  ["W", "L", "W", "W", "W"],
  ["W", "W", "W", "L", "W"],
  ["W", "W", "L", "L", "W"],
  ["L", "W", "W", "L", "L"],
  ["L", "L", "W", "W", "W"],
];

minimumIsland(grid); // -> 2
