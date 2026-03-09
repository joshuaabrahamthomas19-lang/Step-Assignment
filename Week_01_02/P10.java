import java.util.*;

public class Cache {

    static HashMap<String,String> L1 = new HashMap<>();
    static HashMap<String,String> L2 = new HashMap<>();

    static String get(String id){

        if(L1.containsKey(id))
            return "L1 HIT";

        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT";
        }

        L2.put(id,"VideoData");
        return "Database HIT";
    }

    public static void main(String[] args){

        System.out.println(get("video1"));
        System.out.println(get("video1"));
    }
}