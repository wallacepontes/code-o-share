function howSum(targetSum, numbers, memo = {}) {
    // Check if result is in memo
    if (targetSum in memo) return memo[targetSum];
  
    // Base cases
    if (targetSum === 0) return [];
    if (targetSum < 0) return null;
  
    // Try each number in the array
    for (let num of numbers) {
      const remainder = targetSum - num;
      const remainderResult = howSum(remainder, numbers, memo); // Recursive call with memoization
      if (remainderResult !== null) {
        memo[targetSum] = [...remainderResult, num]; // Memoize result
        return memo[targetSum];
      }
    }
  
    memo[targetSum] = null; // Memoize failure result
    return null;
  }
  
  console.log(howSum(7, [5, 3, 4, 7])); // Output: [3, 4] or [7]
  console.log(howSum(8, [2, 3, 5])); // Output: [3, 5] or [2, 2, 2, 2]
  console.log(howSum(7, [2, 4])); // Output: null
  console.log(howSum(0, [1, 2, 3])); // Output: []
  console.log(howSum(300,[7,14])); //null