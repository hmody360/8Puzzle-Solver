/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1_BFS_New;

/**
 *
 * @author o1000
 */
public class Node {

    int id;
    int[][] state;
    String path;
    int cost;

    public Node() {
        this.id = 0;
        this.state = new int[3][3];
        this.path = "";
        this.cost = 0;
    }

    public Node(int id, int[][] state, String path, int cost) {
        this.id = id;
        this.state = state;
        this.path = path;
        this.cost = cost;
    }
}
