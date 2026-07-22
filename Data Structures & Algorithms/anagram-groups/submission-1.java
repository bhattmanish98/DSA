class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Maintain a map, key is sorted string and values are list of all strings which has same
        // sorted order.
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String s_sorted = new String(c);
            List<String> group = map.getOrDefault(s_sorted, new LinkedList<>());
            group.add(s);
            map.put(s_sorted, group);
        }

        return new ArrayList<>(map.values());
    }
}
