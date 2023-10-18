package broken.line.kite.rookie.class06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wanjia1
 * @date: 2023/10/17
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
 */
public class PreOrderInOrderConstructBinaryTree {

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        // 使用空间换时间 构建max
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeNode2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indexMap);
    }

    private TreeNode buildTreeNode2(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2, Map<Integer, Integer> indexMap) {
        // 对于 [1,2,3构建的数组 它将产生该问题]
        if (L1 > R1) {
            return null;
        }
        int headValue = preorder[L1];
        TreeNode headNode = new TreeNode(headValue);
        // 如果当只剩一个节点 我们则认为 可以返回 它不需要进行进一步的递归
        if (L1 == R1) {
            return headNode;
        }
        int findIndex = indexMap.get(headValue);
        // 使用递归 构建
        headNode.left = buildTreeNode2(preorder, L1 + 1, findIndex - L2 + L1, inorder, L2, findIndex - 1, indexMap);
        headNode.right = buildTreeNode2(preorder, findIndex - L2 + L1 + 1, R1, inorder, findIndex + 1, R2, indexMap);
        return headNode;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
//        return buildTreeNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return buildTreeNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int[] preorder, int L1, int R1, int[] inorder, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        int headValue = preorder[L1];
        TreeNode headNode = new TreeNode(headValue);
        if (L1 == R1) {
            return headNode;
        }
        int findIndex = 0;
        for (int i = L2; i <= R2; i++) {
            if (headValue == inorder[i]) {
                findIndex = i;
                break;
            }
        }
        // 使用递归 构建
        headNode.left = buildTreeNode(preorder, L1 + 1, findIndex - L2 + L1, inorder, L2, findIndex - 1);
        headNode.right = buildTreeNode(preorder, findIndex - L2 + L1 + 1, R1, inorder, findIndex + 1, R2);
        return headNode;
    }

    public static class TreeNode {
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
}
