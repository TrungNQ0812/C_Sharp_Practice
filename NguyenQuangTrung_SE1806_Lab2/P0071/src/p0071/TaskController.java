/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0071;

import java.util.ArrayList;

/**
 *
 * @author trung
 */
public class TaskController {

    Validation valid = new Validation();
    TaskManagement manage = new TaskManagement();

    public void addTask() {
        int id;
        if (manage.isEmptyList()) {
            id = 1;
        } else {
            id = manage.increaseLastId();
        }
        System.out.println("------------Add task-------------");
        String requirementName = valid.inputString("Requirement name: ", "[A-Za-z\\s]+");
        String taskTypeId = valid.inputType();
        String date = valid.inputDateTime("Date : ");
        double planFrom = valid.inputDouble("Plan from: ", 8, 17);
        double planTo = valid.inputDouble("Plan To: ", 8.5, 17.5);
        while (manage.checkTime(planFrom, planTo) == false) {
            System.out.println("Plan from must less than plan to!");
            planFrom = valid.inputDouble("Plan from: ", 8, 17);
            planTo = valid.inputDouble("Plan To: ", 8.5, 17.5);
        }
        String assignee = valid.inputString("Assignee: ", "[A-Za-z\\s]+");
        String reviewer = valid.inputString("Reviewer: ", "[A-Za-z\\s]+");

        while (manage.checkAssigneeReviewer(assignee, reviewer) == true) {
            System.err.println("Assignee not same reviewer");
            assignee = valid.inputString("Assignee: ", "[A-Za-z\\s]+");
            reviewer = valid.inputString("Reviewer: ", "[A-Za-z\\s]+");
        }
        if (manage.addTask(taskTypeId, requirementName, date, planFrom, planTo, assignee, date) == -1) {
            System.err.println("Duplicate task");
            return;
        } else {
            System.out.println("Task added succesfully!");
        }
    }

    public void deleteTask(){
        System.out.println("-----------delete task------------");
        int finder = valid.inputInteger("ID: ", 1, Integer.MAX_VALUE);
        Task taskDelete = manage.findById(finder);
        if(taskDelete == null){
            System.out.println("Not found");
            return;
        }
        manage.removeTask(taskDelete);
        System.out.println("Task deleted successfully!");
    }
    
    public void displayTask() {
        if (manage.isEmptyList()) {
            System.err.println("List is empty!");
            return;
        }

        ArrayList<Task> taskList = manage.getTaskList();
        System.out.format("%-5s%-15s%-15s%-15s%-15s%-15s",
                "ID","Task type", "Name",  "Date", "Time", "Assignee", "Reviewer");
        for(Task task : taskList){
            System.out.println();
            task.display();
            System.out.println();
        }

    }
}
