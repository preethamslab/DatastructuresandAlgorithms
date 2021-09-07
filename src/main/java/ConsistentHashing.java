import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Consistency Hash algorithm without virtual nodes
 */
public class ConsistentHashing {

    //List of servers to be added to the Hash ring
    private static String[] servers = { "192.168.0.0:111", "192.168.0.1:111",
            "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111" };

    //key represents the hash value of the server and value represents the server
    private static SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();

    //Program initialization, put all servers into sortedMap
    static {
        for (int i=0; i<servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println("[" + servers[i] + "]Join the collection, his Hash The value is" + hash);
            sortedMap.put(hash, servers[i]);
        }
        System.out.println();
    }

    //Get the node that should be routed to
    private static String getServer(String key) {
        //Get the hash value of the key
        int hash = getHash(key);
        //Get all Map s that are larger than the Hash value
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if(subMap.isEmpty()){
            //If there is no one larger than the hash value of the key, start with the first node
            Integer i = sortedMap.firstKey();
            //Return to the corresponding server
            return sortedMap.get(i);
        }else{
            //The first Key is the nearest node clockwise past the node.
            Integer i = subMap.firstKey();
            //Return to the corresponding server
            return subMap.get(i);
        }
    }

    //Using FNV1_32_HASH algorithm to calculate the Hash value of the server, there is no need to rewrite hashCode method, the final effect is no difference.
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // If the calculated value is negative, take its absolute value.
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    public static void main(String[] args) {
        String[] keys = {"sunlight", "Moon", "Stars","preetham","akshat","Utkarsh","kruti","ravi"};
        for(int i=0; i<keys.length; i++)
            System.out.println("[" + keys[i] + "]Of hash The value is" + getHash(keys[i])
                    + ", Routed to Node[" + getServer(keys[i]) + "]");
    }
}