import java.util.*;

public class LargestRectangle {
    static boolean[] valid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ar = new long[n];


        for(int i=0; i<n; i++)
            ar[i] = sc.nextInt();

        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1); Arrays.fill(right, -1);

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i<n; i++){
            while(st.size() > 0){
                if(ar[st.peek()] < ar[i]){
                    left[i] = st.peek();
                    break;
                }
                else
                    st.pop();
            }
            st.push(i);
        }
        st.clear();
        for(int i=n-1; i>=0; i--){
            while(st.size() > 0){
                if(ar[st.peek()] < ar[i]){
                    right[i] = st.peek();
                    break;
                }
                else
                    st.pop();
            }
            st.push(i);
        }

        long max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            long ans = 0;
            if(left[i] >= 0)
                ans+=ar[i]*(i - left[i] -1);
            else
                ans += ar[i] * i;
            if(right[i] > -1)
                ans+=ar[i]*(right[i] - i -1);
            else
                ans += ar[i] * (n - i-1);
            ans += ar[i];
            if(ans > max)
                max = ans;
        }
        System.out.println(max);
    }

    static void pArray(int[] ar){
        for(int i=0; i<ar.length; i++)
            System.out.print(ar[i] + " ");
        System.out.println();

    }
}