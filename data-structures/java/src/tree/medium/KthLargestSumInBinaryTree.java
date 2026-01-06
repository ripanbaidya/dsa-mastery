package tree.medium;

import tree.repr.BinaryTreeBuilder;
import tree.repr.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * You are given the root of a binary tree and a positive integer k.
 * The level sum in the tree is the sum of the values of the nodes that are on the same
 * level.
 * Return the kth largest level sum in the tree (not necessarily distinct).If there are
 * fewer than k levels in the tree, return -1.
 * Note that two nodes are on the same level if they have the same distance from the root
 *
 * Example:
 *
 * Input: root = [5,8,9,2,1,3,7,4,6], k = 2
 * Output: 13
 * Explanation: The level sums are the following:
 * - Level 1: 5.
 * - Level 2: 8 + 9 = 17.
 * - Level 3: 2 + 1 + 3 + 7 = 13.
 * - Level 4: 4 + 6 = 10.
 * The 2nd largest level sum is 13.
 *
 * @author Ripan Baidya
 * @date 07/01/26
 */
public class KthLargestSumInBinaryTree {

    /**
     * Calculating the sum of each level using level order traversal & storing them in a
     * min-heap of size k & finally returning the top element of the heap.
     * Note: If there are fewer than k levels in the tree, return -1.
     * <p>
     * Time Complexity: O(n log k), where n is the number of nodes in the tree & k is the
     * number of levels in the tree.
     * <p>Space Complexity: O(n)
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        // total number of levels
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Min-heap to find k'th largest level sum
        PriorityQueue<Long> minheap = new PriorityQueue<>();

        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            long currSum = 0;

            // Update the level
            level++;

            // Calculate the sum of the current level
            for (int i = 0; i < size; i++) {
                TreeNode currNode = q.poll();
                currSum += currNode.val;

                // Add Left & right children if not null
                if (currNode.left != null) q.offer(currNode.left);
                if (currNode.right != null) q.offer(currNode.right);
            }

            // Add the current level sum to the min-heap & remove element from the heap if it
            // exceeds the size of k
            minheap.offer(currSum);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        // Edge case: Fewer than k levels in the tree
        if (level < k) return -1;

        // Note: At this point, the min-heap will have k elements & the top element will be
        // the k'th largest level sum
        return minheap.poll();
    }

    // Main
    public static void main(String[] args) {
        var ref = new KthLargestSumInBinaryTree();

        String data = "[5,8,9,2,1,3,7,4,6]";
        int k = 2;
        TreeNode root = BinaryTreeBuilder.buildTree(data);

        long res = ref.kthLargestLevelSum(root, k);
        System.out.println(res); // 13
    }
}
