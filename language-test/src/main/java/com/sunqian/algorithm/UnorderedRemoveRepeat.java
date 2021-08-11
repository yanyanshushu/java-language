package com.sunqian.algorithm;

public class UnorderedRemoveRepeat {
    /**
     * 一个无序链表，去除重复项
     */
    public static int[] before={2,4,5,12,45,34,99,34,23,12,4,1};

    public static void main(String[] args) {
        LNode head=null;
        LNode pre=null;
        for(int i=0;i<before.length;i++){
            LNode eleNode=new LNode();
            eleNode.data=before[i];
            if(i==0){
                head=eleNode;
                pre=eleNode;
            }else {
                pre.next=eleNode;
                pre=eleNode;
            }
        }
        System.out.print("链表初始化：");
        LinkQueueReverse.printLinkedQueue(head);

    }

    static LNode dubleCircleRemove(LNode head){
        LNode outer=head,
                pre=head,
                inner=null;
        while (outer!=null && outer.next!=null){
            inner=outer.next;
            while (inner!=null && inner.next!=null){
                if(outer.data.equals(inner.data)){

                }
            }
            outer=outer.next;
        }
        return head;
    }

}
