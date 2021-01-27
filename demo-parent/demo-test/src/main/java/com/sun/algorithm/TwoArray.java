package com.sun.algorithm;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author sunxiang
 * @date 2021-01-27 16:27
 **/
public class TwoArray {

    public static void main(String[] args) {

    }

    public static boolean Find(int target, int [][] array) {
        int row =array.length-1;
        int cloum =0;
        while (row>=0 && cloum<array[0].length){
            if(array[row][cloum]>target){
                row--;
            }else if(array[row][cloum]<target){
                cloum++;
            }else{
                return true;
            }
        }
        return false;
    }
}
