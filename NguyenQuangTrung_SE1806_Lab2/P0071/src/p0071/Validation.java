/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0071;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author trung
 */
public class Validation {

    Scanner sc = new Scanner(System.in);

    public int inputInteger(String msg, int min, int max) {
        int input;
        while (true) {
            System.out.println(msg);
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        }
    }

    public String inputString(String msg, String regex) {
        String input;
        while (true) {
            System.out.println(msg);
            try {
                input = sc.nextLine();
                if (!input.matches(regex)) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {

            }
        }
    }

    public double inputDouble(String msg, double min, double max) {
        double input;
        while (true) {
            System.out.println(msg);
            try {
                input = Double.parseDouble(sc.nextLine());
                if (input < min || input > max) {
                    throw new NumberFormatException();
                }
                return input;
            } catch (NumberFormatException e) {
                System.err.println("ERROR: " + e.getMessage());
            }
        }
    }

    public String inputDateTime(String msg) {
        String input;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while (true) {
            System.out.print(msg);
            input = sc.nextLine().trim();
            try {
                Date date = dateFormat.parse(input);
                return dateFormat.format(date);
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    public boolean isValidDate(int date, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || date < 1) {
            return false;
        }
        int[] daysInMonth = {31, (isLeapYear(year) ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return date <= daysInMonth[month - 1];
    }

    public boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 != 0) {
            return true;
        }
        return year % 400 == 0;
    }

    public String inputType() {
        int input = inputInteger("Type ID: ", 1, 4);
        String type = null;
        switch (input) {
            case 1:
                type = "Code";
                break;
            case 2:
                type = "Test";
                break;
            case 3:
                type = "Design";
                break;
            case 4:
                type = "Review";
                break;
        }
        return type;
    }
}
