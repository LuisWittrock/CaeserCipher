import java.util.*;
class Caeser {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib ein wort ein: ");
        String text = scanner.next();
        System.out.println("\n Nun einen Schluessel: ");
        int schluessel = scanner.nextInt();
        scanner.close();
        verschluesseln(schluessel, text);
    }
    public static String rotateAlphabet(int schluessel)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i<schluessel; i++)
        {
            tmp.append(alphabet.charAt(i));
        }
        StringBuilder newAlphabet = new StringBuilder();
        int i = schluessel;
        while(newAlphabet.length() < 26-schluessel)
        {
            newAlphabet.append(alphabet.charAt(i));
            i++;
        }
        newAlphabet.append(tmp);
        return newAlphabet.toString();

    }
    public static void verschluesseln(int schluessel, String text)
    {
        String alphabet = rotateAlphabet(schluessel);
        StringBuilder newText = new StringBuilder();
        for(int i = 0; i<text.length(); i++)
        {
            newText.append(alphabet.charAt((int)text.charAt(i)-'a'));
        }
        System.out.println(newText);
    }
    public static void entschluesseln(String text)
    {

    }
}