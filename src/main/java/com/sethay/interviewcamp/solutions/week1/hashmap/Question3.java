package com.sethay.interviewcamp.solutions.week1.hashmap;

public class Question3 {
    //Level: Easy
    // Given a sentence, reverse the words of the sentence.
    // For example,"i live in a house" becomes "house a in live i"

    public static void main(String[] args){
        String input="i live in a house";
        char[] result=reverseSentence(input);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }

    static char[] reverseSentence(String input){
        char[] arr=input.toCharArray();
        for(int i=0,end=arr.length-1;i!=end;i++,end--){
            char temp=arr[i];
            arr[i]=arr[end];
            arr[end]=temp;
        }
        for(int j=0,start=0;j<arr.length;j++){
            if(arr[j]==' '){
                reverseString(arr,start,j-1);
                start=j+1;
            }
        }
        return arr;
    }

    static void reverseString(char[] arr, int start, int end){
    for (int i = start, j = end; i <= j; i++, j--) {
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
            }
    }

}
