package com.nowcoder.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */

/**变态跳台阶
 *     public static int JumpFloorII(int target) {
 *         if(target==1){
 *             return 1;
 *         }else{
 *             return (int)Math.pow(2,target-1);
 *         }
 *     }
 */
public class JumpFloor {
    public  int JumpFloor(int target) {
        int a = 1, b = 2, c = 0;
        int result = 0;
        for (int i = 1; i <= target; i++) {
            if (i == 1) {
                result = a;
            } else if (i == 2) {
                result = b;
            } else {
                c = a + b;
                a = b;
                b = c;
                result = c;
            }
        }
        return result;
    }
}
