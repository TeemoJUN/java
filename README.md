# 这是一个个人练习的作业

## Algorithms文件夹时《算法》书上的代码练习

## Design-Patterns是收集的几种基本的设计模式


## 好好学习,加油





```java
//中序遍历非递归实现
public void iteraMidOrder(BinTreeNode<T>p){
        Stack<BinTreeNode<T>>stack = new Stack<BinTreeNode<T>>();
        BinTreeNode<T> node = p;
        while(node != null || stack.size()>0){
            while(node != null){
                stack.push(node);
                node = node.getLeftNode();
            }
            if(stack.size()>0){
                node = stack.pop();
                printInfo(node);
                node = node.getRightNode();
            }
        }
    }
    
//因为本身递归就是栈的调用,所以就可以用栈来模拟
```


+ Dequeue.java为双向对列，双链表版
+ MoveQueue.java为出列排序（基于Dequeue的）

