/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0071;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trung
 */
public class TaskManagement {
    ArrayList<Task> taskList = new ArrayList<>();
    
    public boolean isEmptyList(){
        return taskList.isEmpty();
    }
    
    public ArrayList<Task> getTaskList(){
        return taskList;
    } 
    
    public int increaseLastId(){
        return taskList.get(taskList.size()-1).getId() + 1;
    }
    
    
    public int addTask(String taskTypeId, String requirementName, String date, double planFrom, double planTo, String assignee, String expert){
        int id;
        if(isEmptyList() == true){
            id = 1;
        }else{
            id = increaseLastId();
        }
        Task newTask = new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assignee, expert);
        if(checkDuplicateTask(newTask) == true){
            return -1;
        }else{
            taskList.add(newTask);
        }
        return id;
    }
    
    public boolean checkTime(double from, double to) {
        if (from < to) {
            return true;
        }
        return false;
    }
    
    public boolean checkAssigneeReviewer(String assignee, String reviewer) {
        if (assignee.equalsIgnoreCase(reviewer)) {
            return true;
        }
        return false;
    }
    
    public Task findById(int id){
        for(Task finder : taskList){
            if(finder.getId() == id){
                return finder;
            }
        }
        return null;
    }
    
    public void removeTask(Task theTask) {
        taskList.remove(theTask);
    }
    
    public boolean checkDuplicateTask(Task theTask) {
        for (Task tempTask : taskList) {
            if (tempTask.getRequirementName().equalsIgnoreCase(theTask.getRequirementName())
                    && tempTask.getTaskTypeId().equalsIgnoreCase(theTask.getTaskTypeId())
                    && tempTask.getDate().equalsIgnoreCase(theTask.getDate())
                    && tempTask.getPlanFrom() == theTask.getPlanFrom()
                    && tempTask.getPlanTo() == theTask.getPlanTo()
                    && tempTask.getAssignee().equalsIgnoreCase(theTask.getAssignee())
                    && tempTask.getExpert().equalsIgnoreCase(theTask.getExpert())) {
                return true;
            }
        }
        return false;
    }
}
