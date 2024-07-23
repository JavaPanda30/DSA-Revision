class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, numRows, new ArrayList<>());
        return ans;
    }

    public void helper(List<List<Integer>> ans, int num, List<Integer> curr) {
        if (num == 0) {
            return;
        }
        curr.add(0, 1);
        for (int j = 1; j < curr.size() - 1; j++) {
            curr.set(j, curr.get(j) + curr.get(j + 1));
        }
        ans.add(new ArrayList<Integer>(curr));
        helper(ans, num - 1, curr);
    }
}
