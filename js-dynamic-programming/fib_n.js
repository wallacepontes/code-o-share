function fibonacci(n) {
    let fib = [0, 1];
    
    for (let i = 2; i <= n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }
    
    return fib[n];
  }
  
  console.log(fibonacci(1)); // Output: 1
  console.log(fibonacci(2)); // Output: 1
  console.log(fibonacci(10)); // Output: 55
  console.log(fibonacci(50)); // Output: 12586269025
  console.log(fibonacci(100)); // Output: 354224848179262000000
  console.log(fibonacci(1000)); // Output: 4.346655768693743e+208