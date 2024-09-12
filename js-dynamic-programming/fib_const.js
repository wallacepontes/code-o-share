function fibonacci(n) {
    if (n <= 1) return n;
    
    let prev = 0, curr = 1;
    
    for (let i = 2; i <= n; i++) {
      const next = prev + curr;
      prev = curr;
      curr = next;
    }
    
    return curr;
  }
  
  console.log(fibonacci(10)); // Output: 55
  console.log(fibonacci(100)); // Output: 354224848179262000000