/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

public class BestTime2BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if(length < 2) {
            return 0;
        }
        
        int profit = 0;
        int price = 0;
        for(int day = 1; day < length; day++) {
     	    // Find the first ascending two-number sequence.
            while(day < length && (prices[day] - prices[day - 1]) <= 0) {
                day++;
            }
            
	    // If found
            if(day < length) {
		// buy the stock at Day(day - 1)
                profit -= prices[day - 1];
		// find the longest ascending sequence
                while(day + 1 < length && prices[day + 1] >= prices[day]) {
                    day++;
                }
		// sell the stock at Day(day) to get the maximum profit
                profit += prices[day];
		// find next
                day++;
            }
        }
        
        return profit;
    }
}
