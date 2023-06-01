
package Lab1_BFS;

import java.util.Arrays;


public class Main {
    public static void main(String[]args){
        System.out.println("Welcome to BFS 8 Puzzle Solver Program");
        System.out.println("Beginning Solving:");
        
        BFS bfsTree = new BFS("4","1","3","5","7","2","8","0","6");
        
        boolean CheckGoal = bfsTree.solve();
        
        if (CheckGoal){
            System.out.println("Stats:");
            System.out.println("The path to the goal is: " + bfsTree.getcNode().getPath());
            System.out.println("The Cost to the goal is: "+ bfsTree.getcNode().getCost());
            System.out.println("# of nodes Visited: "+bfsTree.getVisited().size());
        }
        else{
            System.err.println("No solution found in the Tree!!!");
        }
    }
}
