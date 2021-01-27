package com.sun.sort;

/**
 * @author sunxiang
 * @date 2021-01-25 9:46
 **/
public class ChooseSort {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,3};
        // 选择排序
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min])
                    min=j;
            }
            int t=arr[min];
            arr[min]=arr[i];
            arr[i]=t;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
