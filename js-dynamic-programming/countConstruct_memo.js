function countConstruct(target, wordBank, memo = {}) {
    // Base case: if the target is an empty string, return true
    if (target in memo) return memo[target];
    if (target === '') return 1;
    
    let totalCount = 0;
    
    for (let word of wordBank) {

      // If the word matches the prefix of the target
      if (target.indexOf(word) === 0) {
        
        const suffix = target.slice(word.length); // Remove the prefix
        const numWaysForRest = countConstruct(suffix, wordBank, memo);

        totalCount += numWaysForRest;
        
      }
    }
    memo[target] = totalCount; // Memoize the result
    return totalCount; 
  }

console.log(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // 1
console.log(countConstruct("purple", ["purp", "p", "ur", "le", "purpl"])); // 2
console.log(countConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // 
console.log(countConstruct("", ["cat", "dog", "mouse"])); // 1
console.log(countConstruct("enterapotentpot", ["a","p","ent", "enter", "ot", "o", "t"])); //4
console.log(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    "e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee", "f"
  ]));   // 207991012832