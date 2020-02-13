package com.sethay.interviewcamp.solutions.week1.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//Problem: Two Sum
//Given an array of integers, find a pair of integers that sums to a number Target.
// For e.g, if A = [6,3,5,2,1,7]. Target = 4, Result= [3,1]
// Questions to Clarify:
// Q. How do you want the output?A. Return a pair of numbers.
// Q. What if there are multiple pairs that sum to Target?A. Return any pair.
// Q. What to return if there are no pairs that sum to Target?A. Return null.

public class Question1 {
    public static void main(String[] args){
        int[] arr=new int[]{5,2,1,4,5,7};
        int target=10;
        int[] sol=findPair1(arr,target);
        if(Objects.nonNull(sol)) {
            for (int i = 0; i < sol.length; i++) {
                System.out.print(sol[i]);
            }
        }
        int[] sol1=findPair3(arr,target);
        if(Objects.nonNull(sol1)) {
            for (int i = 0; i < sol1.length; i++) {
                System.out.print(sol1[i]);
            }
        }
    }
    //First Approach
    //Iterating and searching in array if the target is present or not
    //Time Complexity: O(n2)
    //Space Complexity: O(1)
    static int[] findPair1(int[] arr,int target){
        if(arr==null){
            return null;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>target){
             //doNothing
            }else if(arr[i]<=target && findInArray(arr,target-arr[i],i)){
                return new int[]{arr[i],target-arr[i]};
            }
        }
        return null;
    }
    //Linear Search of Array to find if an Element is present or not.
    static boolean findInArray(int[] arr, int val,int pos) {
        for(int j=0;j<arr.length;j++){
            if(arr[j]==val && pos!=j){
                return true;
            }
        }
    return false;
    }


    //Approach 2: Sort the Array and do binary search instead of linear search
    //Time Complexity: O(n*log(n))
    //Space Complexity: O(n)
    //Not implementing as it same as above.


    //Approach 3: Use HashMap
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    static int[] findPair3(int[] arr,int target){
        if(arr==null){
            return null;
        }
        //Putting the Values of Arrays as key of the HashMap and value as frequency of it.
        Map<Integer,Integer> arrayMap=new HashMap<>();
        for(int j=0;j<arr.length;j++){
            if(arrayMap.containsKey(arr[j])){
                arrayMap.put(arr[j],arrayMap.get(arr[j])+1);
            }else {
                arrayMap.put(arr[j],1);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>target){
                //doNothing
            }else if(arr[i]<=target && arrayMap.containsKey(target-arr[i])){
                if(arr[i]==target-arr[i]){
                    if(arrayMap.get(arr[i])>=2){
                        return new int[]{arr[i],target-arr[i]};
                    }
                }else {
                    return new int[]{arr[i],target-arr[i]};
                }
            }
        }
        return null;
    }


}
