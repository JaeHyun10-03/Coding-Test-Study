import java.util.*;
import java.io.*;


class Solution{
    static StringBuilder st;
    static int[] arr;
    static int N, M;
    static int maxSum;

    static void dfs(int depth, int sum, int count){
        if(count == 2 && sum <= M){
            maxSum = Math.max(maxSum, sum);
            return;
        }

        if(sum > M){
            return;
        }

        if(depth == N){
            return;
        }

        // 선택
        dfs(depth + 1, sum + arr[depth], count+1);


        // 미선택
        dfs(depth + 1, sum, count);
    }



    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            maxSum = 0;



            // arr에 봉지 무게 넣기
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // dfs로 봉지 무게 넣기
            dfs(0,0,0);
            
            if(maxSum == 0){
                sb.append("#").append(test_case).append(" ").append(-1).append("\n");
            }else{
                sb.append("#").append(test_case).append(" ").append(maxSum).append("\n");
            }
            
        }
        System.out.print(sb);
    }
}
