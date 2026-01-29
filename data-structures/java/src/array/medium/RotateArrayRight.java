package array.medium;

import java.util.Arrays;

/*
 * @author Ripan Baidya
 * @date 29-01-2026
 *
 * Given an integer array nums, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 * Example:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class RotateArrayRight {

    /* ---------------- Better: Using Extra Array ---------------- */

    /*
     * To rotate the array to the right by k steps, I first take the last k elements
     * and put them at the start of a new array. Then I append the remaining elements.
     * Finally, I copy the result back to the original array.
     *
     * Time Complexity: O(n) - Each reverse operation is O(n)
     * Space Complexity: O(n) - For using an extra array
     */
    public void rotateBetter(int[] nums, int k) {
        int len = nums.length;
        int[] rotated = new int[len];

        k = k % len; // Handle cases where k >= len
        int writePos = 0;

        // Step 1: place last k elements at the front
        for (int i = len - k; i < len; i++) {
            rotated[writePos++] = nums[i];
        }
        // Step 2: place first length - k elements after that
        for (int i = 0; i < len - k; i++) {
            rotated[writePos++] = nums[i];
        }

        // Copy rotated array back to original array
        System.arraycopy(rotated, 0, nums, 0, len);
    }

    /* ---------------- Optimal: Reverse Array ---------------- */

    /*
     * The optimal solution utilizes array reversing. The underlying idea is that
     * rotating an array is equivalent to reversing parts of the array.
     *
     * Time Complexity: O(n) - Each reverse operation is O(n)
     * Space Complexity: O(1)
     */
    public void rotateOptimal(int[] nums, int k) {
        int len = nums.length;
        // Handle cases where k >= length
        k = k % len;

        // Step 1: Reverse first k elements
        reverse(nums, 0, len - k - 1);
        // Step 2: Reverse the remaining elements
        reverse(nums, len - k, len - 1);
        // Step 3: Reverse the entire array
        reverse(nums, 0, len - 1);
    }

    /**
     * Helper function to reverse array
     */
    private void reverse(int[] nums, int startPos, int endPos) {
        while (startPos <= endPos) {
            int temp = nums[startPos];
            nums[startPos] = nums[endPos];
            nums[endPos] = temp;

            startPos++;
            endPos--;
        }
    }

    // Main
    public static void main(String[] args) {
        var solution = new RotateArrayRight();

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Original array: " + Arrays.toString(nums));
        solution.rotateOptimal(nums, k);
        System.out.println("Array after k rotation to right: " + Arrays.toString(nums));
    }
}
