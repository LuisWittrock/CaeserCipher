// An zukunfts Luis:
// Lass dir erstmal alle moeglichen kombinationen ausgeben um zu sehen ob es funktioniert.
// Wenn dass funktioniert zaehle die buchstaben und bestimme fuer welche kombination die haufigkeit am besten mit der der deutschen sprache uebereinstimmt.


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
        int schluessel = combinations(text)-1;
        System.out.println("################################################################################################################################### \n");
        System.out.println("Entschluesselung: " + encrypt.verschluesseln(schluessel, text) + "\n");
        System.out.println("################################################################################################################################### \n");
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
        System.out.println("Sequence: " + charSequence);
        return charSequence.toString();

    }
    public int combinations(String text)
    {
        String deutsch = "enisratdhulcgmobwfkzpvjyxq";
        Encrypt encrypt = new Encrypt();
        String allCombinations[] = new String[27];
        int match[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        for(int i = 0; i<=26; i++)
        {
            allCombinations[i] = encrypt.verschluesseln(i, text);
            System.out.println("schluessel: " + i);
            System.out.println("Entschluesselt: " + allCombinations[i]);
            allCombinations[i] = charFrequency(allCombinations[i]);
        }
        for(int i = 0; i<=26; i++)
        {
            int j = 0;
            for(char ch: allCombinations[i].toCharArray())
            {
                if(ch == deutsch.charAt(j))
                {
                    match[i]++;
                }
                j++;
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
        System.out.println(index);
        return index;
    }
}