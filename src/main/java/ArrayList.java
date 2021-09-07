import java.util.Date;
import java.util.List;

public class ArrayList {
    public static void main(String[] args) {
        Date d1 = new Date();
        List<Integer> list = new java.util.ArrayList<>(1000000);
        for(int i=0;i<1000000;i++)
        {
            list.add(i);
        }
        Date d2 = new Date();
        System.out.println(d2.getTime() - d1.getTime());
    }
}
