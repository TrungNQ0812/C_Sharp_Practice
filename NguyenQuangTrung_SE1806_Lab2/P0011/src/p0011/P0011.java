package p0011;

import java.lang.Math;
import java.math.BigInteger;
import java.util.Scanner;

public class P0011 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        P0011 p = new P0011();
        p.Menu();
    }

    public void Menu() {
        int choice1, choice2;
        String inputValue, yn;
        boolean valid = true;

        do {
            System.out.println("================");
            System.out.println("1. Binary.");
            System.out.println("2. Decimal.");
            System.out.println("3. Hexadecimal.");
            System.out.println("================");
            choice1 = getChoice("Choose the input base: ", 1, 3);

            choice2 = getChoice("Choose the output base: ", 1, 3);

            System.out.println("Enter the value you want to convert: ");
            do {
                inputValue = sc.nextLine();
                if (inputValue.trim().isEmpty()) {
                    System.err.println("Input value cannot be empty. Please enter a value.");
                }

                String result = "";
                switch (choice1) {
                    case 1:
                        switch (choice2) {
                            case 1:
                                if (isBinary(inputValue)) {
                                    System.err.println("same the base, no convert!");
                                    result = inputValue;
                                } else {
                                    System.err.println("Invalid binary input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                            case 2:
                                if (isBinary(inputValue)) {
                                    result = convertToDecimal(inputValue, 2).toString();
                                } else {
                                    System.err.println("Invalid binary input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                            case 3:
                                if (isBinary(inputValue)) {
                                    result = convertDecimalToBase(convertToDecimal(inputValue, 2).toString(), 16);
                                } else {
                                    System.err.println("Invalid binary input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                        }
                        break;

                    case 2:
                        switch (choice2) {
                            case 1:
                                if (isDecimal(inputValue)) {
                                    result = convertDecimalToBase(inputValue, 2);
                                } else {
                                    System.err.println("Invalid decimal input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                            case 2:
                                if (isDecimal(inputValue)) {
                                    System.err.println("Same the base, no convert!");
                                    result = inputValue;
                                } else {
                                    System.err.println("Invalid decimal input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                            case 3:
                                if (isDecimal(inputValue)) {
                                    result = convertDecimalToBase(inputValue, 16);
                                } else {
                                    System.err.println("Invalid decimal input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                        }
                        break;
                    case 3:
                        switch (choice2) {
                            case 1:
                                if (isHexadecimal(inputValue)) {
                                    result = convertDecimalToBase(convertToDecimal(inputValue, 16).toString(), 2);
                                } else {
                                    System.err.println("Invalid hexadecimal input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                            case 2:
                                if (isHexadecimal(inputValue)) {
                                    result = convertToDecimal(inputValue, 16).toString();
                                } else {
                                    System.err.println("Invalid hexadecimal input.");
                                    inputValue = "";
                                    continue;
                                }
                                break;
                            case 3:
                                if (isHexadecimal(inputValue)) {
                                    System.err.println("Same the base, no convert!");
                                    result = inputValue;
                                } else {
                                    System.err.println("Invalid hexadecimal input.");
                                    inputValue = "";
                                }
                                break;
                        }
                        break;

                    default:
                        System.out.println("Invalid input choice.");
                        continue;
                }

                System.out.println("Result: " + result);

                System.out.println("Do you want to convert another value? (Yes(enter y to continue) / No (enter any key to exit)");
                yn = sc.nextLine();
                String response = yn.toLowerCase().trim();
                valid = response.equalsIgnoreCase("y");

            } while (inputValue.trim().isEmpty());
        } while (valid);
    }

    public int getChoice(String msg, int min, int max) {
        int Choice;
        while (true) {
            System.out.println(msg);
            
                Choice = Integer.parseInt(sc.nextLine().trim());
                if (Choice < min || Choice > max) {
                    return -1;
                }
                return Choice;
            
        }
    }

    public boolean isBinary(String input) {
        if (input.trim().isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (c != '0' && c != '1') {
                return false;
            }
        }
        return true;
    }

    public boolean isHexadecimal(String input) {

        if (input.trim().isEmpty()) {
            return false;
        }
        if (input.startsWith("0x")) {
            input = input.substring(2);
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && (c < 'A' || c > 'F') && (c < 'a' || c > 'f')) {
                return false;
            }
        }

        return true;
    }

    public boolean isDecimal(String input) {
        if (input.trim().isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public BigInteger convertToDecimal(String number, int base) {
        BigInteger num = BigInteger.ZERO;
        BigInteger n = BigInteger.ONE;
        int value, i;
        for (i = number.length() - 1; i >= 0; i--) {
            value = Character.getNumericValue(number.charAt(i));
            num = num.add(BigInteger.valueOf(value).multiply(n));
            if (base != 0) {
                n = n.multiply(BigInteger.valueOf(base));
            }
        }
        return num;
    }

    public String convertDecimalToBase(String number, int base) {
        BigInteger num = new BigInteger(number);
        StringBuilder sb = new StringBuilder();
        while (num.compareTo(BigInteger.ZERO) > 0) {
            BigInteger du = num.mod(BigInteger.valueOf(base));
            if (du.compareTo(BigInteger.valueOf(10)) < 0) {
                sb.append(du);
            } else {
                sb.append((char) (du.intValue() - 10 + 'A'));
            }
            num = num.divide(BigInteger.valueOf(base));
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.reverse().toString();
    }

}
