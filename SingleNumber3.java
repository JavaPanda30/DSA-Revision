class Solution {
    public int[] singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i];//we are left with a^b
        }
        ans&=-ans;//isolate rightmost set bit in a^b
        int res[] = new int[2];
        //check for each bit if it is set or not 
        for(int n:nums){
            if((ans&n)==0)
            res[0]^=n;
            else
            res[1]^=n;
        }
        return res;
    }
}
