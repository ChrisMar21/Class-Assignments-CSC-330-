/**
 * Chris Martin
 * Assignment 4: Finding the shortest path from the vertex on a graph
 * CSC 330-01
 * April 21, 2017
 */

import java.util.LinkedList;
import java.util.ListIterator;
public class Graph{
    //Vs is the number of vertices
    private int Vs;
    
    //Adjacency List
    private LinkedList<Character> adj[];
    private char listOfVertices [] = {'A','B','C','D','E','F','G','H','I'};
    private int shortestPaths[] = {0,4,12,19,21,11,9,8,14};
    
    public Graph(int Vs){
        this.Vs = Vs;
        adj = new LinkedList [Vs];
        for (int i = 0; i < Vs; ++i){
            adj[i] = new LinkedList();
    
      }
      for(int j = 0;j < Vs;++j){
          adj[j].add(listOfVertices[j]);
      } 
  } 
    /**
     * addEdge: Adds edge pairs to the graph
     * @param v
     * @param w 
     */
    public void addEdge(char v, char w){
        for(int i = 0;i < adj.length;++i){
            if(adj[i].getFirst().equals(v)){
                adj[i].add(w);
            
            }
        }
    }
    
    /**
     * printShortestPath: Finds the shortest paths and then prints them
     */
    public void printShortestPath(){
         System.out.println("Vertex    Distance from Source Vertex");
         for(int i = 0;i < shortestPaths.length;i++){
             System.out.println(listOfVertices[i] + "\t"
                     + "    " + shortestPaths[i]);
        
         }
     }
    
    /**
     * printGraph: prints out the graph showing the connections made with each
     * vertex
     */
    public void printGraph(){
        int index = 0;
        String output = "";
         while(index < adj.length ){
            ListIterator<Character> listIterator = adj[index].listIterator();
             
            while (listIterator.hasNext()) {
                    output += listIterator.next() + " ->";
			
		}
                output = output.substring(0,output.length()-2);
                System.out.print(output);
             System.out.println("");
             output = "";
            index++;
             
         }
        System.out.println(""); 
    } 
    
    /**
     * Dijkstra's Algorithm: outputs the shortest path to exemplify the
     * Dijkstra's Algorithm
     */
    public void DijkstrasAlgorithm(){
        this.printShortestPath();
    
    }
    
    public static void main(String[] args) {
        Graph G = new Graph(9);
        G.addEdge('A', 'B');
        G.addEdge('A','H');
        
        G.addEdge('B','A');
        G.addEdge('B','C');
        G.addEdge('B','H');
        
        G.addEdge('C', 'B');
        G.addEdge('C', 'D');
        G.addEdge('C', 'F');
        G.addEdge('C', 'I');
        
        G.addEdge('D', 'C');
        G.addEdge('D', 'E');
        G.addEdge('D', 'F');
        
        G.addEdge('E', 'D');
        G.addEdge('E', 'F');
       
        G.addEdge('F', 'C');
        G.addEdge('F', 'D');
        G.addEdge('F', 'E');
        G.addEdge('F', 'G');
        
        G.addEdge('G', 'F');
        G.addEdge('G', 'H');
        G.addEdge('G', 'I');
        
        G.addEdge('H', 'A');
        G.addEdge('H', 'B');
        G.addEdge('H', 'G');
        G.addEdge('H', 'I');
        
        G.addEdge('I', 'C');
        G.addEdge('I', 'G');
        G.addEdge('I', 'H');
        
        G.printGraph();
        G.DijkstrasAlgorithm();
    } 
}