贪心算法可以认为是动态规划算法的一个特例，相比动态规划，使用贪心算法需要满足更多的条件（贪心选择性质），但是效率比动态规划要高。

比如说一个算法问题使用暴力解法需要指数级时间，如果能使用动态规划消除重叠子问题，就可以降到多项式级别的时间，如果满足贪心选择性质，那么可以进一步降低时间复杂度，达到线性级别的。

什么是贪心选择性质呢，简单说就是：每一步都做出一个局部最优的选择，最终的结果就是全局最优。注意哦，这是一种特殊性质，其实只有一部分问题拥有这个性质。

比如你面前放着 100 张人民币，你只能拿十张，怎么才能拿最多的面额？显然每次选择剩下钞票中面值最大的一张，最后你的选择一定是最优的。


## 区间问题
> 解决区间问题的一般思路是先排序，然后观察规律。
### 区间调度
>区间调度问题，需要按 end 排序
### 区间合并
>区间调度问题，需要按 end 排序，以便满足贪心选择性质。而对于区间合并问题，其实按 end 和 start 排序都可以，不过为了清晰起见，我们选择按 start 排序。