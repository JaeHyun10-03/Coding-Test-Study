import java.util.*;
import java.io.*;

class Solution
{
    static int N, L;
    static int[][] arr;
    static int maxScore;

    // 뎁스, 총점수, 칼로리
    static void dfs(int depth, int score, int calorie){
        if(calorie > L){
            return;
        }

        if(depth == N){
            maxScore = Math.max(score, maxScore);
            return;
        }

        dfs(depth + 1, score + arr[depth][0], calorie + arr[depth][1]);

        dfs(depth + 1, score, calorie);
    }
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for(int test_case = 1; test_case <= T; test_case++)
        {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            arr = new int[N][2];


            // 재료 입력
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            maxScore = 0;

            // dfs 실행
            dfs(0, 0, 0);

            // 출력
            sb.append("#").append(test_case).append(" ").append(maxScore).append("\n");

        }
        System.out.print(sb);
    }

    
}
