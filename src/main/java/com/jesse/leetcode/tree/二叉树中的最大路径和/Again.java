package com.jesse.leetcode.tree.二叉树中的最大路径和;

import com.jesse.leetcode.entity.TreeNode;

/**
 * 二叉树中的最大路径和
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jesse hsj
 * @date 2020/8/4 9:45
 */
public class Again {

    public static void main(String[] args) {
        Integer[] nums = {10, -9, 20, null, null, 15, 7};
        TreeNode t = TreeNode.create(nums);
        System.out.println(new Again().maxPathSum(t));
    }

    int max = Integer.MIN_VALUE;

    //dp
    public int maxPathSum(TreeNode root) {
        dp2(root);
        return max;
    }
    //树形dp首次使用
    /**
     * 定义dp为必须经过root的最大路经值 发现会导致
     *      10
     *     / \
     *   -9  20       》》》   解析为52
     *      /  \
     *    15    7
     */
    private int dp(TreeNode root) {
        if (root == null)
            return 0;
        int left = dp(root.left);
        int right = dp(root.right);
        int rootMax = root.val;
        rootMax = Integer.max(rootMax, root.val + left);
        rootMax = Integer.max(rootMax, root.val + right);
        rootMax = Integer.max(rootMax, root.val + right + left);

        max = Integer.max(rootMax, max);
        return rootMax;
    }

    /**
     * 第二次尝试树形dp
     * 定义dp为必须经过root，但root是其中的头节点 这样的最大值
     */
    private int dp2(TreeNode root) {
        if (root == null)
            return 0;
        int left = Integer.max(0, dp2(root.left));
        int right = Integer.max(0, dp2(root.right));
        int rootMax = root.val;
        rootMax = Integer.max(rootMax, root.val + Integer.max(left, right));
        rootMax = Integer.max(rootMax, root.val + right + left);

        max = Integer.max(rootMax, max);
        return root.val + Integer.max(left, right);
    }
}
