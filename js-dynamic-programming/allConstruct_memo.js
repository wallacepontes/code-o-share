function allConstruct(target, wordBank, memo = {}) {
    if (target in memo) return memo[target];  // Return cached result if present
    if (target === '') return [[]];  // Base case: one way to construct the empty string
  
    const result = [];
  
    for (let word of wordBank) {
      if (target.indexOf(word) === 0) {  // If the word is a prefix
        const suffix = target.slice(word.length);
        const suffixWays = allConstruct(suffix, wordBank, memo);  // Recursive call with memo
        const targetWays = suffixWays.map(way => [word, ...way]);  // Prepend word to each way
        result.push(...targetWays);  // Add all the ways to the result
      }
    }
  
    memo[target] = result;  // Store result in memo
    return result;
  }
  
  console.log(allConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); 
  // [ [ "purp", "le" ], [ "p", "ur", "p", "le" ] ]
  
  console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd", "ef", "c"])); 
  // [ [ "ab", "cd", "ef" ], [ "ab", "c", "def" ], [ "abc", "def" ], [ "abcd", "ef" ] ]

  console.log(allConstruct([], [
    "cat",
    "dog",
    "mouse"
  ]));