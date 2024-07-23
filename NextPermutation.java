class Solution {

    public void nextPermutation(int[] nums) {
        int brkp = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                brkp = i;
                break;
            }
        }
        if (brkp == -1) {
            Arrays.sort(nums);
            return;
        }
        for (int i = nums.length - 1; i > brkp; i--) {
            if (nums[i] > nums[brkp]) {
                swap(nums, i, brkp);
                break;
            }
        }
        reverse(nums, brkp + 1);
    }

    public void swap(int a[], int l, int r) {
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
    }

    public void reverse(int arr[], int pt) {
        int c = 0, i = pt;
        while (c <(arr.length - pt)/ 2) {
            int t = arr[i];
            arr[i] = arr[arr.length - 1 - c];
            arr[arr.length - 1 - c] = t;
            i++;c++;
        }
    }
}
