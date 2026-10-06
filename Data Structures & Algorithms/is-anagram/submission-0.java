class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: s.toCharArray()) {
            addOneToCharMap(map, c);
        }

        for(char c: t.toCharArray()) {
            minusOneToCharMap(map, c);
        }

        for(char key: map.keySet()) {
            if(map.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    private void addOneToCharMap(HashMap<Character, Integer> map, Character key) {
        map.put(key, getOrZero(map, key) + 1);
    }

    private void minusOneToCharMap(HashMap<Character, Integer> map, Character key) {
        map.put(key, getOrZero(map, key) - 1);
    }

    private int getOrZero(HashMap<Character, Integer> map, Character key) {
        if(map.containsKey(key)) {
            return map.get(key);
        } else {
            return 0;
        }
    }
}
