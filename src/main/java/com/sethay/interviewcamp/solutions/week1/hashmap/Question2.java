package com.sethay.interviewcamp.solutions.week1.hashmap;

import java.util.Objects;

public class Question2 {


    //Level: Easy
    // Given an array of numbers, replace each even number with two of the same number. e.g, [1,2,5,6,8, , , ,] -> [1,2,2,5,6,6,8,8].
    // Assume that the array has the exact amount of space to accommodate the result
    public static void main(String[] args){

        int arr[] = new int[]{1,2,3,4,5,6,-1,-1,-1};

        int[] result=cloneEven(arr);
        if(Objects.nonNull(result)){
            for(int i=0;i<result.length;i++) {
                System.out.println(result[i]);
            }
        }
    }

    static int[] cloneEven(int[] arr){
        if(Objects.isNull(arr)){
            System.out.println("Array is empty");
            return null;
        }
        int i=findLastInteger(arr);
        if(i==-1){
            System.out.println("There is not enough space in array");
            return null;
        }
        int end=arr.length;
        for(;i>=0 && end>=0;i--){
            if(arr[i]%2==0){
                arr[--end]=arr[i];
                arr[--end]=arr[i];
            }else {
                arr[--end]=arr[i];
            }
        }
        return arr;
    }

    static int findLastInteger(int[] arr){
        for(int j=0;j<arr.length;j++){
            if(arr[j]==-1){
                return j-1;
            }
        }
        return -1;
    }


}

