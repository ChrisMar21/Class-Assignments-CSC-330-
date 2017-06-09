package SwapKeysAndValues;


import java.util.*;
import java.util.Map.*;

/**
 * @author Christopher Martin
 * 330-01
 * Question 1: Create a method that swaps keys and values in a map
 * Make sure to use exception to exclude duplicates
 * 2 - 9 - 2017
 */
public class SwitchingKeysandValues{
    public static void main(String[] args) throws Exception{
        TreeMap<String,String> treeMap1 = new TreeMap<String,String>();
        treeMap1.put("ms","Mississippi");
        treeMap1.put("nc", "North Carolina");
        treeMap1.put("ct", "Connecticut");
        System.out.println("Map 1");
        for(Map.Entry<String,String> entry: treeMap1.entrySet()){
            System.out.println("Key: " + entry.getKey() + "   " + "Value: "
            + entry.getValue());
            
         }
        
        switchKeysandValues(treeMap1);
        System.out.println("");
        TreeMap<String,String> treeMap2 = new TreeMap<String,String>();
        treeMap2.put("10123","John Adam");
        treeMap2.put("10124","John Adam");
        treeMap2.put("10345","Terry Page");
        System.out.println("Map 2");
        for(Map.Entry<String,String> entry: treeMap2.entrySet()){
            System.out.println("Key: " + entry.getKey() + "   " + "Value: "
            + entry.getValue());
            
         }
        
        switchKeysandValues(treeMap2);
            
    }
    
    /**
     * This switches the keys and values and checks for duplicates
     * @param map
     * @return 
     */
    public static TreeMap switchKeysandValues(TreeMap<String,String> map){
        System.out.println("");
        TreeMap<String,String> swappedTree = new TreeMap<String,String>();
        
        for(Map.Entry<String,String> entry: map.entrySet()){
            try{
                //Check if key already exist to check for duplicates
                if(swappedTree.containsKey(entry.getValue())){
                throw new Exception(entry.getValue());
                
            
            
            }
                else if(!swappedTree.containsKey(entry.getValue())){
                 //If key is not a duplicate then add to Map
                    swappedTree.put(entry.getValue(), entry.getKey());
                    
                    
                    
                    
                    
                }
                
            }
            catch(Exception ex){
                System.out.println(ex.getMessage() + " causes a duplicate");
                
            }
            
        }
        for(Entry<String,String> entry: swappedTree.entrySet()){
            System.out.println("Key: " + entry.getKey() + 
                    " Value: " + entry.getValue());
        
        }
               
        return swappedTree;
       
    }
}