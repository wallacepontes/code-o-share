function countConstruct(target, wordBank) {
    // Base case: if the target is an empty string, return true
    if (target === '') return 1;
    
    let totalCount = 0;
    
    for (let word of wordBank) {

      // If the word matches the prefix of the target
      if (target.indexOf(word) === 0) {
        
        const suffix = target.slice(word.length); // Remove the prefix
        const numWaysForRest = countConstruct(suffix, wordBank);

        totalCount += numWaysForRest;
        
      }
    }

    return totalCount; 
  }

console.log(countConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd"])); // 1
console.log(countConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"])); // false
console.log(countConstruct("", ["cat", "dog", "mouse"])); // true
console.log(countConstruct("enterapotentpot", ["a","p","ent", "enter", "ot", "o", "t"])); //true
  /* console.log(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", [
    "e",
    "ee",
    "eee",
    "eeee",
    "eeeee",
    "eeeeee"
  ])); */  // false ... too slow