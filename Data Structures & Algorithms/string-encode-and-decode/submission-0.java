class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Format: [length] + [delimiter] + [string]
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
        }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // 1. Find the next delimiter
            int pivot = s.indexOf('#', i);
            
            // 2. Extract the length and move pointer
            int length = Integer.parseInt(s.substring(i, pivot));
            i = pivot + 1;
            
            // 3. Extract the string based on the length
            res.add(s.substring(i, i + length));
            
            // 4. Move pointer to the start of the next length prefix
            i += length;
        }
        return res;
    }
}
