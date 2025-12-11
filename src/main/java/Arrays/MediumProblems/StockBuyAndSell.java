package main.java.Arrays.MediumProblems;
//Problem Statement:
// You are given an array of prices where prices[i] is the price of a given stock on an ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing  a
// different day in the future to sell that stock.Return the maximum profit you can achieve
// from this transaction. If you cannot achieve any profit, return 0.
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + stockBuySell(prices));
    }

//    Time Complexity: O(n²) Because for each element,
//    we are checking every future element nested loops.
//    Space Complexity: O(1) No extra space used, only variables for storing max profit.
    public static int stockBuySell(int[] prices){
        int maxprofit=0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int profit=prices[j]-prices[i];
                maxprofit=Math.max(maxprofit,profit);
            }
        }
        return maxprofit;
    }

//    Time Complexity: O(n),This is because we are iterating through the array of prices
//    exactly once. There are no nested loops or recursive calls.
//    Space Complexity: O(1),Only two variables are used to store
//    the minimum price and maximum profit, regardless of the input size.
    public static int stockBuysSell(int[] prices){
        int maxProfit=0;
        int minProfit=prices[0];

        for (int i = 0; i < prices.length; i++) {
            int cost=prices[i]-minProfit;

            maxProfit=Math.max(maxProfit,cost);
            minProfit=Math.min(minProfit,prices[i]);
        }
        return maxProfit;
    }


}
