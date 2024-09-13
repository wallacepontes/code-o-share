function bestSum(targetSum, numbers, memo = {}) {
    // Check memo for stored result
    if (targetSum in memo) return memo[targetSum];
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;
  
    let shortestCombination = null;
  
    for (let num of numbers) {
      const remainder = targetSum - num;
      const remainderCombination = bestSum(remainder, numbers, memo); // Recursive call with memoization
      if (remainderCombination !== null) {
        const combination = [...remainderCombination, num];
        // If the current combination is shorter, update the shortestCombination
        if (shortestCombination === null || combination.length < shortestCombination.length) {
          shortestCombination = combination;
        }
      }
    }
  
    memo[targetSum] = shortestCombination; // Memoize the result
    return shortestCombination;
  }
  
  console.log(bestSum(7, [5, 3, 4, 7])); // Output: [7]
  console.log(bestSum(8, [2, 3, 5])); // Output: [3, 5]
  console.log(bestSum(8, [1, 4, 5])); // Output: [4, 4]
  console.log(bestSum(100, [1, 2, 5, 25])); // Output: [25, 25, 25, 25]