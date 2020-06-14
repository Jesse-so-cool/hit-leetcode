first search

继续 https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485134&idx=1&sn=fd345f8a93dc4444bcc65c57bb46fc35&chksm=9bd7f8c6aca071d04c4d383f96f2b567ad44dc3e67d1c3926ec92d6a3bcc3273de138b36a0d9&scene=126&sessionid=1591928903&key=54cb3c013a51c8b8acf89934e0bcbab5f550b277d0f86f5ed42f71f87d31365826c34976961e7fff3771fb736357561ecac8ec97432f9a6585bb6aba28be82ab64ed5c8858b64841dc0f67c780965705&ascene=1&uin=OTk4MDg3OTAw&devicetype=Windows+7+x64&version=62090070&lang=zh_CN&exportkey=Azv7XFsQPJ00R899%2FRqhzmA%3D&pass_ticket=uPyg5dqhMomiZYysz5Z6gZIm1BgZhgS5WoKp3IeDqZZYiJq9yOcZenYgGvs2Pa6x


1. 为什么 BFS 可以找到最短距离，DFS 不行吗？

    首先，你看 BFS 的逻辑，depth每增加一次，队列中的所有节点都向前迈一步，这保证了第一次到达终点的时候，走的步数是最少的。

    DFS 不能找最短路径吗？其实也是可以的，但是时间复杂度相对高很多。

    你想啊，DFS 实际上是靠递归的堆栈记录走过的路径，你要找到最短路径，肯定得把二叉树中所有树杈都探索完才能对比出最短的路径有多长对不对？

    而 BFS 借助队列做到一次一步「齐头并进」，是可以在不遍历完整棵树的条件下找到最短距离的。

    形象点说，DFS 是线，BFS 是面；DFS 是单打独斗，BFS 是集体行动。这个应该比较容易理解吧。

2. 既然 BFS 那么好，为啥 DFS 还要存在？

    BFS 可以找到最短距离，但是空间复杂度高，而 DFS 的空间复杂度较低。

    还是拿刚才我们处理二叉树问题的例子，假设给你的这个二叉树是满二叉树，节点总数为N，对于 DFS 算法来说，空间复杂度无非就是递归堆栈，最坏情况下顶多就是树的高度，也就是O(logN)。

    但是你想想 BFS 算法，队列中每次都会储存着二叉树一层的节点，这样的话最坏情况下空间复杂度应该是树的最底层节点的数量，也就是N/2，用 Big O 表示的话也就是O(N)。
    
    
> **由此观之，BFS 还是有代价的，一般来说在找最短路径的时候使用 BFS，其他时候还是 DFS 使用得多一些（主要是递归代码好写）。**