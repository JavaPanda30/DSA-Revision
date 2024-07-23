// DP
*******************************************************************************
  
class Solution {
    int max = 0;

    public int maxTurbulenceSize(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        helper(nums, 1, 0, true, 0);
        helper(nums, 1, 0, false, 0);
        return max;
    }

    public int helper(int nums[], int n, int p, boolean incr, int count) {
        max = Math.max(max, count);
        if (n == nums.length) {
            return 0;
        }
        if (incr && nums[n] > nums[p]) {
            return helper(nums, n + 1, n, !incr, count + 1);
        }
        if (!incr && nums[n] < nums[p]) {
            return helper(nums, n + 1, n, !incr, count + 1);
        } else {
            if (nums[n] == nums[p]) {
                return helper(nums, n + 1, n, incr, 1);
            } else {
                return helper(nums, n + 1, n, incr, 2);
            }
        }
    }
}


// Sliding Window
*********************************************************************************
  class Solution {

    public int maxTurbulenceSize(int[] arr) {
        int N = arr.length;
        int ans = 1;
        int brkp = 0;
        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(arr[i - 1], arr[i]);
            if (c == 0) {
                brkp = i;
            } else if (i == N - 1 || c * Integer.compare(arr[i], arr[i + 1]) != -1) {
                ans = Math.max(ans, i - brkp + 1);
                brkp = i;
            }
        }

        return ans;
    }
}

  
