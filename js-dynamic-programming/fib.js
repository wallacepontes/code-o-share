function fibonacci(n) {
    if (n <= 1) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }
  console.log(fibonacci(1)); // Output: 1
  console.log(fibonacci(2)); // Output: 1
  console.log(fibonacci(10)); // Output: 55
  // don't try this : console.log(fibonacci(50)); // Output: ??