/* Write a function, islandCount, that takes in a grid containing Ws and Ls. 
   W represents water and L represents land. The function should return the number of 
   islands on the grid. An island is a vertically or horizontally connected region of land.
*/
const islandCount = (grid) => {
  const visited = new Set();
  let islandCount = 0;
  // let's start by iterating through our grid to find the first L
  for (let r = 0; r < grid.length; r++) {
    for (let c = 0; c < grid[0].length; c++) {
      // If we hit land then we need to do a depth first traversals of all connected Ls
      if (depthTraverseGraph(grid, r, c, visited)) {
        islandCount += 1;
      }
    }
  }
  console.log("Number of islands is: " + islandCount);
};

const depthTraverseGraph = (grid, row, col, visited) => {
  // first ensure that we are not processing cells outside of the grid
  const rowInbounds = 0 <= row && row < grid.length;
  const colInbounds = 0 <= col && col < grid[0].length;

  if (!rowInbounds || !colInbounds) return false;

  if (grid[row][col] == "W") return false;

  // now ensure that we have not visited this node already
  const pos = row + "," + col;
  if (visited.has(pos)) return false;
  visited.add(pos);

  // now to do the actual depth first traversal recursively
  depthTraverseGraph(grid, row - 1, col, visited);
  depthTraverseGraph(grid, row + 1, col, visited);
  depthTraverseGraph(grid, row, col - 1, visited);
  depthTraverseGraph(grid, row, col + 1, visited);

  return true;
};

const grid = [
  ["W", "L", "W", "W", "W"],
  ["W", "L", "W", "W", "W"],
  ["W", "W", "W", "L", "W"],
  ["W", "W", "L", "L", "W"],
  ["L", "W", "W", "L", "L"],
  ["L", "L", "W", "W", "W"],
];

islandCount(grid); // -> 3
