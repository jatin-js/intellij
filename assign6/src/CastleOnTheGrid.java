import java.util.*;


public class CastleOnTheGrid {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        int[][] grid = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            String str = s.nextLine();
            for(int j = 0 ; j < n ; j++){
                char ch = str.charAt(j);
                if(ch == 'X'){
                    grid[i][j] = - 1 ;
                }
            }
        }
        int startx = s.nextInt();
        int starty = s.nextInt();

        grid[startx][starty] = 1;

        int endx = s.nextInt();
        int endy = s.nextInt();

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{startx,starty});
        go(list,grid);

        System.out.println(grid[endx][endy]-1);
    }
    static void go(List<int[]> l , int[][] map ){
        int[] xy = l.get(0);
        l.remove(0);
        int x = xy[0];
        int y = xy[1];
        int temp = x ;
        int n = map[x][y] + 1 ;
        while(--temp >= 0 && (map[temp][y] == 0 || map[temp][y] >= n)){
            map[temp][y] = n;
            l.add(new int[]{temp,y});
        }
        temp = x ;
        while(++temp < map.length && (map[temp][y] == 0 || map[temp][y] >= n)){
            map[temp][y] = n;
            l.add(new int[]{temp,y});
        }
        temp = y ;
        while(--temp >= 0 && (map[x][temp] == 0 || map[x][temp] >= n)){
            map[x][temp] = n;
            l.add(new int[]{x,temp});
        }
        temp = y ;
        while(++temp < map.length && (map[x][temp] == 0 || map[x][temp] >= n)){
            map[x][temp] = n;
            l.add(new int[]{x,temp});
        }
        if(l.size() > 0){
            go(l , map);
        }
    }
}