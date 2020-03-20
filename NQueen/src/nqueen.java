 class Main {
    public static void main(String[] args) {
        int[][] mat = new int[8][8];
        NQueen n = new NQueen();
        n.nQueen(mat, 0);
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class NQueen{
    boolean nQueen(int mat[][], int i){
        int j;
        for(j=0;j<8;j++){
            if(checkCol(mat, i, j) && checkDiag(mat, i, j)){
                mat[i][j]=1;
                if(i==7)return true;
                if(nQueen(mat, i+1))return true;
                else {
                    mat[i][j]=0;
                }
            }
        }

        return false;
    }

    boolean checkCol(int mat[][],int i, int j){
        int k;
        for(k=0;k<i && mat[k][j]==0;k++);

        if(k==i)return true;
        return false;
    }

    boolean checkDiag(int mat[][], int i, int j){
        int a = i, b = j, c = a, d = b;
        if(a>b){
            while(b!=-1 && mat[a][b]==0){
                a--;b--;
            }

        }
        else{
            while(a!=-1 && mat[a][b]==0){
                a--;b--;
            }

        }
        if(i<7-j)
         while(c!=-1 && mat[c][d]==0){
             c--;d++;
        }
        else
         while(d!=8 && mat[c][d]==0){
             c--;d++;
         }


        if((b==-1 || a==-1) && (c==-1 || d==8))return true;
        return  false;
    }

}
