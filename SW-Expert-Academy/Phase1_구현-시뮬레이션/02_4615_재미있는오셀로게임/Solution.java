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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int center = N/2;

            int[][] arr = new int[N][N];


            // 기본 세팅
            arr[center-1][center-1] = 2;
            arr[center-1][center] = 1;
            arr[center][center-1] = 1;
            arr[center][center] = 2;

            // 방향 [상, 우상, 우, 우하, 하, 좌하, 좌, 좌상]
            int[] dxArr = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dyArr = {-1, -1, 0, 1, 1, 1, 0, -1};


            // 순회하면서 돌 놓기
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int stone = Integer.parseInt(st.nextToken());

                arr[y][x] = stone;
                
                // 8방향 돌면서 확인하기
                for(int d=0; d<dxArr.length; d++){
                    int dx = x + dxArr[d];
                    int dy = y + dyArr[d];
                    int count = 0;

                    if(dx < 0 || dx >= N || dy < 0 || dy >= N){
                            continue;
                    }

                    // 놓은 돌과 확인하는 돌이 
                    // 서로 다르면 계속 전진
                    // 서로 같으면 그 사이에 있는 돌들 전부 색 바꿔.
                    while(true){
                        if(dx < 0 || dx >= N || dy < 0 || dy >= N){
                            break;
                        }
                        if(arr[dy][dx] > 0 && arr[dy][dx] != arr[y][x]){
                            count++;
                            dx += dxArr[d];
                            dy += dyArr[d];
                        }else{
                            break;
                        }
                    }

                    if(count > 0 && dx>=0 && dx<N && dy>= 0 && dy<N && arr[dy][dx] == stone){
                        for(int j=1; j<=count; j++){
                            arr[y + (dyArr[d]*j)][x + (dxArr[d] * j)] = stone;
                        }
                    }   
                }
            }
            int black = 0;
            int white = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == 1){
                        black++;
                    }else if(arr[i][j] == 2){
                        white++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(black).append(" ").append(white).append("\n");
        }
        System.out.print(sb);
    }
}
