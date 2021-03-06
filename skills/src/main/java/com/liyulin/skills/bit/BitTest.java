package com.liyulin.skills.bit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lixianchun
 * @Date: 2019/5/19 21:13
 * @Description:
 */
public class BitTest {

    /**
     * 第一条：利用位运算判断一个整数是奇数还是偶数。
     * 经常用到一个for循环，当索引i是奇数时执行语句A，偶数时执行语句B。判断i是奇数还是偶数，可用如下方法：
     * if(i &1){
     * //i是奇数情况执行的代码
     * }
     * else{
     * //i是偶数情况执行的代码
     * }
     * 位运算的优先级最低，但是运算速度却最快，所以用i&1判断奇偶，要比用i%2==1来判断大约快4倍。在一个要执行上万次的for循环里，能明显提升判断效率。
     *
     *
     *
     * 第二条：利用位运算，取一个除数是2的正整数次方数的余数。
     * 有时候要做一些取余（模）的运算，而除数恰好是2的次方数常量（因为做程序时，经常会把一些会重复运算的关键数值取成2、4、8等），可用如下方法：
     * 取i除以4的余数，用：num=i&3
     * 取i除以8的余数，用：num=i&7
     * 取i除以16的余数，用：num=i&15
     * 。。。。。。
     * 依次类推
     * HashMap 默认容量便是2的4次幂
     *
     *
     *
     *
     *
     * 第三条：利用位运算，实现对一个数字做除法后再取整（除数是2的正整数次方数）。
     * 这个可能更常用,有时候算坐标，有时候算索引之类，方法如下：
     * 比如，把number除以4的结果取整，一般写成int(number/4)
     * 用位运算，写成number>>2即可.
     * 运算效率会高得多哦！
     *
     * 第四条，乘以2的幂次方，直接左移<<
     *
     */

    @Test
    public void test(){

        Map map = new HashMap(3);
        map.put("1","2");
        map.put("1333","2");
    }

    /**
     * 求2进制1的个数
     *
     * 做oj遇到一道题，求二进制中1的个数。发现有大佬用来(n&n-1)。觉得很神奇。有空下来细想。确实是这么个道理。记录一下自己的分析过程
     * 一、n-1发生了什么
     * ①、二进制数n，n-1后，如果最后一位是0，将向前一位借2，2-1=1。最后一位为1。如果前一位为0，将继续向前一位借2，加上本身少掉的1.则变为1。一直遇到1。减为0.
     * 所以 二进制 xxxx10000-1 = xxxx01111
     *
     * ②、n&n-1
     * 按照上述 n=xxxx10000，n-1=xxxx01111
     * xxxx10000
     * xxxx01111
     * xxxx0000
     *
     * 可以看到将原来的最右边的1变为0了。
     * 重复操作，有多少个1，这个操作就可以执行多少次。
     *
     判断一个数是否是2的方幂
     n > 0 && ((n & (n - 1)) == 0 )
     解释((n & (n-1)) == 0)：
     如果A&B==0，表示A与B的二进制形式没有在同一个位置都为1的时候。
     那么本题到底啥意思？？
     不妨先看下n-1是什么意思。
     令:n=1101011000(二进制,十进制也一样)，则
     n-1=1101010111。
     n&(n-1)=1101010000
     由此可以得出，n和n-1的低位不一样，直到有个转折点，就是借位的那个点，从这个点开始的高位，n和n-1都一样，如果高位一样这就造成一个问题，就是n和n-1在相同的位上可能会有同一个1，从而使((n & (n-1)) != 0),如果想要
     ((n & (n-1)) == 0)，则高位必须全为0，这样就没有相同的1。
     所以n是2的幂或0
     * */
    @Test
    public void testBinary1Number(){
        int n = 0, count = 0;
        while(n > 0){
            count++;
            n&=(n-1);
        }
    }

}
