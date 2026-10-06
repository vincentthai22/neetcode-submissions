class WordDictionary {
    private val root = TrieNode()
    private class TrieNode {
          val children = HashMap<Char, TrieNode>()
          var isWord = false
      }

      fun addWord(word: String) {
          var node = root
          for (c in word) {
              node = node.children.getOrPut(c) { TrieNode() }
          }
          node.isWord = true
      }
  
      fun search(word: String): Boolean = search(word, 0, root)

      private fun search(word: String, i: Int, node: TrieNode): Boolean {
          if (i == word.length) return node.isWord          // consumed whole word
          val c = word[i]
          return if (c == '.') {
              // wildcard: succeed if ANY child leads to a match
              node.children.values.any { search(word, i + 1, it) }
          } else {
              val next = node.children[c] ?: return false    // dead end
              search(word, i + 1, next)
          }
      }
}
