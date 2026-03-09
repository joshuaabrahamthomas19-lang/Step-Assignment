import java.util.*;

public class Plagiarism {

    static Set<String> ngrams(String text){

        String[] words = text.split(" ");
        Set<String> set = new HashSet<>();

        for(int i=0;i<words.length-2;i++){

            String g = words[i]+" "+words[i+1]+" "+words[i+2];
            set.add(g);
        }

        return set;
    }

    public static void main(String[] args){

        String d1 = "machine learning is very useful";
        String d2 = "machine learning is useful";

        Set<String> s1 = ngrams(d1);
        Set<String> s2 = ngrams(d2);

        int match = 0;

        for(String g : s1)
            if(s2.contains(g))
                match++;

        double similarity = (match*100.0)/s1.size();

        System.out.println("Similarity: "+similarity+"%");
    }
}