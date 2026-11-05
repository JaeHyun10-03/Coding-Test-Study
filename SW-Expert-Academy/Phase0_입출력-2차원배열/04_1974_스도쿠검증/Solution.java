import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        

        for(int test_case = 1; test_case <= T; test_case++)
        {
            // N번째 테스트 케이스에 해당하는 스도쿠 2차원 배열에 넣기
            int[][] arr = new int[9][9];
            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }    


            int result = 1;
            // 3X3 안에 1~9까지 순서대로 잘 있는지 확인
            
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    HashSet<Integer> set = new HashSet<>();
                    set.add(arr[3*i][3*j]);
                    set.add(arr[3*i][3*j+1]);
                    set.add(arr[3*i][3*j+2]);
                    set.add(arr[3*i+1][3*j]);
                    set.add(arr[3*i+1][3*j+1]);
                    set.add(arr[3*i+1][3*j+2]);
                    set.add(arr[3*i+2][3*j]);
                    set.add(arr[3*i+2][3*j+1]);
                    set.add(arr[3*i+2][3*j+2]);
                    if(set.size() != 9){
                        result = 0;
                    }   
                }
            }

            // 수평, 수직에 1~9까지 순서대로 잘 있는지 확인
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    HashSet<Integer> setX = new HashSet<>();
                    HashSet<Integer> setY = new HashSet<>();
                    for(int k=0; k<9; k++){
                        setX.add(arr[k][j]);
                        setY.add(arr[i][k]);
                    }
                    if(setX.size() != 9 || setY.size() != 9){
                        result = 0;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.print(sb);
    }
    
}
