const foo = (array) => {
  for (let i = 0; i < array.length; i++) {
    console.log(array[i]);
  }
};

foo(["soho", "nomad", "tribeca", "dumbo", "les"]);

const bar = (n) => {
  if (n === 0) {
    return;
  }

  console.log(n);
  bar(n - 1);
};

bar(5);
