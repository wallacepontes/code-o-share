function bestSum(targetSum, numbers) {
    // Base cases
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;
  
    let shortestCombination = null;
  
    for (let num of numbers) {
      const remainder = targetSum - num;
      const remainderCombination = bestSum(remainder, numbers);
      if (remainderCombination !== null) {
        const combination = [...remainderCombination, num]; // Build the new combination
        // If the current combination is shorter than the stored one, replace it
        if (shortestCombination === null || combination.length < shortestCombination.length) {
          shortestCombination = combination;
        }
      }
    }
  
    return shortestCombination;
  }
  
  console.log(bestSum(7, [5, 3, 4, 7])); // Output: [7]
  console.log(bestSum(8, [2, 3, 5])); // Output: [3, 5]
  console.log(bestSum(8, [1, 4, 5])); // Output: [4, 4]
  //console.log(bestSum(100, [1, 2, 5, 25])); // Output: [25, 25, 25, 25] ... too slow
  