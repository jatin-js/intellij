
import java.util.*;

public class SparseArray {

    static int[] matchingStrings(String[] strings, String[] queries) {

        int i,j,count;
        int q = queries.length, n = strings.length;
        int[] result=new int[q];
        for(i=0;i<q;i++)
        {   count=0;
            for(j=0;j<n;j++)
            {
                if(strings[j].equals(queries[i]))
                    count++;
            }
            result[i]=count;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int i;
        String[] strings = new String[n];
        for(i=0;i<n;i++){
            strings[i] = scanner.next();
        }
        int q = scanner.nextInt();
        String[] queries = new String[q];
        for(i=0;i<q;i++){
            queries[i] = scanner.next();
        }

        int[] ans = matchingStrings(strings, queries);
        for(i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
