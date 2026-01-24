package tree.repr;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class BinaryTreeBuilder {

    /**
     * Build binary tree from string
     *
     * @param data string representation of binary tree
     * @return root of the binary tree
     */
    public static TreeNode buildTree(String data) {
        if (data == null || data.isEmpty()) return null;

        // Remove [ ] and split
        data = data.trim();
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(",");

        if (values[0].trim().equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // Left child
            if (!values[i].trim().equals("null")) {
                current.left = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < values.length && !values[i].trim().equals("null")) {
                current.right = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }
}
