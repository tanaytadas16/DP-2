class Solution {
    private Integer[][] dp;
    public int change(int amount, int[] coins) {
        dp=new Integer[coins.length][amount+1];
        int res=recursion(amount,coins,0);
        return res;
    }
    private int recursion(int amount, int[] coins, int index){
        
        //base
        if(amount==0){
            return 1;
        }
        if(amount<0 || index==coins.length) return 0;
        
        if(dp[index][amount]!=null){
            return dp[index][amount];
        }
        //select
        int select=recursion(amount-coins[index], coins, index);

        //not select
        int notSelect=recursion(amount, coins, index+1);

        dp[index][amount] = select+notSelect;

        return  dp[index][amount];
        
    }
    
}