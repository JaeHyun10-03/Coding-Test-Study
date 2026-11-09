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
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for(int i=0; i<N; i++){
                String[] str = br.readLine().split("");
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(str[j]);
                }
            }


            // 수확 알고리즘
            int sum = 0;
            for(int i=0; i<N; i++){
                // 거리 구하기
                int center = N/2;
                int distance = Math.abs(i - center);
                int start = distance;
                int last = N - distance;

                for(int j=start; j<last; j++){
                    sum += arr[i][j];
                }
            }


            
            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
