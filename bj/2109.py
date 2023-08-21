# 2109 순회강연
import heapq

# 입력받기
n = int(input())
univ = [list(map(int,input().split())) for _ in range(n)]
univ = sorted(univ, key=lambda x:x[1])  # 데드라인 기준으로 정렬

lecture = []
for p,d in univ:
    '''
    univ가 day기준으로 오름차순 정렬 되어 있으므로
    데드라인이 짧은 순서로 대학 강연의 페이가 힙에 저장된다.
    이때 저장될 때, 우선순위 큐를 활용하므로 페이가 낮은 순서대로
    저장된다.
    '''
    heapq.heappush(lecture,p)
    '''
    강연은 하루에 하나만 가능하다. 강연의 수가 데드라인보다 크면
    강연을 할 수 없으므로 pop을 하면 우선순위 큐는 페이가
    낮은 순서대로 뱉어낸다.
    따라서 힙에 일단 페이를 저장한 후, 데드라인과 비교했을 때
    강연의 수가 더 많으면 가장 낮은 페이를 뱉어내는 식으로 해서
    for 문을 모두 돌고 나면 데드라인 대비 페이가 쎈 강연만 남게 된다.
    '''
    if len(lecture) > d:
        heapq.heappop(lecture)
print(sum(lecture))