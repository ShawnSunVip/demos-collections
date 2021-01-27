package com.sun.sort;

/**
 * 插入排序
 * @author sunxiang
 * @date 2021-01-25 9:44
 **/
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,3};
        // 插入排序法
        for(int i=1;i<arr.length;i++){
            int t=arr[i];
            int f=i;
            while(f>0&&arr[f-1]>=t){
                arr[f]=arr[f-1];
                f--;
            }
            arr[f]=t;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

}
