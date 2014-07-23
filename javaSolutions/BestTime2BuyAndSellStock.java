/*
   Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.


For example, [3, 2, 6, 5, 0, 3], you should buy at day 1 on price 2, and sell at day 2 on price 6, to get the maximum profit of 6 - 2= 4.
*/

public class BestTime2BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if(days < 2) {
            return 0;
        }
        
        int profit = 0;
        int price = 0;
        for(int day = 1; day < days; day++) {
            while(day < days && prices[day] - prices[day - 1] <= 0) {
                day++;
            }
            if(day == days) {
                break;
            } else {
                price = prices[day];
                for(int m = day + 1; m < days; m++) {
                    if(prices[m] > price) {
                        price = prices[m];
                    }
                }
                profit = (price - prices[day - 1]) > profit ? (price - prices[day - 1]) : profit;
            }
        }
        
        return profit;
    }
} 
