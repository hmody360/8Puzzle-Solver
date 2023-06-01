/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    Integer[][] initialState = new Integer[3][3];
    Node root;
    Node cNode; //Current Node
    Integer[][] goalState = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    Queue<Node> fringe = new LinkedList<Node>();
    List<Node> visited = new ArrayList<>();

    public BFS(String... state) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (state[index].equals("0")) {
                    root = new Node(0,i,j,initialState,"",0);
                }
                initialState[i][j] = Integer.parseInt(state[index++]);
            }
        }
        root.setState(initialState);
    }

    public boolean solve() 
    {
        boolean solved = false;
        fringe.add(root);
        
        while (!fringe.isEmpty())
        {
            cNode = fringe.poll();
            visited.add(cNode);
            if (goalReached()) {
                solved = true;
                printState();
                return solved;

            }
            else 
            {
                printState();
            }
            for (Node RNode : cNode.getReachableNodes()) {
                if (visited.indexOf(RNode) == -1 && fringe.contains(RNode) == false) {
                    fringe.add(RNode);
                }
            }
            cNode.setReachableNodes(null);
        }
        return solved;
    }

    private boolean goalReached() {
        boolean success = true;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!cNode.getState()[i][j].equals(goalState[i][j])) {
                    success = false;
                    break;
                }

            }
            if (success == true) {
                break;
            }

        }

        return success;
    }

    private void printState() {
        System.out.println("Current State after: " + cNode.getPath());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cNode.getState()[i][j] + "");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public Integer[][] getInitialState() {
        return initialState;
    }

    public void setInitialState(Integer[][] initialState) {
        this.initialState = initialState;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getcNode() {
        return cNode;
    }

    public void setcNode(Node cNode) {
        this.cNode = cNode;
    }

    public Integer[][] getGoalState() {
        return goalState;
    }

    public void setGoalState(Integer[][] goalState) {
        this.goalState = goalState;
    }

    public Queue<Node> getFringe() {
        return fringe;
    }

    public void setFringe(Queue<Node> fringe) {
        this.fringe = fringe;
    }

    public List<Node> getVisited() {
        return visited;
    }

    public void setVisited(List<Node> visited) {
        this.visited = visited;
    }

}
