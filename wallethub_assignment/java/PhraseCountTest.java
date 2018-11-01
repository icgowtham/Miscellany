import java.io.*;
import java.util.*;

public class PhraseCountTest
{
    private static final int MAX_PHRASES = 10;

    public static class Phrase implements Comparable<Phrase>
    {
        String phrase;
        int count;

        @Override
        public int hashCode() {
            return phrase.hashCode ();
        }

        @Override
        public boolean equals (Object obj) {
            return phrase.equals (((Phrase) obj).phrase);
        }

        @Override
        public int compareTo (Phrase b) {
            return b.count - count;
        }
    }

    public static void main (String[] args)
    {
        Map<String, Phrase> phraseCountMap = new HashMap<String, Phrase> ();
        Scanner sc = null;

        try (FileInputStream inputStream = new FileInputStream (args[0])) {
            sc = new Scanner (inputStream, "UTF-8");

            while (sc.hasNextLine ()) {
                String line = sc.nextLine ();
                String[] phrases = line.split ("\\|");

                for (String str : phrases) {
                    String phrase = str.trim ();
                    if ("".equals (phrase)) {
                        continue;
                    }

                    Phrase phraseObj = phraseCountMap.get (phrase);
                    if (phraseObj == null) {
                        phraseObj = new Phrase ();
                        phraseObj.phrase = phrase;
                        phraseObj.count = 0;
                        phraseCountMap.put (phrase, phraseObj);
                    }

                    phraseObj.count++;
                }
            }
        } catch (Exception e) {
            System.err.println (e.getMessage ());
        } finally {
            if (sc != null) {
                sc.close ();
            }
        }

        SortedSet<Phrase> sortedPhrases = new TreeSet<Phrase> (phraseCountMap.values ());
        int i = 0;

        for (Phrase phrase : sortedPhrases) {
            if (i > PhraseCountTest.MAX_PHRASES) {
                break;
            }

            System.out.println(phrase.count + "\t" + phrase.phrase);
            i++;
        }
    }
}
