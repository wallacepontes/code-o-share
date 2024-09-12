function fibonacci(n, memo = {}) {
    if (n in memo) return memo[n];
    if (n <= 1) return n;
    
    memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
    return memo[n];
  }
  
  console.log(fibonacci(10)); // Output: 55
  console.log(fibonacci(100)); // Output: 354224848179262000000