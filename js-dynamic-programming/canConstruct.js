function canConstruct(target, wordBank) {
    // Base case: if the target is an empty string, return true
    if (target === '') return true;
  
    for (let word of wordBank) {
      // If the word matches the prefix of the target
      if (target.indexOf(word) === 0) {
        const suffix = target.slice(word.length); // Remove the prefix
        if (canConstruct(suffix, wordBank)) {
          return true; // Recursively check if the suffix can be constructed
        }
      }
    }
  
    return false; // If no prefix matches, return false
  }
  
  console.log(canConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // true
  console.log(canConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // false
  console.log(canConstruct("", ["cat", "dog", "mouse"])); // true
  console.log(canConstruct("enterapotentpot", ["a","p","ent", "enter", "ot", "o", "t"])); //true
  /* console.log(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    "e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee"
  ])); */  // false ... too slow