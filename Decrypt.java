import java.util.*;
class Decrypt
{
    public void getInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcher text soll entschluesselt werden: ");
        String text = scanner.next();
        scanner.close();
        charFrequency(text);
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
    public String charFrequency(String text) //used to determine the frequency of each char.
    {
        StringBuilder charSequence = new StringBuilder();
        int[] frequency = new int[26];
        for(int i = 0; i<26; i++) frequency[i] = 0;

        for(int i = 0; i<text.length(); i++)
        {
            frequency[(int)text.charAt(i)-'a']++;
        }
        for(int i = 0; i<26; i++)
        {
            int currMax = 0;
            int currIndex = 0;
            for(int j = 0; j<26; j++)
            {
                if(frequency[j] > currMax)
                {
                    currMax = frequency[j];
                    currIndex = j;
                }
            }
            if(currMax == 0) continue;
            frequency[currIndex]=0;
            int a = (int)'a'+currIndex;
            charSequence.append((char)a);
        }
        System.out.println(charSequence);
        return charSequence.toString();
    }
}