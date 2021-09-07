import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
        for(int i =0; i< nums.length;i++)
        {
            if(temp.containsKey(target-nums[i]))
            {
                arr[0] = i;
                arr[1] = temp.get(target - nums[i]);
                return arr;
            }
            temp.put(target - nums[i], i);
        }

/*       if(temp.keySet().size() == 1) {
           arr[0] = 0;
           arr[1] = 1;
            return arr;
       }
       for (int a: temp.keySet())
        {
            if(temp.containsKey(target-a))
            {
                arr[0] = temp.get(a);
                arr[1] = temp.get(target-a);
            }
        }*/
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {3,2, 3};
        int[] arr1 = twoSum(arr,6);
        System.out.println(arr1[0] +" = "+ arr1[1]  );
    }
}