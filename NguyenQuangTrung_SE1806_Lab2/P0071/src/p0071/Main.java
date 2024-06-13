/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0071;

/**
 *
 * @author trung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation valid = new Validation();
        TaskController control = new TaskController();
        while (true) {
            System.out.println("1. Add task");
            System.out.println("2. Del task");
            System.out.println("3. display tasks");
            System.out.println("4. Exit");
            int choice = valid.inputInteger("input your choice", 1, 4);
            switch (choice) {
                case 1:
                    control.addTask();
                    break;
                case 2:
                    control.deleteTask();
                    break;
                case 3:
                    control.displayTask();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }

}
