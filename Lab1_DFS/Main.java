
package Lab1_DFS;

import java.util.Arrays;


public class Main {
    public static void main(String[]args){
        System.out.println("Welcome to DFS 8 Puzzle Solver Program");
        System.out.println("Beginning Solving:");
        
        DFS dfsTree = new DFS("4","1","3","5","7","2","8","0","6");
        
        boolean CheckGoal = dfsTree.solve();
        
        if (CheckGoal){
            System.out.println("Stats:");
            System.out.println("The path to the goal is: " + dfsTree.getcNode().getPath());
            System.out.println("The Cost to the goal is: "+ dfsTree.getcNode().getCost());
            System.out.println("# of nodes Visited: "+dfsTree.getVisited().size());
        }
        else{
            System.err.println("No solution found in the Tree!!!");
        }
    }
}
