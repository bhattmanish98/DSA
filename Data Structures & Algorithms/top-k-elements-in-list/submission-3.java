class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency map or array? array will be better when alphabets are there. Here Map is better
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i: nums) freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);

        // First K elements based of freq, Max heap (Priority Queue) is best to use
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freqMap.get(a)-freqMap.get(b));
        for(int key: freqMap.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }

        int[] result = new int[k];
        int i = 0;
        while(!pq.isEmpty()) result[i++] = pq.poll();
        return result;
    }
}
