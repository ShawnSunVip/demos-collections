package com.sun.sort;

/**
 * 冒泡排序
 * @author sunxiang
 * @date 2021-01-25 9:42
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,3};
        // 冒泡排序
        for(int i=0;i<arr.length-1;i++)
            for(int j=0;j<arr.length-i-1;j++)
                if(arr[j]>arr[j+1]){
                    arr[j]=arr[j]+arr[j+1];
                    arr[j+1]=arr[j]-arr[j+1];
                    arr[j]=arr[j]-arr[j+1];
                }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
