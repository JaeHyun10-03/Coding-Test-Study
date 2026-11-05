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
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);

            int[][] arr = new int[N][N];
            int maxSum = 0;

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<= N-M; i++){
                for(int j=0; j<= N-M; j++){
                    int sum = 0;
                    for(int y=i; y<i+M; y++){
                        for(int x=j; x<j+M; x++){
                            sum += arr[y][x];
                        }
                    }
                    if(sum > maxSum){
                        maxSum = sum;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
        }
        System.out.print(sb);
    }
}
