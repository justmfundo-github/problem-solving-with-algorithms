const combinations = (elements) => {
  if (elements.length === 0) return [[]];

  const firstElement = elements[0];
  const restElements = elements.slice(1);
  console.log(restElements);

  const combsWithoutFirst = combinations(restElements);
  const combsWithFirst = [];

  combsWithoutFirst.forEach((comb) => {
    const combWithFirst = [...comb, firstElement];
    combsWithFirst.push(combWithFirst);
  });

  // return [...combsWithoutFirst, ...combsWithFirst];
  return combsWithoutFirst;
  // return combsWithFirst;
};

//console.log(combinations([]));
console.log(combinations(["a", "b", "c"]));
