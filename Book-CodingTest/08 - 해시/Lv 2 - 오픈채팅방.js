function solution(record) {
  var answer = [];
  const map = new Map();
  // Map() 객체에 마지막으로 등록된 닉네임을 저장한다.
  for (let i = 0; i < record.length; i++) {
    let [status, id, nick] = record[i].split(" ");
    status !== "Leave" && map.set(id, nick);
  }
  // Map() 객체에 저장된 닉네임을 과거 닉네임 부분에 대입하여 출력한다.
  for (let i = 0; i < record.length; i++) {
    let [status, id] = record[i].split(" ");
    switch (status) {
      case "Enter":
        answer.push(`${map.get(id)}님이 들어왔습니다.`);
        break;
      case "Leave":
        answer.push(`${map.get(id)}님이 나갔습니다.`);
        break;
    }
  }
  return answer;
}
