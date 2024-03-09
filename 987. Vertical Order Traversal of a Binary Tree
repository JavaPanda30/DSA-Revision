/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public static class Position {
        int row;
        int col;
        int val;

        Position() {
        }

        Position(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public static class sortByCol implements Comparator<Position> {

        public int compare(Position a, Position b) {
            if (a.col == b.col) {
                if (a.row == b.row)
                    return a.val - b.val;
                else
                    return a.row - b.row;
            } else {
                return a.col - b.col;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> fin = new ArrayList<>();
        Position pos = new Position(0, 0, root.val);
        HashMap<TreeNode, Position> mp = new HashMap<>();
        TreeMap<Integer, ArrayList<Position>> ans = new TreeMap<>();
        mp.put(root, pos);
        helper(mp, root, ans);
        for (int a : ans.keySet()) {
            ArrayList<Position> positions = ans.get(a);
            Collections.sort(positions, new sortByCol());
            List<Integer> columnNodes = new ArrayList<>();
            for (Position p : positions) {
                columnNodes.add(p.val);
            }
            fin.add(columnNodes);
        }
        return fin;
    }

    public static void helper(HashMap<TreeNode, Position> mp, TreeNode root,
            TreeMap<Integer, ArrayList<Position>> ans) {
        if (root == null) {
            return;
        }
        Position pos = mp.get(root);
        int row = pos.row;
        int col = pos.col;
        if (!ans.containsKey(col)) {
            ArrayList<Position> a = new ArrayList<>();
            a.add(pos);
            ans.put(col, a);
        } else {
            ArrayList<Position> a = ans.get(col);
            a.add(pos);
            ans.put(col, a);
        }
        if (root.left != null) {
            Position temp = new Position(row + 1, col - 1, root.left.val);
            mp.put(root.left, temp);
            helper(mp, root.left, ans);
        }
        if (root.right != null) {
            Position temp = new Position(row + 1, col + 1, root.right.val);
            mp.put(root.right, temp);
            helper(mp, root.right, ans);
        }
    }
}
