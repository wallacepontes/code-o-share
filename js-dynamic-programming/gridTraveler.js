function gridTraveler(m, n, memo = {}) {
    // Check if the value is already in the memo
    const key = m + ',' + n; // Key as "m,n" to handle grid size combinations
    if (key in memo) return memo[key];
    
    // Base cases
    if (m === 0 || n === 0) return 0; // No ways to travel on 0 dimension grid
    if (m === 1 && n === 1) return 1; // Only one way to travel on 1x1 grid
    
    // Store the result in the memo before returning
    memo[key] = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
    
    return memo[key];
  }
  console.log(gridTraveler(0, 100)); // Output: 0
  console.log(gridTraveler(1, 1)); // Output: 3
  console.log(gridTraveler(2, 3)); // Output: 3
  console.log(gridTraveler(3, 3)); // Output: 6
  console.log(gridTraveler(10, 30)); // Output: 163011640
  