function canSum(targetSum, numbers) {
    // Base cases
    if (targetSum === 0) return true;  // Success: reached the target sum
    if (targetSum < 0) return false;   // Failure: overshot the target sum
  
    // Recursively try each number
    for (let num of numbers) {
      const remainder = targetSum - num;
      if (canSum(remainder, numbers)) {
        return true; // If we can sum to the remainder, we can sum to targetSum
      }
    }
  
    return false; // None of the numbers could sum to targetSum
  }
  
  console.log(canSum(7, [5, 3, 4, 7])); // Output: true
  console.log(canSum(7, [2, 4])); // Output: false
  //console.log(canSum(300, [7, 14])); // Output: false 