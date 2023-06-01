package Lab2_h3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;



public class H3 {

    private int index_i = 0;
    private int index_j = 0;
 public final PriorityQueue<Node> Q = new PriorityQueue<Node>(100, new Comparator<Node>() {
    @Override
    public int compare(Node n1, Node n2) {
      return n1.getH() - n2.getH();
    }
  });

    ArrayList<int[][]> visited = new ArrayList();

    int[][] goal
            = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 0}};

    int[][] root
            = {{4, 1, 3},
            {5, 7, 2},
            {8, 0, 6}};

    enum path {
        top, right, bottom, left
    }

    public int get_i() {
        return index_i;
    }

    public int get_j() {
        return index_j;
    }

    public void set_i(int i) {
        this.index_i = i;
    }

    public void set_j(int j) {
        this.index_j = j;
    }
    public static int getHeuristic(int[][] array) {
    int heuristic = 0;
    int indexCounter = 0; 

    for(int i = 0; i < 3; i++) {
        for(int j = 0;j<3;j++)
      if (array[i][j] != 0){
        heuristic += getManhattanDistance(indexCounter, array[i][j]);
        indexCounter++;
      }else{
          indexCounter++;
      }
    }
    return heuristic;
  }
     public static int getManhattanDistance(int index, int number) {
    return Math.abs((index / 3) - ((number-1) / 3)) + Math.abs((index % 3) - ((number-1) % 3));
  }

    

    public void Movment(int[][] a, Node parent) {
        if (index_i == 0 && index_j == 0) {
             int[][] bottom = creatState(a);
            swap(bottom, index_i + 1, index_j);
            Node n1 = new Node(1, bottom, parent.path + " " + path.bottom.toString(), parent.cost + 1,getHeuristic(bottom));
            if (!isVisited(n1.state)) {
                Q.add(n1);
            }
            int[][] right = creatState(a);
            swap(right, index_i, index_j + 1);
            Node n = new Node(2, right, parent.path + " " + path.right.toString(), parent.cost + 1,getHeuristic(right));
            if (!isVisited(n.state)) {
                Q.add(n);
            }
           
        }
        if (index_i == 0 && index_j == 1) {
            int[][] left = creatState(a);
            swap(left, index_i, index_j - 1);
            Node n2 = new Node(3, left, parent.path + " " + path.left.toString(), parent.cost + 1,getHeuristic(left));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }
            int[][] bottom = creatState(a);
            swap(bottom, index_i + 1, index_j);
            Node n1 = new Node(5, bottom, parent.path + " " + path.bottom.toString(), parent.cost + 1,getHeuristic(bottom));
            if (!isVisited(n1.state)) {
                Q.add(n1);
            }
            int[][] right = creatState(a);
            swap(right, index_i, index_j + 1);
            Node n = new Node(6, right, parent.path + " " + path.right.toString(), parent.cost + 1,getHeuristic(right));
            if (!isVisited(n.state)) {
                Q.add(n);
            }
        }
        if (index_i == 0 && index_j == 2) {
            int[][] left = creatState(a);
            swap(left, index_i, index_j - 1);
            Node n2 = new Node(6, left, parent.path + " " + path.left.toString(), parent.cost + 1,getHeuristic(left));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }
            int[][] bottom = creatState(a);
            swap(bottom, index_i + 1, index_j);
            Node n1 = new Node(7, bottom, parent.path + " " + path.bottom.toString(), parent.cost + 1,getHeuristic(bottom));
            if (!isVisited(n1.state)) {
                Q.add(n1);
            }

        }
        if (index_i == 1 && index_j == 0) {
             int[][] top = creatState(a);
            swap(top, index_i - 1, index_j);
            Node n2 = new Node(8, top, parent.path + " " + path.top.toString(), parent.cost + 1,getHeuristic(top));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }
            
            int[][] bottom = creatState(a);
            swap(bottom, index_i + 1, index_j);
            Node n1 = new Node(9, bottom, parent.path + " " + path.bottom.toString(), parent.cost + 1,getHeuristic(bottom));
            if (!isVisited(n1.state)) {
                Q.add(n1);
            }
            
            int[][] right = creatState(a);
            swap(right, index_i, index_j + 1);
            Node n = new Node(10, right, parent.path + " " + path.right.toString(), parent.cost + 1,getHeuristic(right));
            if (!isVisited(n.state)) {
                Q.add(n);
            } 
        }
        if (index_i == 1 && index_j == 1) {
              int[][] top = creatState(a);
            swap(top, index_i - 1, index_j);
            Node n2 = new Node(11, top, parent.path + " " + path.top.toString(), parent.cost + 1,getHeuristic(top));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }

            int[][] left = creatState(a);
            swap(left, index_i, index_j - 1);
            Node n3 = new Node(12, left, parent.path + " " + path.left.toString(), parent.cost + 1,getHeuristic(left));
            if (!isVisited(n3.state)) {
                Q.add(n3);
            }
             int[][] bottom = creatState(a);
            swap(bottom, index_i + 1, index_j);
            Node n1 = new Node(13, bottom, parent.path + " " + path.bottom.toString(), parent.cost + 1,getHeuristic(bottom));
            if (!isVisited(n1.state)) {
                Q.add(n1);
            }
            int[][] right = creatState(a);
            swap(right, index_i, index_j + 1);
            Node n = new Node(14, right, parent.path + " " + path.right.toString(), parent.cost + 1,getHeuristic(right));
            if (!isVisited(n.state)) {
                Q.add(n);
            }
        }
        if (index_i == 1 && index_j == 2) {
          
            int[][] top = creatState(a);
            swap(top, index_i - 1, index_j);
            Node n2 = new Node(15, top, parent.path + " " + path.top.toString(), parent.cost + 1,getHeuristic(top));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }

            int[][] left = creatState(a);
            swap(left, index_i, index_j - 1);
            Node n3 = new Node(16, left, parent.path + " " + path.left.toString(), parent.cost + 1,getHeuristic(left));
            if (!isVisited(n3.state)) {
                Q.add(n3);
            }
              int[][] bottom = creatState(a);
            swap(bottom, index_i + 1, index_j);
            Node n1 = new Node(17, bottom, parent.path + " " + path.bottom.toString(), parent.cost + 1,getHeuristic(bottom));
            if (!isVisited(n1.state)) {
                Q.add(n1);
            }
        }
        if (index_i == 2 && index_j == 0) {
              int[][] top = creatState(a);
            swap(top, index_i - 1, index_j);
            Node n2 = new Node(18, top, parent.path + " " + path.top.toString(), parent.cost + 1,getHeuristic(top));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }
            int[][] right = creatState(a);
            swap(right, index_i, index_j + 1);
            Node n = new Node(19, right, parent.path + " " + path.right.toString(), parent.cost + 1,getHeuristic(right));
            if (!isVisited(n.state)) {
                Q.add(n);
            }
        }
        if (index_i == 2 && index_j == 1) {
           
            int[][] top = creatState(a);
            swap(top, index_i - 1, index_j);
            Node n2 = new Node(20, top, parent.path + " " + path.top.toString(), parent.cost + 1,getHeuristic(top));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }

            int[][] left = creatState(a);
            swap(left, index_i, index_j - 1);
            Node n3 = new Node(21, left, parent.path + " " + path.left.toString(), parent.cost + 1,getHeuristic(left));
            if (!isVisited(n3.state)) {
                Q.add(n3);
            }
             int[][] right = creatState(a);
            swap(right, index_i, index_j + 1);
            Node n = new Node(22, right, parent.path + " " + path.right.toString(), parent.cost + 1,getHeuristic(right));
            if (!isVisited(n.state)) {
                Q.add(n);
            }
        }
        if (index_i == 2 && index_j == 2) {

            int[][] top = creatState(a);
            swap(top, index_i - 1, index_j);
            Node n2 = new Node(23, top, parent.path + " " + path.top.toString(), parent.cost + 1,getHeuristic(top));
            if (!isVisited(n2.state)) {
                Q.add(n2);
            }

            int[][] left = creatState(a);
            swap(left, index_i, index_j - 1);
            Node n3 = new Node(24, left, parent.path + " " + path.left.toString(), parent.cost + 1,getHeuristic(left));
            if (!isVisited(n3.state)) {
                Q.add(n3);
            }
        }

    }

    public void find_pos(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                if (n[i][j] == 0) {
                    set_i(i);
                    set_j(j);
                }
            }
        }
    }

    public void print(int array[][]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int[][] creatState(int[][] n) {
        int[][] state = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                state[i][j] = n[i][j];
            }
        }
        return state;
    }

    public void swap(int[][] array, int i, int j) {
        int temp = array[i][j];
        array[index_i][index_j] = temp;
        array[i][j] = 0;

    }

    public boolean isVisited(int[][] a) {

        for (int[][] v : visited) {
            if (Arrays.deepEquals(a, v)) {
                return true;
            }
        }
        return false;
    }

    public void randomizeRoot(int[][] a) {
        int index = 0;
        ArrayList<Integer> r = new ArrayList();
        for (int i = 0; i <= 8; i++) {
            r.add(i);
        }
        Collections.shuffle(r);
        while (!isSolveable(r)) {
            Collections.shuffle(r);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = r.get(index);
                index++;
            }
        }
        root = a;
    }

    public boolean isSolveable(ArrayList<Integer> a) {
        int inversions = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i) > a.get(j)) {
                    inversions++;
                }
            }
        }
        System.out.println(inversions);
        return (inversions % 2 == 0);

    }

}
