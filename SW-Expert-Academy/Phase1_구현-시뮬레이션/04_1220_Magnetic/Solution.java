import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10; // 테케 10개 고정
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N]; // NxN 배열 맹글기

            // 배열에 값 넣기
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 로직 진행
            // N극 자성체 = 1
            // S극 자성체 = 2
            // 테이블 위 : N극
            // 테이블 아래 : S극
            for(int i=0; i<N; i++){
                for(int x=0; x<N ;x++){
                    for(int y=0; y<N; y++){
                        if(arr[y][x] == 1){
                            // 현재 위치에 있는 자성체가 1이면 -> 아래로 가야함
                            if(y == 99){
                                arr[y][x] = 0;
                            }else if(y+1 <= 99 && arr[y+1][x] == 0){
                                arr[y][x] = 0;
                                arr[y+1][x] = 1;
                            }
                        }else if(arr[y][x] == 2){
                            // 현재 위치에 있는 자성체가 2이면 -> 위로 가야함
                            if(y == 0){
                                arr[y][x] = 0;
                            }else if(y-1 >= 0 && arr[y-1][x] == 0){
                                arr[y][x] = 0;
                                arr[y-1][x] = 2;
                            }
                        }
                    }
                }
            }

            // for(int i=0; i<N; i++){
            //     for(int j=0; j<N; j++){
            //         System.out.print(arr[i][j]);
            //     }
            //     System.out.print("\n");
            // }
            // System.out.println("================");


            // 교착상태 갯수 구하기
            int count = 0;
            for(int x=0; x<N; x++){
                int red = 0;
                for(int y=0; y<N; y++){
                    if(arr[y][x] == 1){
                        red++;
                    }else if(red > 0 && arr[y][x] == 2){
                        red = 0;
                        count++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(count).append("\n");

        }
        System.out.print(sb);
    }
}
