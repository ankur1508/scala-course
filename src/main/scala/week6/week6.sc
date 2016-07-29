import forcomp.Anagrams

Anagrams.combinations(List(('a', 2), ('b', 2)))
Anagrams.combinations(Nil)
assert(Anagrams.combinations(Nil) == List(Nil))

val charOcurrences = List(('e',1), ('i',1), ('l',2), ('n',1), ('r',1), ('u',2), ('x',1), ('z',1))
val charCombinations = Anagrams.combinations(charOcurrences)
val words = for (c <- charCombinations) yield {
  if(Anagrams.dictionaryByOccurrences.contains(c)) Anagrams.dictionaryByOccurrences(c)
  else Nil
}

def getWords(charCombinations: List[Anagrams.Occurrences]) : Anagrams.Sentence = {
  charCombinations match {
    case Nil => Nil
    case x :: xs =>  if(Anagrams.dictionaryByOccurrences.contains(x)) Anagrams.dictionaryByOccurrences(x) ::: getWords(xs) else getWords(xs)
  }
}
getWords(charCombinations)


words.filter(x => !x.isEmpty).flatMap(words => for (word <- words) yield word).toSet
//Anagrams.sentenceAnagrams(List("Linux", "rulez"))