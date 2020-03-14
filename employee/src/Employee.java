import java.util.Scanner;

public class Employee {

    static int[] sum(int mat[][], int n) {
        int[] hrSum = new int[n + 1];
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 0; j < 7; j++) {
                hrSum[i] += mat[i][j];
            }
        }
        return hrSum;
    }


    static void display(int hrSum[], String info[], int n) {
        int i;
        for (i = 1; i <= n; i++) {
            System.out.println(hrSum[i] + " " + info[i]);
        }
    }

    static void sort(int mat[][], String info[], int n) {
        int[] hrSum = sum(mat, n);
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = i + 1; j <= n; j++) {
                if (hrSum[j] > hrSum[i]) {
                    hrSum[i] = hrSum[i] ^ hrSum[j];
                    hrSum[j] = hrSum[i] ^ hrSum[j];
                    hrSum[i] = hrSum[i] ^ hrSum[j];

                    String str;
                    str = info[i];
                    info[i] = info[j];
                    info[j] = str;

                    int m[] = new int[0];
                    m = mat[i];
                    mat[i] = mat[j];
                    mat[j] = m;
                }
            }
        }
        display(hrSum, info, n);
    }


    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        System.out.println("Enter no. of employees");
        int n = scr.nextInt(), i, j, eno;
        int[][] mat = new int[n + 1][7];
        String[] str = new String[n + 1];

        for (i = 1; i <= n; i++) {
            scr.nextLine();
            System.out.println("Enter employee name");
            str[i] = scr.nextLine();
            for (j = 0; j < 7; j++) {
                System.out.println("Enter working hours for " + (j + 1) + " day");
                mat[i][j] = scr.nextInt();
            }

        }
        sort(mat, str, n);
    }
}
