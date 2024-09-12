function fibonacci(n) {
    const fib = new Array(n + 1);  // Pre-allocate memory
    fib[0] = 0;
    fib[1] = 1;
    
    for (let i = 2; i <= n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    
    return fib[n];
  }
  
  console.log(fibonacci(10)); // Output: 55
  console.log(fibonacci(100)); // Output: 354224848179262000000