package com.sunqian.algorithm;

public class UnorderedRemoveRepeat {
    /**
     * 一个无序链表，去除重复项
     */
    public static int[] before={1,2};

    public static void main(String[] args) {
        LNode head=initQueue();
        dubleCircleRemove(head);
    }

    private static LNode initQueue() {
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
        return head;
    }

    static LNode dubleCircleRemove(LNode head){
        LNode outer=head,inner=null;
        while (outer!=null ){
            LNode pre=outer;
            inner=outer.next;
            while (inner!=null){
                if(outer.data.equals(inner.data)){
                    inner=inner.next;
                    pre.next=inner;
                }else {
                    pre=inner;
                    inner=inner.next;
                }
            }
            outer=outer.next;
        }
        System.out.print("去除重复项：");
        LinkQueueReverse.printLinkedQueue(head);
        return head;
    }

}
