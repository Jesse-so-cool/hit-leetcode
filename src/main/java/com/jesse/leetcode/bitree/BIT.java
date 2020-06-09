package com.jesse.leetcode.bitree;

/**
 * @author jesse hsj
 * @date 2020/6/9
 */
public class BIT{

    private int [] Ctree;
    public BIT(int []nums){

        Ctree=new int [nums.length+1];
        for(int i=1;i< Ctree.length;i++){
            updata(i-1,nums[i-1]);
        }
        System.out.println();
    }

    /**
     * 亮点操作
     * 目的是找出最小的1在哪一位
     *
     * -i代表i的补码
     * 正数的补码等于正数的反码+1
     *
     * 例如 1100的补码等于 0011+1 = 0100
     * 1100&0100 得到了0100，肉眼可以看出1100最小的1在第三位，结果一样，得证！
     *
     * 得到0100 我们可以通过+或者-得方式，得到管理的区域
     *
     * 这里有点干：
     * update时 通过+0100的方式 得到跟1100相关的区域
     * query时，通过-0100的方式，得到下一个需要加起来的区域
     *
     * @param i
     * @return
     */
    public int lowbit(int i){
        return i&(-i);
    }
    public void updata (int i,int val){
        i+=1;
        if(i<=0||i>=Ctree.length)
            throw new IllegalArgumentException("index is illegal");

        while(i<Ctree.length){

            Ctree[i]+=val;
            i+=lowbit(i);
        }
    }

    public int query(int i){
        i+=1;
        int res=0;
        while(i>0){
            res+=Ctree[i];
            i-=lowbit(i);
        }
        return  res;
    }
}
