package array.medium;

/*
 * @author Ripan Baidya
 * @date 30-01-2026
 *
 * 122. Best Time to Buy and Sell Stock II
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStockII {

    /* ---------------- Optimal: Greedy ---------------- */

    /*
     * Our goal is to maximize total profit, and we are allowed to make multiple
     * transactions (buy & sell as many times as needed).
     * The Key idea is Treat every increase in price as a profit opportunity.
     * If today's price is higher than the last buy price, we sell and immediately
     * add the profit.
     * After selling, we consider today as the new buy price (we can buy again).
     * If today's price is lower, we simply update the buy price to get a better future deal.
     * In short: "Buy low, sell whenever there is profit, and repeat."
     *
     * Time Complexity: O(n) since iterating through the prices array once.
     * Space Complexity: O(1) since uses constant space.
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int lastBuyPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int todayPrice = prices[i];
            if (todayPrice > lastBuyPrice) {
                totalProfit += todayPrice - lastBuyPrice;
                // Sell today, buy again today
                lastBuyPrice = todayPrice;
            } else {
                // Better buying opportunity
                lastBuyPrice = todayPrice;
            }
        }
        return totalProfit;
    }

    // Main
    public static void main(String[] args) {
        var solution = new BestTimeToBuyAndSellStockII();

        int[] prices = {7, 1, 5, 3, 6, 4};

        int maximumProfit = solution.maxProfit(prices);
        System.out.println("Maximum profit: " + maximumProfit);
    }
}
