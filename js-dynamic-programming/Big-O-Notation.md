# Big O Notation

## Course Contents

- [Big O Notation](#big-o-notation)
  - [Course Contents](#course-contents)
  - [Introduction](#introduction)
  - [What Is Big O?](#what-is-big-o)
  - [O(n^2) Explanation](#on2-explanation)
  - [O(n^3) Explanation](#on3-explanation)
  - [O(log n) Explanation Recursive](#olog-n-explanation-recursive)
  - [O(log n) Explanation Iterative](#olog-n-explanation-iterative)
  - [O(log n) What Is Binary Search?](#olog-n-what-is-binary-search)
  - [O(log n) Coding Binary Search](#olog-n-coding-binary-search)
  - [O(n log n) Explanation](#on-log-n-explanation)
  - [O(n log n) Coding Merge Sort](#on-log-n-coding-merge-sort)
  - [O(n log n) Merge Sort Complexity Deep Dive](#on-log-n-merge-sort-complexity-deep-dive)
  - [O(2^n) Explanation With Fibonacci](#o2n-explanation-with-fibonacci)
  - [O(n!) Explanation](#on-explanation)
  - [Space Complexity \& Common Mistakes](#space-complexity--common-mistakes)
  - [End](#end)
  - [Video](#video)

---

## Introduction

Big O Notation is used to classify algorithms based on how fast they grow or decline.

![img](https://miro.medium.com/v2/resize:fit:1400/1*C2eb62mFQXHfa7VdXgu-jA.png)

## What Is Big O?

**Big O Notation** is a mathematical notation used to describe the asymptotic behavior of functions. In the context of algorithms, it's used to analyze the time and space complexity, providing a way to estimate how an algorithm's performance will scale as the input size increases.

**Key points about Big O Notation:**

* **Asymptotic Behavior:** It focuses on the behavior of the function as the input size approaches infinity.
* **Worst-Case Analysis:** Typically, Big O notation is used to analyze the worst-case scenario, providing an upper bound on the algorithm's performance.
* **Common Notations:**
  * **O(1):** Constant time. The algorithm's performance remains the same regardless of the input size.
  * **O(log n):** Logarithmic time. The algorithm's performance increases slowly as the input size grows.
  * **O(n):** Linear time. The algorithm's performance increases linearly with the input size.
  * **O(n^2):** Quadratic time. The algorithm's performance increases quadratically with the input size.
  * **O(2^n):** Exponential time. The algorithm's performance grows exponentially with the input size.

| Orders of Growth              | Time |
| :---------------- | :------: |
| O(1)        |   Constant   |
| O(log n)           |   Logarithmic   |
| O(n)    |  Linear   |
| O(n log n) |  Linearithmic   |
| O(n^2) |  Quadratic   |
| O(n^3) |  Cubic   |
| O(2^n) |  Exponential   |
| O(n!) |  Factorial   |

By understanding Big O notation, you can compare the efficiency of different algorithms and choose the most appropriate one for a given problem.


## O(n^2) Explanation
Discussion on O(n^2), a quadratic complexity often seen in nested loops. Examples of algorithms like bubble sort are used for explanation.

```java
function square(n) {
    for (let i=0; i<n; i++) {
        for (let j=0; i<n; j++) {
            console.(i,j);
        }
    }
}
```

## O(n^3) Explanation
Explanation of cubic complexity O(n^3), often seen when triple nested loops are involved, showing how the time grows as the cube of the input size.

```java
function cube(n) {
    for (let i=0; i<n; i++) {
        for (let j=0; i<n; j++) {
            for (let k=0; k<n; k++) {
                console.(i,j,k);
            }
        }
    }
}
```

## O(log n) Explanation Recursive
Understanding O(log n) complexity through recursive processes, explaining how logarithmic time reduces the problem size by a factor each time.

## O(log n) Explanation Iterative
Explaining O(log n) complexity in an iterative context, with examples like binary search to show how the problem size halves with each iteration.

## O(log n) What Is Binary Search?
Introduction to binary search, a divide-and-conquer algorithm that runs in O(log n) time, efficiently searching sorted arrays.

## O(log n) Coding Binary Search
A coding walkthrough of binary search implementation, demonstrating the logarithmic complexity in action.

## O(n log n) Explanation
Explanation of O(n log n), common in efficient sorting algorithms like merge sort and quicksort, where the input is divided and processed in log n depth.

## O(n log n) Coding Merge Sort
Step-by-step coding explanation of merge sort, highlighting its O(n log n) time complexity.

## O(n log n) Merge Sort Complexity Deep Dive
A detailed analysis of why merge sort operates in O(n log n) time, including a breakdown of recursive calls and merging steps.

## O(2^n) Explanation With Fibonacci
Explanation of O(2^n), an exponential complexity, using the recursive Fibonacci sequence as an example of how runtime doubles with each increase in input size.

## O(n!) Explanation
Introduction to factorial complexity, O(n!), which grows extremely fast. Examples include combinatorial problems such as solving the traveling salesman problem.

## Space Complexity & Common Mistakes
Discussion of space complexity, how it differs from time complexity, and common mistakes to avoid when analyzing algorithms.

## End
Conclusion of the course, summarizing the different complexities and their importance in writing efficient algorithms.

## Video

* [Big O Notation - Full Course](https://www.youtube.com/watch?v=Mo4vesaut8g)
	> [<img src="https://img.youtube.com/vi/Mo4vesaut8g/0.jpg" width="200">](https://www.youtube.com/watch?v=Mo4vesaut8g "This course will teach you how to understand and apply the concepts of Big O Notation to Software Engineering. Big-O notation is a way to describe how long an algorithm takes to run or how much memory is used by an algorithm. by freeCodeCamp.org 553K views 1 hour, 56 minutes")
