package broken.line.kite.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 */
public class PathSumTreeTwo {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            List<Integer> path = new ArrayList<>();
            process(root, path, 0, sum, ans);
            return ans;
        }


        private void process(TreeNode root, List<Integer> path, int preSum, int sum, List<List<Integer>> ans) {
            if (root.left == null && root.right == null) {
                if (preSum + root.val == sum) {
                    path.add(root.val);
                    ans.add(copy(path));
//                    path.clear();
                    path.remove(path.size() - 1);
                }
                return;
            }
            path.add(root.val);
            preSum += root.val;
            if (root.left != null) {
                process(root.left, path, preSum, sum, ans);
            }
            if (root.right != null) {
                process(root.right, path, preSum, sum, ans);
            }
            path.remove(path.size() - 1);
        }

        private List<Integer> copy(List<Integer> path) {
            return new ArrayList<>(path);
        }
    }


}
