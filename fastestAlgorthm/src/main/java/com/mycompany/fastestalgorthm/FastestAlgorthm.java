/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fastestalgorthm;
import java.util.*;
/**
 *
 * @author dylancicone
 */
public class FastestAlgorthm {

    public static void main(String[] args) {
        int[] arr;
        int iterations = 10000;
        long start, end;
        
        toCSV csvConverter = new toCSV();
        String file_path = "fastestAlgorithm.csv";
        
        String[] selectionSortTimes = new String[iterations];
        selectionSortTimes[0] = "Selection Sort";
        for(int i = 1; i < iterations+1; i++){
            arr = initializeArray(iterations);
            start = startTime();
            selectionSort(arr);
            end = endTime();
            selectionSortTimes[i] = "" + returnTime(start, end);
        }
        printArray(selectionSortTimes);
        //String[] selectionSortTimesString = convertDoubleArrayToString(selectionSortTimes);
        
        String[] bubbleSortTimes = new String[iterations+1];
        bubbleSortTimes[0] = "Bubble Sort";
        for(int i = 1; i < iterations+1; i++){
            arr = initializeArray(iterations);
            start = startTime();
            bubbleSort(arr);
            end = endTime();
            bubbleSortTimes[i] = "" + returnTime(start, end);
        }
        printArray(bubbleSortTimes);
        //String[] bubbleSortTimesString = convertDoubleArrayToString(bubbleSortTimes);
        
        String[] insertionSortTimes = new String[iterations];
        insertionSortTimes[0] = "Insertion Sort";
        for(int i = 1; i < iterations+1; i++){
            arr = initializeArray(iterations);
            start = startTime();
            insertionSort(arr);
            end = endTime();
            insertionSortTimes[i] = "" + returnTime(start, end);
        }
        printArray(insertionSortTimes);
        //String[] insertionSortTimesString = convertDoubleArrayToString(insertionSortTimes);
        
        csvConverter.writeData(file_path, iterations, selectionSortTimes, bubbleSortTimes, insertionSortTimes);
    }
    
    public static int[] initializeArray(int size){
        //System.out.println("Initializing Array...");
        Random rand = new Random();
        int[] toReturn = new int[size];
        for(int i = 0; i < toReturn.length; i++){
            toReturn[i] = rand.nextInt(100);
        }
        return toReturn;
    }
    
    public static void selectionSort(int[] arr){
        //System.out.println("Selection Sort");
        for(int i = 0; i < arr.length-1; i++){
            int minIdx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
            
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void bubbleSort(int[] arr){
        //System.out.println("Bubble Sort");
        boolean swapped = false;
        for(int i = 0; i < arr.length-1; i++){
            swapped = false;
            for(int j = 0; j < arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
            
        }
    }
    
    public static void insertionSort(int[] arr){
        //System.out.println("Insertion Sort");
        for(int i = 0; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }
    
    public static long startTime(){
        return System.nanoTime();
    }
    
    public static long endTime(){
        return System.nanoTime();
    }
    
    public static void printTime(long start, long end){
        System.out.println("Runtime: " + Math.subtractExact(end, start)/1000000000.0 + "\n---------------------------------------------\n");
    }
    
    public static double returnTime(long start, long end){
        return Math.subtractExact(end, start)/1000000000.0;
    }
    
    /*public static String[] convertDoubleArrayToString(double[] arr){
        String[] toReturn = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            double curr = arr[i];
            toReturn[i] = curr + "";
        }
        return toReturn;
    }*/
    
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "\n");
    }
    
    public static void printArray(double[] arr){
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "\n");
    }
    
    public static void printArray(String[] arr){
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "\n");
    }
    
    /*public static void printArray(String name, double[] arr){
        System.out.println(name);
        for(int i = 0; i < arr.length-1; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "\n");
    }*/
}