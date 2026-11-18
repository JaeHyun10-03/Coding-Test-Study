import java.util.*;
import java.io.*;

class Solution
{
    static int[] arr;
    static int sum;
    static int N,K;
    static int count = 0;

    // 뎁스, 합
    static void dfs(int depth, int sum){
        if(sum == K){
            count++;
            return;
        }
        if(sum > K){
            return;
        }
        if(depth == N){
            return;
        }


        // 선택
        dfs(depth + 1, sum + arr[depth]);


        // 미선택
        dfs(depth + 1, sum);
        
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());

            // arr에 값 넣기
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            
            dfs(0, 0);

            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }
    
}
