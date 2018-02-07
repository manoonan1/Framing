import java.util.Scanner;

public class Sender {

    public static void main (String[] args){
        System.out.println("Enter which framing method you would like to use: ");
        System.out.println("Choose: Bit Stuffing, Byte Stuffing, or Byte Count");
//       byteCount();
        bitStuffing();

    }

    public static void bitStuffing(){

        System.out.println("Enter a message as s sender to be prepared in the format of a valid receiver: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String flag = "111111";
        int oneCount = 0;
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
        System.out.println(message);
    }

    public static void byteStuffing(){
    }

    public static void byteCount(){
        System.out.println("Enter a message as s sender to be prepared in the format of a valid receiver: ");
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        String sentMessage = String.valueOf(message.length() + 1);
        message = sentMessage + message;
        System.out.println(message);
    }

}
