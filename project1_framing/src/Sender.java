import java.util.Scanner;

public class Sender {

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

        System.out.println("Enter a message as a sender to be prepared in the format of a valid receiver: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String flag = "111111";
        int oneCount = 0;
        if (!(message.contains("1") || message.contains("0"))){
            System.out.println("The received frame has an error!");
            return;
        }
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '1'){
                oneCount++;
                if(oneCount == 6){
                    message = message.substring(0, i) + "0" + message.substring(i, message.length());
                    oneCount = 0;
                }
            }
        }
        message = flag+message+flag;
        System.out.println("The message will be sent to the receiver in this format: " + message);
    }

    public static void byteStuffing(){
        System.out.println("Enter a message as a sender to be prepared in the format of a valid receiver: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String flag = "EF";
        message = flag+message+flag;
        System.out.println("The message will be sent to the receiver in this format: " + message);
    }

    public static void byteCount(){
        System.out.println("Enter a message as a sender to be prepared in the format of a valid receiver: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String sentMessage = String.valueOf(message.length() + 1);
        message = sentMessage + message;
        System.out.println("The message will be sent to the receiver in this format: " + message);
    }

}
