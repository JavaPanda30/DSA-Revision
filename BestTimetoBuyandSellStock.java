class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i:prices){
            min = Math.min(min,i);
            max = Math.max(i-min,max);
        }
        return max;
    }
}
