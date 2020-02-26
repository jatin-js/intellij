package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] mat = { {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,4,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,6,0},
                        {0,0,0,0,0,8,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,9,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0}};

        int[][] mat2 = {{0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,4,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,6,0},
                        {0,0,0,0,0,8,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,9,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0,0,0}};
//        int[][] mat = {{0,0,0,0},
//                        {0,1,0,0},
//                        {0,0,2,0},
//                        {0,0,0,3}};
//        int[][] mat2 = {{0,0,0,0},
//                        {0,1,0,0},
//                        {0,0,2,0},
//                        {0,0,0,3}};
        int n=9;
        Sudoku s = new Sudoku();
        s.sudoku(mat, mat2, n);
    }
}


class Sudoku{
    void sudoku(int mat[][], int mat2[][],int n){
        Scanner scr = new Scanner(System.in);
        int count = 4, i, j;
        Row rf = new Row();
        Column cf = new Column();
        Mat mf = new Mat();

        while(count!=n*n) {
           System.out.println("Enter location");
           int r = scr.nextInt();
           int c = scr.nextInt();
           if (mat2[r][c] == 0){

               System.out.println("Enter value");
               int v = scr.nextInt();
               if(rf.row(mat, v, r, n) && cf.column(mat, v, c, n) && mf.mat(mat, v, r, c, n)){
                   if(mat[r][c]==0)
                       count++;
                   mat[r][c] = v;

               }
           }else{
               System.out.println("Already filled");
           }
           for(i=1;i<=n;i++){
               for(j=1;j<=n;j++){
                   System.out.print(mat[i][j]+" ");
               }
               System.out.println();
           }
       }
        System.out.println("Game Finished.");
    }
}
class Row{
    boolean row(int mat[][],int v, int r, int n){
        int i;
        for(i=1;i<=n && mat[r][i]!=v;i++);

        if(i==n+1) return true;
        return false;

    }
}
class Column{
    boolean column(int mat[][],int v, int c, int n){
        int i;
        for(i=1;i<=n && mat[i][c]!=v;i++);

        if(i==n+1) return true;
        return false;

    }
}class Mat{
    boolean mat(int mat[][],int v, int r, int c, int n){
        int R, C;
        if(r<=n/3)R=1;
        else if(r<=2*n/3)R=n/3+1;
        else R=2*n/3+1;

        if(c<=n/3)C=1;
        else if(c<=2*n/3)C=n/3+1;
        else C=2*n/3+1;
        int i, j;
        for(i=R;i<=R+n/3-1;i++){
            for(j=C;j<=C+n/3-1 && mat[i][j]!=v;j++);
            if(j!=C+n/3) return false;
        }
        return true;

    }
}