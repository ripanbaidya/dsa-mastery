package array.easy;

/*
 * @author Ripan Baidya
 * @date 29-01-2026
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any
 * profit, return 0.
 *
 * Example :
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class BestTimeToBuyAndSellStock {

    /* ---------------- Brute Force ---------------- */

    /*
     * For each day, We are considering it as a buy day and then checking all the days after it to
     * consider them as sell days. We calculate the profit for each pair of buy and sell days
     * and keep track of the maximum profit encountered.
     * <p>
     * Time Complexity: O(n^2) where n is the number of days (length of prices array).
     * Space Complexity: O(1)
     */
    public int maxProfitBruteForce(int[] prices) {
        int maxProfit = 0;

        // Iterate through each day as buy day
        for (int i = 0; i < prices.length; i++) {
            // Iterate through each day after the buy day as sell day
            for (int j = i + 1; j < prices.length; j++) {
                // Calculate the profit by selling on the jth day after buying on ith day
                int profit = prices[j] - prices[i];

                // Update maxProfit if this profit is greater than seen before
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }

    /* ---------------- Optimal: One pass ---------------- */

    /*
     * Instead of checking all possible pairs, we can keep track of the minimum price
     * encountered so far while iterating through the prices. For each price, we calculate
     * the potential profit by subtracting the minimum price from the current price. We
     * update the maximum profit if this potential profit is greater than the previously
     * recorded maximum profit.
     *
     * Time Complexity: O(n) where n is the number of days (length of prices array).
     * Space Complexity: O(1)
     */
    public int maxProfitOptimal(int[] prices) {
        int maxProfit = 0;
        // Buy at the first day's price initially
        int minPrice = prices[0];

        for (int price : prices) {
            // Calculate the profit if sold today
            int profit = price - minPrice;

            // Update the minimum price seen so far
            minPrice = Math.min(minPrice, price);

            // Update the maximum profit found so far
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    // Main
    public static void main(String[] args) {
        var solution = new BestTimeToBuyAndSellStock();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int maxProfit = solution.maxProfitOptimal(prices);
        System.out.println("Maximum Profit: " + maxProfit);
    }
}
