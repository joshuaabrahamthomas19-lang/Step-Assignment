import java.util.*;

class Entry{

    String ip;
    long expiry;

    Entry(String ip,int ttl){
        this.ip = ip;
        expiry = System.currentTimeMillis()+ttl*1000;
    }
}

public class DNSCache{

    static HashMap<String,Entry> cache = new HashMap<>();

    static String resolve(String domain){

        Entry e = cache.get(domain);

        if(e!=null && System.currentTimeMillis()<e.expiry)
            return e.ip+" (Cache Hit)";

        String newIP = "172.217.1."+new Random().nextInt(100);

        cache.put(domain,new Entry(newIP,5));

        return newIP+" (Cache Miss)";
    }

    public static void main(String[] args){

        System.out.println(resolve("google.com"));
        System.out.println(resolve("google.com"));
    }
}