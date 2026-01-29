package array.medium;

import java.util.Arrays;

/*
 * @author Ripan Baidya
 * @date 29/01/26
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to
 * the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {

    /* ---------------- Brute Force  ---------------- */

    /*
     * The brute force approach is to calculate the product of all elements in the array
     * except the one at the current index. We can achieve this by iterating over each
     * element and using an inner loop to calculate the product of all elements except the
     * current one.
     *
     * Time Complexity: O(n^2) because for each element
     * Space Complexity: O(1) except for the output array
     */
    public int[] productExceptSelfBruteForce(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            // Initialize each element as 1 for multiplication
            output[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    output[i] *= nums[j];
                }
            }
        }

        return output;
    }

    /* ---------------- Better: Prefix & Suffix Array ---------------- */

    /*
     * Use two auxiliary arrays (`prefix` and `suffix`) to store the cumulative
     * product of elements before and after each index.
     * For each position `i`, the result is simply: res[i] = prefix[i] * suffix[i]
     *
     * Time Complexity: O(n)  (two passes for prefix/suffix + one pass for result)
     * Space Complexity: O(n) (extra space for prefix and suffix arrays)
     */
    public int[] productExceptSelfBetter(int[] nums) {
        int n = nums.length;

        // Arrays to store product of all elements before (prefix) and after (suffix)
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        // Build prefix product array
        // prefix[i] = product of nums[0] ... nums[i-1]
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        // Build suffix product array
        // suffix[i] = product of nums[i+1] ... nums[n-1]
        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        // Build result using prefix[i] * suffix[i]
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    /* ---------------- Optimal: Single Pass ---------------- */

    /*
     * To optimize our space usage, we can eliminate the suffix array and calculate
     * the right product on the fly while filling up the result array. Compute left
     * products into the output first, then sweep from right to left while maintaining
     * a single variable right that accumulates the product of elements to the right
     * of the current index.
     *
     * Time Complexity: O(n) because it involves two passes over the array.
     * Space Complexity: O(1) extra space apart from the output array.
     */
    public int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // First pass: Calculate products of all elements to the left of each index
        // For each position i, store the product of all elements before index i
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;       // Store product of all elements to the left
            leftProduct *= nums[i];        // Update left product for next iteration
        }

        // Second pass: Calculate products of all elements to the right of each index
        // Multiply each position by the product of all elements after index i
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;     // Multiply by product of all elements to the right
            rightProduct *= nums[i];       // Update right product for next iteration
        }

        return result;
    }

    // Main
    public static void main(String[] args) {
        var solution = new ProductOfArrayExceptSelf();

        int[] nums = {1, 2, 3, 4};

        int[] result = solution.productExceptSelfOptimal(nums);
        System.out.println(Arrays.toString(result));
    }
}
