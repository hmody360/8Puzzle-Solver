/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2_h3;


public class Node {

    int id;
    int[][] state;
    String path;
    int cost;
    int h;

    public Node() {
        this.id = 0;
        this.state = new int[3][3];
        this.path = "";
        this.cost = 0;
        this.h = 0;
    }

    public Node(int id, int[][] state, String path, int cost,int h) {
        this.id = id;
        this.state = state;
        this.path = path;
        this.cost = cost;
        this.h = h;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int[][] getState() {
        return state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
