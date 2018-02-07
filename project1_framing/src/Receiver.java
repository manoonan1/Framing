import java.util.Scanner;

public class Receiver {

    public static void main (String[] args){
        System.out.println("Enter which framing method you would like to use: ");
        System.out.println("Choose: Bit Stuffing, Byte Stuffing, or Byte Count");
//        byteCount();
//        byteStuffing();
        bitStuffing();

    }

    public static void bitStuffing(){
        System.out.println("Enter a message to the receiver in the format of a valid sender: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String flag = "111111";
        int oneCount = 0;
        message = message.replaceAll(flag, "");
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) == '1'){
                oneCount++;
                if(oneCount == 5){
                    message = message.substring(0, i) + "" + message.substring(i, message.length());
                    oneCount = 0;
                }
            }
        }
        System.out.println(message);
    }

    public static void byteStuffing(){
        System.out.println("Enter a message to the receiver in the format of a valid sender: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        message = message.replaceAll("[EFef]", "");
//        if (message.contains("E") || message.contains("F")){
//            System.out.println("The received frame has an error!");
//            return;
//        }
        System.out.println(message);
    }

    public static void byteCount(){
        System.out.println("Enter a message to the receiver in the format of a valid sender: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        int byteNumber = (int) message.charAt(0);
        if (Integer.valueOf(byteNumber) != message.substring(1).length() + 1){
            System.out.println("The received frame has an error!");
            return;
        }
        System.out.println(message.substring(1));
    }
}
