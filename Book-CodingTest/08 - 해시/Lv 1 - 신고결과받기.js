function solution(id_list, report, k) {
  var answer = new Array(id_list.length).fill(0);
  const rdReport = [...new Set(report)]; // remove duplicates Report
  const rMap = new Map(); //report Map
  // 신고 당한 유저가 몇 번 신고 당했는지 카운트 세기.
  // 기존 객체에 신고 당한 유저가 있다면 +1 / 없다면 새로 추가
  for (const i in rdReport) {
    let [goodId, badId] = rdReport[i].split(" ");
    if (rMap.has(badId)) {
      rMap.set(badId, rMap.get(badId) + 1); // 신고당한사람 : 몇번 당했나(숫자)
    } else {
      rMap.set(badId, 1);
    }
  }
  // 신고 당한 유저가 정지의 기준에 부합하는지 확인하는 과정
  // 부합한다면 냅두고 / 부합 안한다면 목록에서 삭제
  for (const el of rMap) {
    let [id, cnt] = [el[0], el[1]];
    cnt < k && rMap.delete(id);
  }
  // 정지된 사람만 : rMap{}
  // 위 정지 기준에 부합한 유저를 신고한 유저를 찾는 과정
  // 정지당한유저를 신고했다면 0으로 찬 배열의 인덱스를 +1
  for (let i = 0; i < rdReport.length; i++) {
    let [goodId, badId] = rdReport[i].split(" ");
    if (rMap.has(badId)) {
      answer[id_list.indexOf(goodId)]++;
    }
  }
  return answer;
}
