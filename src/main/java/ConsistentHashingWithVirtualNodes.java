import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.lang.StringUtils;

/**
 * Consistency Hash algorithm with virtual nodes
 */
public class ConsistentHashingWithVirtualNodes {

    //List of servers to be added to the Hash ring
    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};

    //Real node list, considering the server on-line and off-line scenarios, that is, adding and deleting scenarios will be more frequent, using LinkedList here will be better.
    private static List<String> realNodes = new LinkedList<String>();

    //Virtual node, key represents the hash value of virtual node, value represents the name of virtual node
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<Integer, String>();

    //The number of virtual nodes, written here, for demonstration purposes, a real node corresponds to five virtual nodes
    private static final int VIRTUAL_NODES = 5;

    static{
        //First add the original server to the list of real nodes
        for(int i=0; i<servers.length; i++)
            realNodes.add(servers[i]);

        //Adding virtual nodes makes traversing LinkedList more efficient using foreach loops
        for (String str : realNodes){
            for(int i=0; i<VIRTUAL_NODES; i++){
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                System.out.println("Virtual node[" + virtualNodeName + "]Be added, hash The value is" + hash);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
        System.out.println();
    }

    //Using FNV1_32_HASH algorithm to calculate the Hash value of the server, there is no need to rewrite hashCode method, the final effect is no difference.
    private static int getHash(String str){
        final int p = 16777619;
        int hash = (int)2166136261L;
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

    //Get the node that should be routed to
    private static String getServer(String key){
        //Get the hash value of the key
        int hash = getHash(key);
        // Get all Map s that are larger than the Hash value
        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);
        String virtualNode;
        if(subMap.isEmpty()){
            //If there is no one larger than the hash value of the key, start with the first node
            Integer i = virtualNodes.firstKey();
            //Return to the corresponding server
            virtualNode = virtualNodes.get(i);
        }else{
            //The first Key is the nearest node clockwise past the node.
            Integer i = subMap.firstKey();
            //Return to the corresponding server
            virtualNode = subMap.get(i);
        }
        //The virtual node name needs to be intercepted
        if(StringUtils.isNotBlank(virtualNode)){
            return virtualNode.substring(0, virtualNode.indexOf("&&"));
        }
        return null;
    }

    public static void main(String[] args){
        String[] keys = {"sunlight", "Moon", "Stars","preetham","akshat","Utkarsh","kruti","ravi"};
        for(int i=0; i<keys.length; i++)
            System.out.println("[" + keys[i] + "]Of hash The value is" +
                    getHash(keys[i]) + ", Routed to Node[" + getServer(keys[i]) + "]");
    }
}