# Dynamic Programming - Learn to Solve Algorithmic Problems & Coding Challenges

Here's a simple JavaScript function to calculate the Fibonacci sequence using recursion:

```javascript
function fibonacci(n) {
  if (n <= 1) {
    return n;
  }
  return fibonacci(n - 1) + fibonacci(n - 2);
}

console.log(fibonacci(10)); // Output: 55
```

This function recursively calculates the Fibonacci number at position `n`. However, this method has exponential time complexity and can be slow for large values of `n`. Here's an optimized version using dynamic programming to improve performance:

```javascript
function fibonacci(n) {
  let fib = [0, 1];
  
  for (let i = 2; i <= n; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];
  }
  
  return fib[n];
}

console.log(fibonacci(10)); // Output: 55
```

This dynamic programming approach has a time complexity of O(n) and is much more efficient for larger values of `n`.

## Memoization

Memoization is a great way to improve the efficiency of the recursive Fibonacci function by storing previously calculated values. This reduces redundant calculations, giving a time complexity of O(n) without the need for an iterative approach.

Here’s how you can implement memoization:

### Memoized Recursive Fibonacci Function

```javascript
function fibonacci(n, memo = {}) {
  if (n in memo) return memo[n];
  if (n <= 1) return n;
  
  memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
  return memo[n];
}

console.log(fibonacci(10)); // Output: 55
```

### How it Works:
- We pass an object `memo` that stores the Fibonacci values already computed.
- Before calculating the Fibonacci value of `n`, the function checks if it's already in `memo`. If it is, the stored value is returned, avoiding recalculation.
- If not, the function computes the value and stores it in `memo` for future use.

This method retains the simplicity of the recursive approach while offering the performance benefits of dynamic programming by avoiding duplicate calculations.

## JavaScript, arrays do not always allocate a fixed memory space

You're correct that in JavaScript, arrays do not always allocate a fixed memory space like in lower-level languages such as C or C++. Arrays are dynamically sized, and memory reallocation happens as they grow. This can cause performance issues, especially for large datasets or performance-critical applications, as memory allocation and resizing may occur frequently.

To mitigate these concerns and improve performance, you can consider the following strategies:

### 1. **Pre-allocate Memory for Arrays**
By pre-allocating a fixed size for arrays, you can avoid frequent memory reallocations and resizing during runtime.

#### Example:
```javascript
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
```

In this example, the `new Array(n + 1)` allocates memory upfront, reducing the number of memory allocations required during execution.

### 2. **Iterative Approach with Constant Space**
Instead of storing all Fibonacci numbers, you can optimize further by only keeping track of the last two values. This reduces the memory usage to O(1) (constant space complexity).

#### Example:
```javascript
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
```

This version doesn’t require an array at all, but instead uses just two variables (`prev` and `curr`), which significantly reduces memory usage while maintaining O(n) time complexity.

### 3. **Typed Arrays**
If you're working with large datasets and want more control over memory, consider using **Typed Arrays** like `Int32Array` or `Float64Array`. Typed arrays are closer to the low-level array structures in languages like C, and they offer better performance for numerical computations as they store data in a more memory-efficient way.

#### Example Using `Int32Array`:
```javascript
function fibonacci(n) {
  const fib = new Int32Array(n + 1);  // Pre-allocated, fixed-size typed array
  fib[0] = 0;
  fib[1] = 1;

  for (let i = 2; i <= n; i++) {
    fib[i] = fib[i - 1] + fib[i - 2];
  }

  return fib[n];
}

console.log(fibonacci(10)); // Output: 55
```

Typed arrays ensure that each element is stored in a fixed number of bytes (e.g., `Int32Array` uses 4 bytes per element), which reduces overhead and improves cache efficiency.

### Summary of Improvements:
- **Pre-allocate memory**: Allocate arrays with a fixed size to avoid dynamic resizing.
- **Constant space optimization**: Use an iterative approach with only two variables to minimize memory usage.
- **Typed Arrays**: Use `TypedArray` for improved memory efficiency, especially when dealing with large data or numerical computations.

These strategies can help improve the performance of JavaScript Fibonacci implementations, especially for large inputs or performance-critical scenarios.

## Videos

* [Dynamic Programming - Learn to Solve Algorithmic Problems & Coding Challenges](https://www.youtube.com/watch?v=oBt53YbR9Kk)
	> [<img src="https://img.youtube.com/vi/oBt53YbR9Kk/0.jpg" width="200">](https://www.youtube.com/watch?v=oBt53YbR9Kk "Dynamic Programming - Learn to Solve Algorithmic Problems & Coding Challenges by Bouali Ali 51,714 views 3 hours, 17 minutes")
