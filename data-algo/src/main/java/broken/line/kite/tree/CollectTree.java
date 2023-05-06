package broken.line.kite.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 二叉树按层遍历并收集节点
 * Leetcode原题，https://leetcode.com/problems/binary-tree-level-order-traversal-ii
 */
public class CollectTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> dataList = new ArrayList<>();
            if (root == null) {
                return dataList;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> curAns = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode head = queue.poll();
                    curAns.add(head.val);
                    if (head.left != null) {
                        queue.add(head.left);
                    }
                    if (head.right != null) {
                        queue.add(head.right);
                    }
                }
                dataList.add(0, curAns);
            }

            return dataList;
        }
    }

}
