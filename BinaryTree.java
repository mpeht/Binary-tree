/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.Scanner;

/**
 *
 * @author mpeht
 */
public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        JavaTree tree = new JavaTree();
        int op, num;

        do {
            System.out.println("Enter you option: \n"
                    + "1 - Insert number in the tree; \n"
                    + "2 - Delete number in the tree; \n"
                    + "3 - Search number in the tree; \n"
                    + "4 - Show the tree; \n"
                    + "5 - Exit. \n");
            op = in.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Input the number: ");
                    num = in.nextInt();
                    tree.add(num);
                    break;
                case 2:
                    System.out.print("Input the number to delete: ");
                    num = in.nextInt();
                    if (!tree.remove(num)) {
                        System.out.println("Value " + num + " dont macthed.");
                    }
                    break;
                case 3:
                    System.out.print("Input the number to search: ");
                    num = in.nextInt();
                    if (tree.search(num) != null) {
                        System.out.print("\n Value Matched");
                    } else {
                        System.out.print("\n Value don't matched");
                    }
                    break;
                case 4:
                    tree.walkThePath();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (op >= 1 && op <= 5);
    }
}
