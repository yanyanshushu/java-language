package com.sunqian.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums={1,2,3,5,7,9,10,12,15,18,21,41,51,61,77,85,92,95};
        binarySearch(10,nums);
    }

    /**
     * 输入一个数，和一个数组，按二分查找，找到这个数所在的数组下标。
     * 数组必须有序！
     * @param toSearchNum 要查找的数字
     * @param nums 排序好的数组
     */
    public static void binarySearch(int toSearchNum,int[] nums){
        int low=0;
        int high=nums.length-1;

        while (low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<toSearchNum){
                low=mid+1;
            }else if(nums[mid]>toSearchNum){
                high=mid-1;
            }else {
//                high=high-1;
                break;//相等直接跳出
            }
        }

         System.out.println(toSearchNum+"所在的索引是："+low);

    }
}
