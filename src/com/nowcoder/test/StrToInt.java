package com.nowcoder.test;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 思路：边界判断至关重要、将字符转换成数字的方法。
 * （1）最好判断一下输入是否为空。
 * （2）如果字符串的第一个字符是‘-’号，最终得到的整数必为负整数。
 * （3）输入的字符串中不能含有不是数字的字符。
 * （4）输入的字符串不能太长，否则转换成整数后会导致整数溢出。
 */
public class StrToInt {
    public int StrToInt(String str) {
        int Max_INT = Integer.MAX_VALUE;
        int Min_INT = Integer.MIN_VALUE;
        if(str.length()==0){
            return 0;
        }
        char[] charStr = str.toCharArray();
        int n=0;
        int i=0;
        while(charStr[i]==' '){
            i++;
        }
        boolean flag=true;
        if(charStr[i]=='+' || charStr[i]=='-'){
            if(charStr[i]=='-'){
                flag=false;
            }
            i++;
        }
        for(int j=i;j<str.length();j++){
            if(!Character.isDigit(charStr[j])){
                return 0;
            }
        }
        while(i<str.length() && Character.isDigit(charStr[i])){
            int result = charStr[i]-'0';
            if(flag && (n>Max_INT/10 || (n == Max_INT/10 && result> Max_INT%10))){
                n=Max_INT;
                break;
            }
            if(!flag && (n + Min_INT/10 > 0 || (n + Min_INT/10 == 0 && result + Min_INT%10 > 0))){
                n=Min_INT;
                break;
            }
            n=n*10+result;
            i++;
        }
        return flag ? n : -n;
    }
}
/**
 * 方法二：res = (res << 1) + (res << 3) + (str[i] & 0xf);
 *        result = charStr[i]-'0';n=n*10+result;
 * str[i] & 0xf 相当于 str[i] - '0',字符'0' ~ '9' 的SACII码值的低四个二进制位就是 0 ~ 9，
 * 0xf 是数字15，二进制位1111，这样操作之后就可以将 ‘0’ 转化为0，...，将‘9’转化为‘9’
 */