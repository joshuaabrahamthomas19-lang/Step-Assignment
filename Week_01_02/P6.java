import java.util.*;

public class RateLimiter {

    static HashMap<String,Integer> requests = new HashMap<>();
    static int LIMIT = 5;

    static boolean check(String client){

        int count = requests.getOrDefault(client,0);

        if(count < LIMIT){

            requests.put(client,count+1);
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        System.out.println(check("A"));
        System.out.println(check("A"));
    }
}