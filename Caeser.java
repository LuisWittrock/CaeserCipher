import java.util.*;

class Caeser {
    public static void main(String[] args)
    {
        Encrypt encrypt = new Encrypt();
        Decrypt decrypt = new Decrypt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Verschluesseln, 2: Entschluesseln");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                encrypt.getInput();    
                break;
            case 2:
                decrypt.getInput();
                break;
            default:
                break;
        }
        scanner.close();
    }
}