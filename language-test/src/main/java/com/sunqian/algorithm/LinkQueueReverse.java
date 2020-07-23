package com.sunqian.algorithm;

public class LinkQueueReverse {


    /**
     * 下边实现一个链表逆序。
     * @param args
     */
    public static void main(String[] args) {
        int length=10;
        LNode head=null;
        LNode pre=null;

        System.out.print("构造单链表：");
        for(int i=0;i<length;i++){
            LNode node=new LNode(i);
            if(i==0){
                head=node;
                pre=head;
            }else {
                pre.next=node;
                pre=node;
            }
        }
        printLinkedQueue(head);
        head=reverseLindedQueue(head);
        System.out.print("逆序单链表后：");
        printLinkedQueue(head);

    }

    public static LNode reverseLindedQueue(LNode head){
        LNode pre=null;
        LNode cur=null;
        LNode next=null;
        if(head ==null){
            return head;
        }
        pre=head;
        cur=head;
        next=cur.next;
        while (next!=null){
            cur=next;
            next=cur.next;
            cur.next=pre;
            pre=cur;
        }
        head.next=null;
        head=cur;
        return head;
    }

    public static void printLinkedQueue(LNode head){
        if(head ==null){
            return;
        }
        LNode cur=head;
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
class LNode{
    LNode next=null;
    Object data=null;

    LNode(){
    }

    LNode(Object o){
        data=o;
    }
    public void setData(Object o){
        data=o;
    }
}