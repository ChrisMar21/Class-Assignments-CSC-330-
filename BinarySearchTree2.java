/**
 * Assignment 2
 * Question 2:
 * 330-01
 * @author Christopher
 * March 16th, 2017
 */
public class BinarySearchTree2{
    TreeNode root;
    
    /**
     * Insert: inserts a new node into the Binary Search Tree
     * @param n 
     */
    public void insert(TreeNode n){
        TreeNode newNode = n;
        if(root == null){
            root = n;  
        }
        else{
        TreeNode focusNode = root;
        TreeNode parent;
        while(this.root != null){
            parent = focusNode;
            if(newNode.value < focusNode.value){
                focusNode = focusNode.leftChild;
                if(focusNode == null){
                    parent.leftChild = newNode;
                    return;
                }     
            }
           else if(newNode.value > focusNode.value){
                focusNode = focusNode.rightChild;
                if(focusNode == null){
                    parent.rightChild = newNode;
                    return;
                }
            }
        }        
      }
//      
    }
    
    /**
     * PreOrderTraversal: Prints the Binary Search Tree in PreOrderTraversal
     * @param root 
     */
   
     public void PreOrderTraversal(TreeNode root){
         if(root != null){
             System.out.println(root);
             PreOrderTraversal(root.leftChild);
             PreOrderTraversal(root.rightChild);
         
         }
     }
     
     /**
      * changeColor: Changes the color of the chosen node in the tree
      * @param n 
      */
     public void changeColor(TreeNode n){
        if(n.color.equals("BLACK")){
            n.color = "RED";
        
        }
        else if(n.color.equals("RED")){
            n.color = "BLACK";
        
        }
    }
     /**
      * numOfLeftsLeftBlackNodes: Gets the number of black nodes that are on the
      * left side of left subtree
      * @param n
      * @return 
      */
    public int numOfLeftsLeftBlackNodes(TreeNode n){
        int counter = 0;
        TreeNode currentNode = n.leftChild;
        if(n == null){
            return counter;
        }
        if(n.leftChild == null){
            return counter;
        } 
        if(n.leftChild != null){
            while(currentNode != null){
                if(currentNode.color.equals("BLACK")){
                    ++counter;
                
                }
                currentNode = currentNode.leftChild;
            
            }
            return counter;
        }
        
        return counter;
    }
    
    /**
     * numOfLeftsRightBlackNodes: Gets the number of black nodes that are on the
     * right side of left subtree
     * @param n
     * @return 
     */
    public int numOfLeftsRightBlackNodes(TreeNode n){
        int counter = 0;
        TreeNode currentNode = n.leftChild;
        if(n == null){
            return counter;
        
        }
        if(n != null && n.leftChild == null){
            return counter;
        
        }
        if(n.leftChild != null && n.leftChild.color.equals("BLACK")){
               ++counter;
        if(n.leftChild.rightChild == null){
            return counter;
        
        }
       }
        else if(n.leftChild != null && n.leftChild.color.equals("BLACK")){
            ++counter;
            if(n.leftChild.rightChild != null){
                while(currentNode != null){
                if(currentNode == n.leftChild){
                    counter += 0;
                
                }
                else{
                    if(currentNode.color.equals("BLACK")){
                        ++counter;
                    
                    }
                    currentNode = currentNode.rightChild;
                    
                }  
            }
             return counter;
         }
            
                return counter;
        }
        return counter;
    }
    
    /**
     * numOfRightsLeftBlackNodes: Gets the number of black nodes on the left 
     * side of right subtree
     * @param n
     * @return 
     */
    public int numOfRightsLeftBlackNodes(TreeNode n){
        int counter = 0;
        TreeNode currentNode = n.rightChild;
        if(n == null){
            return counter;
        
        }
        if(n != null && n.rightChild == null){
            return counter;
        
        }
        if(n.rightChild != null && n.rightChild.color.equals("BLACK")){
            ++counter;
            if(n.rightChild.leftChild == null){
                return counter;
            
            }
        
        }
        else if(n.rightChild != null && n.rightChild.color.equals("BLACK")){
            ++counter;
            if(n.rightChild.leftChild != null){
                while(currentNode != null){
                    if(currentNode == n.leftChild){
                        counter += 0;
                    
                    }
                    else{
                        if(currentNode.color.equals("BLACK")){
                        ++counter;
                    
                    }
                    currentNode = currentNode.leftChild;
                    
                    }
                     
                }
                return counter;
            }
        }
        
        
        return counter;  
    }
    
    /**
     * numOfRightsRightBlackNodes: Gets the number of black nodes on the right
     * side of the right subtree
     * @param n
     * @return 
     */
    public int numOfRightsRightBlackNodes(TreeNode n){
        int counter = 0;
        TreeNode currentNode = n.rightChild;
        if(n == null){
            return counter;
        
        }
        if(n.rightChild == null){
            return counter;
        
        }
        else if(n.rightChild != null){
            while(currentNode != null){
                if(currentNode == n && currentNode.color.equals("BLACK")){
                    counter += 0;
                
                }
                if(currentNode.color.equals("BLACK")){
                    ++counter;
                
                }
                currentNode = currentNode.rightChild;
            
            }
            return counter;
            
        }
        return counter;
    }
    
    /**
     * isBlackNodeBalanced: Checks if the same amount of black nodes are 
     * the same on the left and right subtrees to deepest null pointer
     * @param n
     * @return 
     */
    public boolean isBlackNodeBalanced(TreeNode n){
         if(n == null){
             return true;
         }
         else{
             if((numOfLeftsLeftBlackNodes(n) == numOfLeftsRightBlackNodes(n)) 
               &&(numOfRightsLeftBlackNodes(n) == numOfRightsRightBlackNodes(n))
              ){
                return true; 
             
             }
         
         }
        return false;
    }
    
    public boolean hasValidNodeAttachments(TreeNode n){
        if(n == null){
            return true;
        
        }
        if(n != null && n.color.equals("BLACK")){
            if(n.leftChild == null && n.rightChild == null){
                return true;
            
            }
            if(n.leftChild == null && n.rightChild != null){
                return true;
            
            }
            if(n.leftChild != null && n.rightChild == null){
                return true;
            
            }
            return true;
         }
        
        else if(n != null && n.color.equals("RED")){
            if(n.leftChild == null && n.rightChild == null){
                return true;
            
            }
            if(n.leftChild == null && n.rightChild != null){
                if(n.rightChild.color.equals("RED")){
                    return false;
                
                }
                return true;
            }
            if(n.leftChild != null && n.rightChild == null){
                if(n.leftChild.color.equals("RED")){
                    return false;
                
                }
                return true;
            }
            if(n.leftChild.color.equals("RED") || 
               n.rightChild.color.equals("RED")){
                return false;
            
            }
            return true;
        }
           return false; 
       }
          
    /**
     * followsRule1: Checks if it follows the 1st property of Red Black Trees
     * Property 1: Each node is either red or black
     * @param n
     * @return 
     */
     public boolean followsRule1(TreeNode n){
         if(n.color.equals("BLACK") || n.color.equals("RED") 
                 && followsRule1(n.leftChild)
                 && followsRule1(n.rightChild)){
             return true;
         
         }
         
         return false;
     }
     
     /**
      * followsRule2: Checks if the tree follows the 2nd property for Red Black
      * Trees
      * Property 2: Root of the tree is black
      * @param n
      * @return 
      */
     public boolean followsRule2(TreeNode n){
         if(this.root.color.equals("BLACK")){
             return true;
         
         }
         return false;
         
     }
     
      /**
      * followsRule3: Checks if the trees follows the 3rd property of Red Black
      * Trees
      * Property 3: Red nodes don't have red children
      * @param n
      * @return 
      */
     public boolean followsRule3(TreeNode n){
         if(n == null){
             return true;
         
         }
         if(hasValidNodeAttachments(n) && 
            hasValidNodeAttachments(n.leftChild) &&
            hasValidNodeAttachments(n.rightChild)){
             return true;
         
         }
         return false;
     }
     
      /**
      * followsRule4: Checks if the tree follows the 4th property of Red Black
      * Trees
      * Property 4: Same amount of black nodes on left and right subtree
      * to the deepest null pointer
      * @param n
      * @return 
      */
     public boolean followsRule4(TreeNode n){
         if(n == null){
             return true;
         }
         else{
            if(isBlackNodeBalanced(n) && 
               isBlackNodeBalanced(n.leftChild) && 
               isBlackNodeBalanced(n.rightChild)){
                return true;
            } 
                
         }
         return false;
     }
     
     /**
      * isValidRedBlackTree: Checks if tree is a valid Red Black Tree
      * @param n
      * @return 
      */
     public boolean isValidRedBlackTree(TreeNode n){
         if(n == null){
             return true;
         }
         if(followsRule1(n) && followsRule2(n) && 
            followsRule3(n) && 
            followsRule4(n)){
             return true;
         }
               
         return false;
     }
             
    public static void main(String[] args) {
        BinarySearchTree2 tree3 = new BinarySearchTree2();
        //30(B), 20(B), 40(B), 10(R), 25(R), 50(R)
        TreeNode node1 = new TreeNode(30);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(40);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(25);
        TreeNode node6 = new TreeNode(50);
        tree3.insert(node1);
        tree3.insert(node2);
        tree3.insert(node3);
        tree3.insert(node4);
        tree3.changeColor(node4);
        tree3.changeColor(node5);
        tree3.changeColor(node6);
        tree3.insert(node5);
        tree3.insert(node6);
        
        System.out.println("Tree 3");
        System.out.println("-------");
        tree3.PreOrderTraversal(node1);
        if(tree3.isValidRedBlackTree(node1)){
            System.out.println("Tree 3 is a valid Red Black Tree.");
        
        }
        else{
            System.out.println("Tree 3 is not a valid Red Black Tree.");
        }
        System.out.println("");
        
        BinarySearchTree2 tree4 = new BinarySearchTree2();
        //30(B), 20(B), 40(B), 10(R), 25(R), 50(R), 60(R)
        TreeNode secNode1 = new TreeNode(30);
        TreeNode secNode2 = new TreeNode(20);
        TreeNode secNode3 = new TreeNode(40);
        TreeNode secNode4 = new TreeNode(10);
        TreeNode secNode5 = new TreeNode(25);
        TreeNode secNode6 = new TreeNode(50);
        TreeNode secNode7 = new TreeNode(60);
        
        System.out.println("Tree 4");
        System.out.println("-------");
        
        tree4.insert(secNode1);
        tree4.insert(secNode2);
        tree4.insert(secNode3);
        tree4.insert(secNode4);
        tree4.changeColor(secNode4);
        tree4.insert(secNode5);
        tree4.changeColor(secNode5);
        tree4.insert(secNode6);
        tree4.changeColor(secNode6);
        tree4.insert(secNode7);
        tree4.changeColor(secNode7);
        tree4.PreOrderTraversal(secNode1);
        if(tree4.isValidRedBlackTree(secNode1)){
            System.out.println("Tree 4 is a valid Red Black Tree." + 
                    "(Could not get tree to recognize red nodes w/ red children)");
        
        }
        else{
            System.out.println("Tree 4 is not a valid Red Black Tree.");
        
        }
    }
  }
    
/**
 * 
 */
class TreeNode{
    int value;
    TreeNode leftChild;
    TreeNode rightChild;
    String color = "BLACK";
    
    /**
     * 1st Constructor
     * @param data 
     */
    TreeNode(int data){
        this.value = data;
    
    }
    
    /**
     * 2nd Constructor
     * @param left
     * @param data
     * @param right 
     */
    TreeNode(TreeNode left, int data, TreeNode right){
        this.leftChild = left;
        this.value = data;
        this.rightChild = right;
    }
    
    /**
     * 
     * @return 
     */
    public String toString(){
        return this.value + " (" + this.color + ")";
    }
}