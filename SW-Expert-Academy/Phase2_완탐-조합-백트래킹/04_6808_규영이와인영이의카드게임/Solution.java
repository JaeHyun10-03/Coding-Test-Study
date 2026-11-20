import java.util.*;
import java.io.*;

class Solution
{
    static int[] a;
    static int[] b;
    static int winCount;
    static int loseCount;
    static boolean[] visited;

    static void dfs(int depth, int aScore, int bScore){
        // 종료 조건
        if(depth == 9){
            if(aScore > bScore){
                winCount++;
            }else if(aScore < bScore){
                loseCount++;
            }
            return;
        }


        // 다른 경우의 수로 넘어가
        for(int i=0; i<9; i++){
            if(visited[i]){
                continue;
            }

            if(!visited[i]){
                visited[i] = true;

                if(a[depth] > b[i]){
                    dfs(depth + 1, aScore + a[depth] + b[i] , bScore);
                }else{
                    dfs(depth + 1, aScore, bScore + a[depth] + b[i]);
                }

                visited[i] = false;
            }

        }
        
    }


    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean[] used = new boolean[19];

            winCount = 0;
            loseCount = 0;

            // 내 카드 배열에 넣기
            a = new int[9];
            for(int i=0; i<9; i++){
                a[i] = Integer.parseInt(st.nextToken());
                used[a[i]] = true;
            }

            // 니 카드 배열에 넣기
            b = new int[9];
            int idx = 0;
            for(int i=1; i<=18; i++){
                if(used[i] == false){
                    b[idx++] = i;
                }
            }

            visited = new boolean[9];


            // dfs 사용
            dfs(0, 0, 0);

            sb.append("#").append(test_case).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
        }
        System.out.print(sb);
    }
}
