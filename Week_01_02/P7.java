import java.util.*;

public class Autocomplete {

    static HashMap<String,Integer> queries = new HashMap<>();

    static void add(String q){
        queries.put(q, queries.getOrDefault(q,0)+1);
    }

    static void suggest(String prefix){

        for(String q : queries.keySet()){

            if(q.startsWith(prefix))
                System.out.println(q);
        }
    }

    public static void main(String[] args){

        add("java tutorial");
        add("javascript");
        add("java download");

        suggest("jav");
    }
}