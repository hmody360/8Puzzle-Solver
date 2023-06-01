/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab2_h1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            int max = 0;
            H1 b = new H1();
            System.out.println("The Current Puzzle Is:");
            b.print(b.root);
            System.out.println("Do you Want To Change The Puzzle To a Random State ? (y/n) Or Exit(e)");
            Scanner input = new Scanner(System.in);
            char choice = input.next().toLowerCase().charAt(0);
            switch (choice) {
                case 'y':
                    b.randomizeRoot(b.root);
                    System.out.println("The New Puzzle Is:");
                    b.print(b.root);

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

                b.find_pos(b.root);
                if (Arrays.deepEquals(b.root, b.goal)) {
                    b.print(b.root);
                    System.out.println("The root IS The Answer");
                    double endtime = System.currentTimeMillis();
                    System.out.println(((endtime - starttime)) + " mili seconds");
                    System.out.println("space is: " + b.Q.size());
                } else {
                    Node rootNode = new Node();
                    b.Movment(b.root, rootNode);
                    b.visited.add(b.root);
                    System.out.println("");
                    while (!b.Q.isEmpty()) {
                        if (max < b.Q.size()) {
                            max = b.Q.size();
                        }
                        Node cNode = b.Q.poll();
                        if (!b.isVisited(cNode.state)) {
                            b.find_pos(cNode.state);
                            b.Movment(cNode.state, cNode);
                            b.visited.add(cNode.state);
                            System.out.println("the movment is: " + cNode.path);
                            b.print(cNode.state);
                        }

                        if (Arrays.deepEquals(cNode.state, b.goal)) {
                            System.out.println("\t\t\t Stats");
                            System.out.println("The final state solved state is:");
                            b.print(cNode.state);
                            System.out.println("The path to the solution is: " + cNode.path);
                            System.out.println("The cost to the path(depth) is: " + cNode.cost);
                            System.out.println("The number of total visited nodes: " + b.visited.size());
                            double endtime = System.currentTimeMillis();
                            System.out.println(((endtime - starttime)) + " milli seconds (" + (Math.round((endtime - starttime) / 1000)) + " seconds )");
                            System.out.println("space is: " + max);
                            System.out.println("===============================================================");
                            break;
                        }
                    }

                }

            }
        }
    }

}
