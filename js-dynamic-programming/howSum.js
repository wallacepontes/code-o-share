function howSum(targetSum, numbers) {
    // Base cases
    if (targetSum === 0) return []; // Successfully summed to targetSum
    if (targetSum < 0) return null; // Overshot targetSum, return failure
  
    // Try each number in the array
    for (let num of numbers) {
      const remainder = targetSum - num;
      const remainderResult = howSum(remainder, numbers); // Recursive call
      if (remainderResult !== null) {
        return [...remainderResult, num]; // If remainderResult is not null, return combination
      }
    }
  
    return null; // No combination found
  }
  
  console.log(howSum(7, [5, 3, 4, 7])); // Output: [3, 4] or [7]
  console.log(howSum(8, [2, 3, 5])); // Output: [3, 5]
  console.log(howSum(7, [2, 4])); // Output: null
  console.log(howSum(0, [1, 2, 3])); // Output: []
  console.log(howSum(8, [2, 3, 5])); // Output: []
  console.log(howSum(300,[7,14])); //null ... too slow