import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] arr = new int[100][100];
            int x = -1;
            int y = 99;

            // 좌, 우, 위 
            int direction = 2;
            
            
            // arr에 데이터 넣기
            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            // 2가 있는 곳 찾기
            for(int i=0; i<100; i++){
                if(arr[99][i] == 2){
                    x = i;
                    break;
                }
            }

            // 올라가면서 시작한 지점 찾기
            // 위로 올라가고 있었으면 좌우로 넘어가는게 우선순위
            // 좌 or 우로 가고 있었으면 끝까지 가기 + 끝에 도착하면 위로 올라가기
            while(true){
                if(y-1 < 0){
                    break;
                }

                // 이전 방향이 위일때 
                if(direction == 2){
                    
                    if(x-1 >= 0 && arr[y][x-1] == 1){
                        // 왼쪽에 1이 있으면 그쪽으로 가
                        x -= 1;
                        direction = 0;
                    }else if(x+1 <= 99 && arr[y][x+1] == 1){
                        // 오른쪽에 1이 있으면 그쪽으로 가
                        x +=1;
                        direction = 1;
                    }else if(arr[y-1][x] == 1){
                        // 좌우에 빠지는게 아무것도 없으면 위로 올라가
                        y -= 1;
                        direction = 2;

                    }
                }else if(direction == 0){
                    // 이전 방향 : 좌
                    if(x-1 >= 0 && arr[y][x-1] == 1){
                        // 왼쪽으로 계속 가
                        x -= 1;
                        direction = 0;
                    }else if(arr[y-1][x] == 1){
                        // 위가 열렸으면 위로 가
                        y -= 1;
                        direction = 2;
                    }


                }else if(direction == 1){
                    // 이전 방향 : 우
                    if(x+1 <= 99 && arr[y][x+1] == 1){
                        // 오른쪽으로 계속 가
                        x +=1 ;
                        direction = 1;
                    }else if(arr[y-1][x] == 1){
                        // 위가 열리면 위로 가
                        y -= 1;
                        direction = 2;
                    }
                }
                // System.out.println(x + "," + y );
            }


            // sb에 데이터 넣기
            sb.append("#").append(test_case).append(" ").append(x).append("\n");
        }

        System.out.print(sb);
    }
}
