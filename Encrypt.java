import java.util.*;
class Encrypt
{
    public void getInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcher text soll entschluesselt werden: ");
        String text = scanner.next();
        System.out.print("\n welcher schluessel: ");
        int schluessel = scanner.nextInt();
        verschluesseln(schluessel, text);
        scanner.close();
    }

    public String rotateAlphabet(int schluessel)
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
    public void verschluesseln(int schluessel, String text)
    {
        String alphabet = rotateAlphabet(schluessel);
        StringBuilder newText = new StringBuilder();
        for(int i = 0; i<text.length(); i++)
        {
            newText.append(alphabet.charAt((int)text.charAt(i)-'a'));
        }
        System.out.println(newText);
    }
}