import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Scanner;


public class Heap {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        boolean c = true;
        while (c) {
            System.out.println("Enter no. of elements");
            int n = scr.nextInt();
            int[] arr = new int[n+1];
            System.out.println("Enter "+n+" elements");
            for (int i = 1; i <= n; i++)
                arr[i] = scr.nextInt();
            System.out.println("1 for max heap");
            System.out.println("2 for min heap");
            int o = scr.nextInt();
            HeapImplement h = new HeapImplement();
            switch (o) {
                case 1:
                    h.maxHeap(arr, n);
                    h.print(arr, n);
                    break;
                case 2:
                    h.minHeap(arr, n);
                    h.print(arr, n);
                    break;
                default:
                    System.out.println("Wrong option");
            }
            System.out.println("1 to continue");
            System.out.println("2 to exit");
            o = scr.nextInt();
            if(o==2)
                c=false;
        }
    }
}
class HeapImplement{
    void minHeap(int arr[], int n){
        int i;
        for (i=n;i>=1;i--){
            minHeapify(arr, i, n);
        }
    }
    void minHeapify(int arr[], int i, int n){
        int l = i*2, r = i*2+1, min = i;
        if(l<=n && arr[l]<arr[min])min=l;
        if(r<=n && arr[r]<arr[min])min=r;
        if(min==i)return;
        swap(arr,i, min);
        minHeapify(arr, min, n);
    }

    void maxHeap(int arr[], int n){
        int i;
        for (i=n;i>=1;i--){
            maxHeapify(arr, i, n);
        }
    }
    void maxHeapify(int arr[], int i, int n){
        int l = i*2, r = i*2+1, max = i;
        if(l<=n && arr[l]>arr[max])max=l;
        if(r<=n && arr[r]>arr[max])max=r;
        if(max==i)return;
        swap(arr,i, max);
        maxHeapify(arr, max, n);
    }

    void print(int arr[], int n){
        for(int i=1;i<=n;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }


    void swap(int arr[], int i, int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }


}


