class Solution {
    class Pair {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        // Frequency map or array? array will be better when alphabets are there. Here Map is better
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i: nums) freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);

        // First K elements based of freq, Max heap (Priority Queue) is best to use
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.freq-p1.freq);
        for(int i: freqMap.keySet()) {
            pq.offer(new Pair(i, freqMap.get(i)));
        }

        int[] result = new int[k];
        int i = 0;
        while(k-->0) result[i++] = pq.poll().num;
        return result;
    }
}
