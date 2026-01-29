package array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @author Ripan Baidya
 * @date 29-01-2026
 *
 * Given an array nums of size n, return the majority element. cThe majority element is the
 * element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 * always exists in the array.
 *
 * Example :
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

    /* ---------------- Better 1: HashMap ---------------- */

    /*
     * We can optimize the brute force approach by using a HashMap to store the
     * frequency of each element.
     * Traverse the array, and increment the counter for each element encountered.
     * The element with a frequency greater than n/2 will be the majority element.
     *
     * Time Complexity: O(n) because we iterate over the array once.
     * Space Complexity: O(n) because we might store all elements in the map in the worst case.
     */
    public int majorityElementBetter1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            // If an element's count exceeds n/2, return it
            if (countMap.get(num) > n / 2) {
                return num;
            }
        }

        return -1; // Shouldn't reach here if input is valid
    }

    /* ---------------- Better 2: Sorting ---------------- */

    /*
     * If we sort the array, all identical elements naturally group together.
     * Since the majority element appears more than n/2 times, it must occupy
     * the entire middle region of the sorted array.
     * That means the element at index n/2 will always be the majority element.
     *
     * Time Complexity: O(n log n) due to sorting.
     * Space Complexity: O(1) when using in-place sorting (ignoring input space).
     */
    public int majorityElementBetter2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /* ---------------- Optimal: Boyer-Moore Voting Algorithm ---------------- */

    /**
     *
     */
    public int majorityElementOptimal(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            // Increase or decrease the count based on the current number
            count += (num == candidate) ? 1 : -1;
        }

        // Count the occurrences of the candidate to confirm it's the majority element
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        return count > nums.length / 2 ? candidate : -1;
    }

    // Main
    public static void main(String[] args) {
        var solution = new MajorityElement();

        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int majorityElement = solution.majorityElementOptimal(nums);
        System.out.println("Majority element: " + majorityElement);
    }
}
