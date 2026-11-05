import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            // 배열 먼저 만들어줘.
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 90도 회전한 배열
            int[][] arr90 = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr90[j][N-1-i] = arr[i][j];
                }
            }



            // 180도 회전한 배열
            int[][] arr180 = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr180[N-1-i][N-1-j] = arr[i][j];
                }
            }


            // 270도 회전한 배열
            int[][] arr270 = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    arr270[N-1-j][i] = arr[i][j];
                }
            }

            sb.append("#").append(test_case).append("\n");
            for(int i=0; i<N; i++){
                // 90도 회전 읽어
                for(int j=0; j<N; j++){
                    sb.append(arr90[i][j]);
                }
                sb.append(" ");

                // 180도 회전 읽어
                for(int j=0; j<N; j++){
                    sb.append(arr180[i][j]);
                }
                sb.append(" ");


                // 270도 회전 읽어
                for(int j=0; j<N; j++){
                    sb.append(arr270[i][j]);
                }
                sb.append("\n");
            }            
        }
        System.out.print(sb);
    }
}
