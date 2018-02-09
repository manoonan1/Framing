
//Michael Noonan Project 1 CS 327 Section 1

import java.util.Scanner;

public class Receiver {

    public static void main (String[] args){
        System.out.println("Enter which framing method you would like to use: ");
        System.out.println("Choose: Bit Stuffing, Byte Stuffing, or Byte Count");
        Scanner in = new Scanner(System.in);
        String choice = in.nextLine();
        switch (choice){
            case "Bit Stuffing": bitStuffing();
                break;

            case "Byte Stuffing": byteStuffing();
                break;

            case "Byte Count": byteCount();
                break;

            default: System.out.println("Not a valid framing method.");
        }

    }

    public static void bitStuffing(){
        System.out.println("Enter a message to the receiver in the format of a valid sender: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String flag = "111111";
        int oneCount = 0;
        if (flag.equals(message.substring(0,6)) && flag.equals(message.substring(message.length() - 6, message.length()))){
            message = message.substring(6, message.length() - 6);
            System.out.println("The message without flag bytes = " + message);
            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) == '1'){
                    oneCount++;
                    if (oneCount == 5){
                        if (message.charAt(i + 1) == '0'){
                            message = message.substring(0, i + 1) + message.substring( i + 1 + 1);
                            oneCount = 0;
                        }
                    }
                    if (oneCount == 6){
                        System.out.println("The received frame has an error!");
                        return;
                    }
                }
            }
            System.out.println("The message without flag bytes and stuffed 0 bits = " + message);
        }
        else {
            System.out.println("The received frame has an error!");
        }
    }

    public static void byteStuffing(){
        System.out.println("Enter a message to the receiver in the format of a valid sender: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        if (!(message.contains("E") || message.contains("F") || message.contains("e") || message.contains("f"))){
            System.out.println("The received frame has an error!");
            return;
        }
        message = message.replaceAll("[EFef]", "");
        System.out.println("The message sent without flag bytes = " + message);
    }

    public static void byteCount(){
        System.out.println("Enter a message to the receiver in the format of a valid sender: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        Integer byteNumber = Character.getNumericValue(message.charAt(0));
        if (byteNumber != message.substring(1).length() + 1){
            System.out.println("The received frame has an error!");
            return;
        }
        System.out.println("The message = " + message.substring(1));
    }
}
