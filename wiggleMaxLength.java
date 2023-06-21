package 贪心;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    /*
        分饼干
        优先考虑饼干，小饼干先喂饱小胃口
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int start = 0;
        int count = 0;
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (s[i] >= g[start]) {
                count++;
                start++;
            }
        }
        return count;
    }

    /*
        摆动序列
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curDiff = 0;
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0) && preDiff >= 0) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    /*
        最大子树组和
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count);
            if (count <= 0) {
                count = 0;
            }
        }
        return sum;
    }

    /*
        买卖股票的最佳时机II
        找区间中最小的，再找区间中最大的
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += Math.max(prices[i] - prices[i - 1], 0);
        }
        return res;
    }

    /*
        跳跃游戏
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
