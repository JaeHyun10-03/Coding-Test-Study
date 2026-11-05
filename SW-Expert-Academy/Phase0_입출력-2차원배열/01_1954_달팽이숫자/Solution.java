import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            int number = 1;
            int maxNumber = N*N;

            int x = 0;
            int y = 0;

            int[] dxArr = {1, 0, -1, 0};
            int[] dyArr = {0, 1, 0, -1};

            int direction = 0;

            while(number <= maxNumber){
                arr[y][x] = number;
                number++;

                int dx = dxArr[direction % 4];
                int dy = dyArr[direction % 4];

                if(dx+x >= N || dy+y >= N || dx+x < 0 || dy+y < 0 || arr[y+dy][x+dx] != 0){
                    direction++;
                    dx = dxArr[direction % 4];
                    dy = dyArr[direction % 4];
                }
                x += dx;
                y += dy;
            }

            sb.append("#").append(test_case).append("\n");

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(j > 0){
                        sb.append(" ");
                    }
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
