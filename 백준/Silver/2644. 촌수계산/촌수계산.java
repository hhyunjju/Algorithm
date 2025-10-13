import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 1. 입력 처리
        int n = Integer.parseInt(br.readLine()); // 전체 사람 수
        String[] q = br.readLine().split(" ");
        int a = Integer.parseInt(q[0]); // 시작점
        int b = Integer.parseInt(q[1]); // 목표점
        int relationCnt = Integer.parseInt(br.readLine());

        // 2. 그래프 및 초기화
        List<List<Integer>> relationList = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            relationList.add(new ArrayList<>());
        }
        
        // 그래프에 관계(양방향) 저장
        for (int i = 0; i < relationCnt; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]); // 부모
            int y = Integer.parseInt(xy[1]); // 자식
            relationList.get(x).add(y); // x와 y는 1촌 관계
            relationList.get(y).add(x); // 촌수 계산은 무방향 그래프로 처리
        }

        // 3. BFS 준비
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int result = 0; // 촌수 (거리)

        // 시작점 A는 무조건 큐에 넣고 방문 처리
        queue.offer(a);
        visited[a] = true;

        boolean isRelated = false;

        // 4. BFS 실행 (거리 계산)
        while(!queue.isEmpty()) {
            // ⭐️ 핵심: 큐에 있는 모든 요소를 처리하기 전에 result를 1 증가시킵니다.
            //        이렇게 하면 같은 촌수(같은 레벨)의 노드는 1번의 result++에 포함됩니다.
            result++; 
            int queueSize = queue.size();

            // 현재 촌수 레벨의 모든 노드 처리
            for (int i = 0; i < queueSize; i++) {
                Integer polledItem = queue.poll();

                List<Integer> polledList = relationList.get(polledItem);
                for (Integer j : polledList) {
                    // 🎯 목표점 B와 일치하면 즉시 모든 루프 종료
                    if (j == b) {
                        isRelated = true;
                        // while 루프를 종료하기 위해 큐를 비우고,
                        // 현재 for 루프를 break로 탈출합니다.
                        queue.clear(); 
                        break; 
                    }
                    
                    // 미방문 노드만 큐에 추가
                    if(!visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
                
                // j 루프에서 B를 찾았다면, 큐가 비워졌으므로 더 이상 처리할 필요가 없습니다.
                if (queue.isEmpty()) {
                    break;
                }
            }
            
            // i 루프에서 B를 찾았다면, 큐가 비워졌으므로 while 루프도 자동으로 다음 반복에서 종료됩니다.
        }

        // 5. 결과 출력
        if(!isRelated) {
            result = -1; // 관계가 없으면 -1
        }
        System.out.println(result);
    }
}