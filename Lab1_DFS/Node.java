 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1_DFS;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int i,j;
    Integer ID;
    Integer[][] state = new Integer[3][3];
    List<Node> ReachableNodes = new ArrayList<>();
    String path = "";
    Integer cost = 0;
    
    
    

    public Node(Integer ID,int i,int j,Integer[][] state,String path,Integer cost){
        this.ID = ID;
        this.i = i;
        this.j = j;
        this.state = state;
        this.cost = cost;
        this.path = path;
        
    }    
    //------------------------------------------
    	private void getRightRNode() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i, j1 = j + 1;
		Integer IDTemp;
		if(j + 1 < 3)
		{
			IDTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(IDTemp, i1, j1, stateTemp, path+" Right", cost+1);
			ReachableNodes.add(tempNode);
		}
		
	}



	private void getLeftRNode() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i, j1 = j - 1;
		Integer IDTemp;
		if(j - 1 >= 0)
		{
			IDTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(IDTemp, i1, j1, stateTemp, path+" Left", cost+1);
			ReachableNodes.add(tempNode);
		}
		
	}



	private void getBottomRNode() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i + 1, j1 = j;
		Integer IDTemp;
		if(i + 1 < 3)
		{
			IDTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(IDTemp, i1, j1, stateTemp, path+" Bottom", cost+1);
			ReachableNodes.add(tempNode);
		}
		
	}



	private void getTopRNode() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i - 1, j1 = j;
		Integer IDTemp;
		if(i - 1 >= 0)
		{
			IDTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(IDTemp, i1, j1, stateTemp, path+" Top", cost+1);
			ReachableNodes.add(tempNode);
		}
		
		
		
	}
        //------------------------------
        
    public Node() {
        super();
	}
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }


    public List<Node> getReachableNodes() {
            getRightRNode();
            getLeftRNode();
            getBottomRNode();
            getTopRNode();
            
            
            
            return ReachableNodes;
    }

    public void setReachableNodes(List<Node> ReachableNodes) {
        this.ReachableNodes = ReachableNodes;
    }

    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Integer[][] getState() {
        return state;
    }

    public void setState(Integer[][] state) {
        this.state = state;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
}
