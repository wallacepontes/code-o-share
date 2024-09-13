function canConstruct(target, wordBank, memo = {}) {
    // Check if the result is already in the memo
    if (target in memo) return memo[target];
    if (target === '') return true;
  
    for (let word of wordBank) {
      if (target.indexOf(word) === 0) {
        const suffix = target.slice(word.length); // Remove the prefix
        if (canConstruct(suffix, wordBank, memo)) {
          memo[target] = true; // Memoize the result
          return true;
        }
      }
    }
  
    memo[target] = false; // Memoize the result
    return false;
  }
  
  console.log(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // true
  console.log(canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // false
  console.log(canConstruct("", ["cat", "dog", "mouse"])); // true
  console.log(canConstruct("enterapotentpot", ["a","p","ent", "enter", "ot", "o", "t"])); //true
  console.log(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    "e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee"
  ])); // false