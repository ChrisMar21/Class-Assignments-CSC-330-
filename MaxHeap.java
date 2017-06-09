/**
 * CSC 330-01: Professor 
 * Assignment 3: Implement HeapSort using a MaxHeap
 * 4/8/2017
 * @author Christopher Martin
 */

import java.util.*;
public class MaxHeap{
    int size = 0;
    int index = 0;
    int capacity = 5;
    int heapArray[] = new int[capacity];
    
    /**
     * addToHeap: adds numbers to Heap
     * @param data 
     */
    public void addToHeap(int data){
        if(size == capacity){
            ++capacity;
        }
        if(heapArray == null){
            heapArray[index] = data;
            ++size;
        }
        else{
            heapArray[index++] = data;
            ++size;   
        }    
    }
    
    /**
     * sortHeap: sorts numbers in heap in greatest to least order for MaxHeap
     * @return 
     */
   public int[] sortHeap(){
       Arrays.sort(heapArray);
      int sorted[] = new int[size];
      for(int i = 0;i < size;++i){
          sorted[i] = heapArray[size - i];
      
      }
       return sorted;
   }
   
    /**
     * printHeap: outputs the array of numbers in the MaxHeap
     * @return 
     */
    public void printHeap(){
        System.out.println("Maximum Heap");
        System.out.println("--------------");
        for(int i = 0;i < sortHeap().length;i++){
            System.out.print(sortHeap()[i] + " ");
        }    
    }
    
    public static void main(String[] args) {
        MaxHeap MH = new MaxHeap();
        //Inserting: 45, 90, 85 ,62
        MH.addToHeap(45);
        MH.addToHeap(90);
        MH.addToHeap(85);
        MH.addToHeap(62); 
        MH.printHeap();            
    }
}