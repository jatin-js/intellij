public class RandVK {
    public static void main(String[] args) {
        int[][] mat = new int[4][3];
        int i, j, k = 0;
        for (i = 0; i <= 3; i++) {
            for (j = 0; j <= 2; j++) {
                if (i != 3 || (j != 0 && j != 2))
                    mat[i][j] = k++;
            }
        }
        VK vk = new VK();
        vk.vk(mat);
        vk.print(mat);
    }
}
class VK{
    void vk(int mat[][]){
        int i, j;
        for(i=0;i<=3;i++){
            for (j=0;j<=2;j++){
                if(i!=3 || (j!=0 && j!=2)){
                    int r = (int)(Math.random()*4);
                    int c;
                    if(r==3)c=1;
                    else c = (int)(Math.random()*3);
                    swap(mat, i, j, r, c);
                }
            }
        }
    }
    void swap(int mat[][], int i, int j, int r, int c){
        int t = mat[i][j];
        mat[i][j] = mat[r][c];
        mat[r][c] = t;
    }
    void print(int mat[][]){
        int i, j;
        for(i=0;i<=3;i++){
            for (j=0;j<=2;j++){
                if(i!=3 || (j!=0 && j!=2)) System.out.print(mat[i][j]+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
