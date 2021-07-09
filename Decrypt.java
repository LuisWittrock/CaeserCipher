import java.util.*;

class Decrypt
{
    public void getInput()
    {
        Encrypt encrypt = new Encrypt();
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcher text soll entschluesselt werden: ");
        String text = scanner.next();
        scanner.close();
        int schluessel = combinations(text);
        System.out.println(encrypt.verschluesseln(schluessel, text));
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
    public int combinations(String text)
    {
        String deutsch = "enisratdhulcgmobwfkzpvjyxq";
        Encrypt encrypt = new Encrypt();
        String allCombinations[] = new String[27];
        int match[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for(int i = 1; i<=26; i++)
        {
            allCombinations[i] = encrypt.verschluesseln(i, text);
            System.out.println(allCombinations[i]);
            allCombinations[i] = charFrequency(allCombinations[i]);
        }
        System.out.println("got here1");
        for(int i = 1; i<=26; i++)
        {
            System.out.println(i);
            for(int j = 0; j<26; j++)
            {
                System.out.println(j);
                if(allCombinations[i].charAt(j) == deutsch.charAt(j))
                {
                    match[i]++;
                }
            }
        }
        int max = 0;
        int index = 0;
        for(int i = 0; i<26; i++)
        {
            if(match[i] > max)
            {
                index = i+1;
                max = match[i];
            }
        }
        return index;

    }
}