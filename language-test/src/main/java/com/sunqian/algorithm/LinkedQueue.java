package com.sunqian.algorithm;

public class LinkedQueue {
    public static void main(String[] args) {
        /*
            测试用例
            数组：{31,55,23,1,6,19,25,54,33,24,9}
            指定K:1,返回 55
            指定K:2,返回 54
            。。。。。。
            指定K:5,返回 25
            。。。。。
            指定K:11,返回 1
            从大到小排序为: 55 54 33 31 25 24 23 19 9 6 1
         */


        int[] nums={31,55,23,1,6,19,25,54,33,24,9};
        Node<Integer> head = initLinkedQueue(nums);
        findTopK(head,2);
    }

    /**
     * 冒泡排序找第K大，两层循环（外层k次，内层遍历链表）
     * @param head
     * @param k
     * @return
     */
    private static Integer findTopK(Node<Integer> head,int k){
        if(head==null){
            return null;
        }
        Integer result=Integer.MAX_VALUE;//最大的结果
        Integer thisTimeMax=0;//K次，每次的最大值
        Node<Integer> temp=head;
        for(int i=0;i<k;i++){
            while (temp.next!=null){
                if(temp.data > thisTimeMax && temp.data<result){//每次的最大值要小于上一次的结果
                    thisTimeMax=temp.data;
                }
                temp=temp.next;
            }
            result=thisTimeMax;
            temp=head;//每次遍历完链表，指针恢复到开始，单次最大恢复0
            thisTimeMax=0;
        }
        System.out.println("链表第"+k+"大的数为："+result);
        return result;
    }

    /**
     * 将数组中的整数放单入链表中
     * @param nums 要放入链表的数组
     * @return  链表头结点
     */
    private static Node initLinkedQueue(int[] nums) {
        Node head=null;
        Node pre=null;
        for(int i = 0; i< nums.length; i++){
            Node eleNode=new Node();
            eleNode.data= nums[i];
            if(i==0){
                head=eleNode;
                pre=eleNode;
            }else {
                pre.next=eleNode;
                pre=eleNode;
            }
        }
        printLinkedQueue(head,"链表初始化：");
        return head;
    }

    /**
     * 按单链表顺序打印链表中数据
     * @param head 链表头结点
     * @param tips 打印前提示
     */
    public static void printLinkedQueue(Node head,String tips){
        if(head ==null){
            return;
        }
        System.out.print(tips);
        Node cur=head;
        while (cur!=null){
            System.out.print(cur.data);
            if(cur.next!=null){
                System.out.print("->");
                cur=cur.next;
            }else {
                break;
            }
        }
        System.out.println();
    }


}

/**
 * 链表节点类
 * @param <T> 节点数据
 */
class Node<T>{
    Node next=null;
    T data=null;

    Node(){
    }

    Node(T o){
        data=o;
    }
    public void setData(T o){
        data=o;
    }
}
