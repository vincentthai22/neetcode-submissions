class PrefixTree {
    

    class TrieNode {
        private char c;
        private boolean isWord;
        private HashMap<Character, TrieNode> map = new HashMap<>(); 
        public TrieNode(char c, boolean isWord) {
            this.c = c;
            this.isWord = isWord;
        }

        public boolean isWord() { 
            return isWord;
        }

        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
        }

        public TrieNode next(Character c) {
            return map.get(c);
        }

        public TrieNode add(Character c, boolean isWord) {
            TrieNode temp = null;
            if(map.containsKey(c)) {
                temp = map.get(c);
                temp.setIsWord(isWord || temp.isWord());
                map.put(c, temp);
            } else {
                temp = new TrieNode(c, isWord);
                map.put(c, temp);
            }
            return temp;
        }

        public List<TrieNode> neighbors() {
            return new ArrayList(map.values());
        }

        public String toString() {
            return "character: " + c + " isWord: " + isWord;
        }


    }

    private HashMap<Character, TrieNode> rootNodes = new HashMap<Character, TrieNode>();

    public PrefixTree() {
         
    }

    public void insert(String word) {
        char[] cArray = word.toCharArray();
        TrieNode trav = null;

        for(int i = 0; i < cArray.length; i++) {
            char c = cArray[i];
            boolean isWord = i == cArray.length-1;
            if(trav != null) {
                trav = trav.add(c, isWord);
            } else {
                if(rootNodes.containsKey(c)) {
                    trav = rootNodes.get(c);
                } else {
                    trav = new TrieNode(c, isWord);
                    rootNodes.put(c, trav);
                }
            }
        }
    }

    public boolean search(String word) {
        TrieNode trav = null;
        for(char c: word.toCharArray()) {
            if(trav == null) {
                if(!rootNodes.containsKey(c)) return false;
                trav = rootNodes.get(c);
            } else {
                trav = trav.next(c);
            }
        }
        return trav != null ? trav.isWord : false;
    }

    public boolean startsWith(String prefix) {
        TrieNode trav = null;
        char[] array = prefix.toCharArray();
        for(int i = 0; i < array.length; i++) {
            char c = array[i];
            if(i == 0) {
                if(rootNodes.containsKey(c)) {
                    trav = rootNodes.get(c);
                    continue;
                } else {
                    return false;
                }
            }

            if(trav == null) {
                return false;
            } else {
                trav = trav.next(c);
            }
        }

    
        return trav != null;
    }

    private boolean findNextWord(TrieNode node) {
        if(node == null) {
            return false;
        }

        if(node.isWord) {
            return true;
        } else {
            for(TrieNode neighbor: node.neighbors()) {
                if(findNextWord(neighbor)) {
                    return true;
                }
            }
        }
        return false;
    }
}
