function canSum(targetSum, numbers, memo = {}) {
    // Check if result is in memo
    if (targetSum in memo) return memo[targetSum];
    
    // Base cases
    if (targetSum === 0) return true;
    if (targetSum < 0) return false;
    
    // Recursively try each number
    for (let num of numbers) {
      const remainder = targetSum - num;
      if (canSum(remainder, numbers, memo)) {
        memo[targetSum] = true; // Memoize result
        return true;
      }
    }
    
    memo[targetSum] = false; // Memoize result
    return false;
  }
  
  console.log(canSum(7, [5, 3, 4, 7])); // Output: true
  console.log(canSum(7, [2, 4])); // Output: false
  console.log(canSum(8, [2, 3, 5])); // Output: true
  console.log(canSum(300, [7, 14])); // Output: false