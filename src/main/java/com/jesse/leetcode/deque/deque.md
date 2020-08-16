
# 队列
首先像小学生站成一列一样，先进去的就是队头，也就是First，队尾就是Last

这里需要记住，所有使用到Queue或者Deque的都要用offer，也就是正常的列这样去插入

offer代表addLast（记住不要使用push，因为push代表的是addFirst,和我们做题的初衷一般都不一样）

或者可以干脆所有关系到队列的题目都用deque = new LinkedList<>();