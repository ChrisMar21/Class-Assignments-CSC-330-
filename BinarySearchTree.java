/**
 * Creating a Binary Search Tree that prints in InOrder Traversal 
 * and PreOrder Traversal
 * @author Christopher Martin
 */

public class BinarySearchTree{
    treeNode root;
    public static void main(String[] args) {
        //50, 25, 15, 30, 75, 85
        BinarySearchTree tree = new BinarySearchTree();
        tree.addtreeNode(50);
      
        tree.addtreeNode(25);
        
        tree.addtreeNode(15);
        
        tree.addtreeNode(30);
        
        tree.addtreeNode(75);
      
        tree.addtreeNode(85);
       
        System.out.println("");
        System.out.println("Tree in PreOrder Traversal.");
        preOrderTraversal(tree.root);
        System.out.println("");
        System.out.println("Tree in InOrder Traversal.");
        inOrderTraversal(tree.root);
       
        
    }
      
    /**
     * Adds a node to tree
     * @param key 
     */
    public void addtreeNode(int key){
        treeNode newNode = new treeNode(key);
        if(root == null){
            root = newNode;
            System.out.println(root.key + " has been inserted into tree.");
        }else{
            treeNode focusNode = root;
            treeNode parent;
            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.leftChild;
                    
                    if(focusNode == null){
                        parent.leftChild = newNode;
                        System.out.println(parent.leftChild.key + " has been"
                                + " inserted into tree.");
                        return;
                     
                    }
                
                }else{
                    focusNode = focusNode.rightChild;
                    
                   if(focusNode == null){
                    parent.rightChild = newNode;
                       System.out.println(parent.rightChild.key + " has been "
                               + "inserted into tree.");
                    return;
                
                }
                
                }
                
            }
        }
    }
    
     /**
      * Puts tree into inOrderTraversal
      * @param node 
      */
    public static void inOrderTraversal(treeNode node){
        if(node != null){
        inOrderTraversal(node.leftChild);
        System.out.println(node);
        inOrderTraversal(node.rightChild);
        
        
        }
         
    }
    
    /**
     * Puts tree in preOrderTraversal
     * @param node 
     */
    
    public static void preOrderTraversal(treeNode node){
        if(node != null){
        System.out.println(node);
        inOrderTraversal(node.leftChild);
        inOrderTraversal(node.rightChild);
        
        
        }
       
    
    
    }
          
    /**
     * Creating private class for treeNodes
     */
   
    private class treeNode{
        int key;
        treeNode leftChild;
        treeNode rightChild;
        
       treeNode(treeNode leftChild,int key,treeNode rightChild){
               this.leftChild = leftChild;
               this.key = key;
               this.rightChild = rightChild;
               
        }
       treeNode(int key){
           this.key = key;
       
       }
       
        @Override
       public String toString(){
           String output = "";
           output += "Element: " + this.key;
       
           return output;
       }
       
    }
}