import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, int ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl * 1000;
    }
}

public class DNSCache {

    private HashMap<String, DNSEntry> cache = new HashMap<>();
    private int hits = 0, misses = 0;

    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && System.currentTimeMillis() < entry.expiry) {
            hits++;
            return entry.ip + " (Cache HIT)";
        }

        misses++;

        String newIP = "172.217.14." + new Random().nextInt(255);
        cache.put(domain, new DNSEntry(newIP, 5));

        return newIP + " (Cache MISS)";
    }

    public void stats() {
        System.out.println("Hits: " + hits + " Misses: " + misses);
    }

    public static void main(String[] args) throws Exception {

        DNSCache dns = new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));

        dns.stats();
    }
}