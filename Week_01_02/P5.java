import java.util.*;

public class Analytics {

    static HashMap<String,Integer> views = new HashMap<>();
    static HashMap<String,Set<String>> visitors = new HashMap<>();
    static HashMap<String,Integer> sources = new HashMap<>();

    static void process(String url,String user,String source){

        views.put(url, views.getOrDefault(url,0)+1);

        visitors.putIfAbsent(url,new HashSet<>());
        visitors.get(url).add(user);

        sources.put(source, sources.getOrDefault(source,0)+1);
    }

    public static void main(String[] args){

        process("/news","u1","google");
        process("/news","u2","facebook");

        System.out.println(views);
        System.out.println(visitors);
        System.out.println(sources);
    }
}