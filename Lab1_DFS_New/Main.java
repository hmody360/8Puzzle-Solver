/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1_DFS_New;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            int max = 0;
            DFS d = new DFS();
            System.out.println("The Current Puzzle Is:");
            d.print(d.root);
            System.out.println("Do you Want To Change The Puzzle To a Random State ? (y/n) Or Exit(e)");
            Scanner input = new Scanner(System.in);
            char choice = input.next().toLowerCase().charAt(0);
            switch (choice) {
                case 'y':
                    d.randomizeRoot(d.root);
                    System.out.println("The New Puzzle Is:");
                    d.print(d.root);

                case 'n':
                    break;

                case 'e':
                    System.out.println("Finishing ....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("You Must Input Yes, No Or Exit (y/n/e)");

            }

            if (choice == 'y' || choice == 'n' || choice == 'e') {
                double starttime = System.currentTimeMillis();

                d.find_pos(d.root);
                if (Arrays.deepEquals(d.root, d.goal)) {
                    d.print(d.root);
                    System.out.println("The root IS The Answer");
                    double endtime = System.currentTimeMillis();
                    System.out.println(((endtime - starttime)) + " mili seconds");
                    System.out.println("space is: " + d.S.size());
                } else {
                    Node rootNode = new Node();
                    d.Movment(d.root, rootNode);
                    d.visited.add(d.root);
                    System.out.println("");
                    while (!d.S.isEmpty()) {
                        if (max < d.S.size()) {
                            max = d.S.size();
                        }
                        Node cNode = d.S.pop();
                        if (!d.isVisited(cNode.state)) {
                            d.find_pos(cNode.state);
                            d.Movment(cNode.state, cNode);
                            d.visited.add(cNode.state);
                            System.out.println("the movment is: " + cNode.path);
                            d.print(cNode.state);
                        }

                        if (Arrays.deepEquals(cNode.state, d.goal)) {
                            System.out.println("\t\t\t Stats");
                            System.out.println("The final state solved state is:");
                            d.print(cNode.state);
                            System.out.println("The path to the solution is: " + cNode.path);
                            System.out.println("The cost to the path(depth) is: " + cNode.cost);
                            System.out.println("The number of total visited nodes: " + d.visited.size());
                            double endtime = System.currentTimeMillis();
                            System.out.println(((endtime - starttime)) + " milli seconds (" + (Math.round((endtime - starttime) / 1000)) + " seconds )");
                            System.out.println("space is: " + max);
                            System.out.println("===============================================================");
                            break;
                        }
                        if (d.visited.size() > 500){
                            System.out.println("Solution will take too long to find !!");
                            break;
                        }

                    }

                }

            }
        }
    }

}
