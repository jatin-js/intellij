
import java.util.*;

public class GraphComponent{



    static int leader(int arr[],int c){
        if(arr[c]<0)return c;
        return leader(arr, arr[c]);
    }

    static void merge(int arr[], int a, int b){
        int l1 = leader(arr, a);
        int l2 = leader(arr, b);
        if(l1==l2)return;
        if(arr[l1]<=arr[l2]){
            arr[l1]+=arr[l2];
            arr[l2]=l1;
        }
        else {
            arr[l2]+=arr[l1];
            arr[l1]=l2;
        }
    }

    static int[] componentsInGraph(int[][] gb) {

        int i;
        int n = gb.length;
        int arr[] = new int[2*n+1];
        for(i=0;i<=2*n;i++)arr[i]=-1;
        for(i=0;i<n;i++){
            merge(arr, gb[i][0], gb[i][1]);
        }
        int min=-121212, max = 121212;
        for(i=1;i<=2*n;i++){
            if(arr[i]<0){
                if(arr[i]<max)max = arr[i];
                if(arr[i]>min && arr[i]!=-1)min = arr[i];
            }
        }
        int ans[]={-min, -max};
        return ans;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[][] gb = new  int[n][2];
        int i;
        for(i=0;i<n;i++){
            gb[i][0] = scanner.nextInt();
            gb[i][1] = scanner.nextInt();

        }
        int[] ans = componentsInGraph(gb);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}

