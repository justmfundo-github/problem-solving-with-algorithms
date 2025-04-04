const zoom = (n) => {
  if (n === 0) {
    console.log("lift off!!");
    return;
  }

  console.log(n);
  zoom(n - 1);
};
// time complexity: O(n) zoom is called n times while all the other parts to the code are constants
// space complexity: O(n) call stack grows n times with each call to zoom
zoom(10);
