package array.easy;

/*
 * @author Ripan Baidya
 * @date 30-07-2025
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
 * such that each unique element appears only once. The relative order of the elements should
 * be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the
 * following things:
 * => Change the array nums such that the first k elements of nums contain the unique elements
 * in the order they were present in nums initially. The remaining elements of nums are not
 * important as well as the size of nums.
 * => Return k.
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 *
 * int k = removeDuplicates(nums); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and
 * 2 respectively. It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicatesFromSortedArray {

    /* ---------------- Optimal: Two Pointer ---------------- */

    /*
     * This method uses two pointers approach to remove the duplicates from the sorted
     * array.
     * - The first pointer 'writePos' keeps track of the next position where a unique
     * element should be stored.
     * - The second pointer 'prev' keeps track of the last unique element. If the current
     * element is not equal to 'prev', it indicates that a new unique element is found.
     * The unique element is stored at the 'writePos' position and 'writePos' is incremented.
     * Finally, the 'writePos' is returned as the number of unique elements in the array.
     *
     * Time Complexity: O(n), where n is the number of elements in the array.
     * Space Complexity: O(1)
     */
    public int removeDuplicates(int[] nums) {
        int writePos = 1;
        int prev = nums[0]; // Last unique element

        for (int i = 1; i < nums.length; i++) {
            // Found a new unique element
            if (prev != nums[i]) {
                nums[writePos++] = nums[i];
                prev = nums[i];
            }
        }

        return writePos;
    }

    // Main
    public static void main(String[] args) {
        var solution = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1, 1, 2};

        int k = solution.removeDuplicates(nums);
        System.out.println("Number of unique elements: " + k);
    }
}
