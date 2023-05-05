package broken.line.kite.tree;

import java.util.HashMap;

/**
 * @author: wanjia1
 * @date: 2023/5/5
 * 用先序数组和中序数组重建一棵树
 * Leetcode原题，https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class RebuildingTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode buildTree(int[] pre, int[] in) {
            if (pre == null || in == null || pre.length != in.length) {
                return null;
            }
            return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
        }

        private TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2) {
            if (l1 > r1) {
                return null;
            }
            TreeNode head = new TreeNode(pre[l1]);
            if (l1 == r1) {
                return head;
            }
            int find = l2;
            while (in[find] != pre[l1]) {
                find++;
            }
            // 利用先序遍历和中序遍历的特点 不断 用 左子树 和 左子树的范围 夹逼头节点
            head.left = f(pre, l1 + 1, l1 + find - l2, in, l2, find - 1);
            // 利用先序遍历和中序遍历的特点 不断 用 右子树 和 右子树的范围 夹逼头节点
            head.right = f(pre, l1 + find - l2 + 1, r1, in, find + 1, r2);
            return head;
        }
    }

    class Solution2 {
        public TreeNode buildTree(int[] pre, int[] in) {
            if (pre == null || in == null || pre.length != in.length) {
                return null;
            }
            HashMap<Integer, Integer> indexMap = new HashMap<>(in.length);
            for (int i = 0; i < in.length; i++) {
                indexMap.put(in[i], i);
            }
            return f(pre, 0, pre.length - 1, in, 0, in.length - 1, indexMap);
        }

        private TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> indexMap) {
            if (l1 > r1) {
                return null;
            }
            TreeNode head = new TreeNode(pre[l1]);
            if (l1 == r1) {
                return head;
            }
            int find = indexMap.get(pre[l1]);
            // 利用先序遍历和中序遍历的特点 不断 用 左子树 和 左子树的范围 夹逼头节点
            head.left = f(pre, l1 + 1, l1 + find - l2, in, l2, find - 1, indexMap);
            // 利用先序遍历和中序遍历的特点 不断 用 右子树 和 右子树的范围 夹逼头节点
            head.right = f(pre, l1 + find - l2 + 1, r1, in, find + 1, r2, indexMap);
            return head;
        }
    }
}
