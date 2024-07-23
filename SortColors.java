class Solution {

    public void sortColors(int[] nums) {
        //in place sorting sliding window or 2 pointer
        int one=0,two=nums.length-1,zero=0;
        while(zero<=two){
            if(nums[zero]==0){
                int t=nums[zero];
                nums[zero]=nums[one];
                nums[one]=t;
                one++;
                zero++;
            }
            else if(nums[zero]==1){
                zero++;
            }
            else{
                int t=nums[zero];
                nums[zero]=nums[two];
                nums[two]=t;
                two--;
            }
        }
    }
}
