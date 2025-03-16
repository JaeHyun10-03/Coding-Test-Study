function solution(genres, plays) {
  var answer = [];
  const gRank = new Map();
  // 장르 A에 대한 총 play 수를 찾는 과정
  for (const i in genres) {
    gRank.has(genres[i]) ? gRank.set(genres[i], gRank.get(genres[i]) + plays[i]) : gRank.set(genres[i], plays[i]);
  }
  const rankArr = [...gRank].sort((a, b) => b[1] - a[1]); // value로 정렬
  // 인기 장르로 정렬된 배열을 순서대로 순회하며 가장 많이 플레이 된 음반을 찾는다.
  // 해당 장르에 인기 음반이 2개 이상이라면 2개를 출력 / 1개만 있다면 1개 출력
  for (let i = 0; i < rankArr.length; i++) {
    let [gen, play] = [rankArr[i][0], rankArr[i][1]];
    const idxPlayMap = new Map();
    // 현재 해당하는 인기장르와 genres의 장르가 같다면
    // 해당 인덱스의 plays를 {해당 횟수 : play횟수} 꼴로 Map()에 저장
    for (let i = 0; i < genres.length; i++) {
      genres[i] === gen && idxPlayMap.set(i, plays[i]);
    }
    const ipMap = [...idxPlayMap].sort((a, b) => b[1] - a[1]); // value로 정렬
    // 인기 장르 && 플레이 수 多 && 플레이 수 同 -> 인덱스가 낮은 순으로 정렬된 결과 출력
    for (let i = 0; i < 2; i++) {
      answer.push(ipMap[i][0]);
      if (ipMap.length < 2) break;
    }
  }
  return answer;
}
