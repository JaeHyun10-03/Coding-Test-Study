function solution(progresses, speeds) {
  const answer = [];
  const daysLeft = progresses.map((progress, i) => Math.ceil((100 - progress) / speeds[i]));
  let cnt = 0;
  let maxDay = daysLeft[0];

  for (let i = 0; i < progresses.length; i++) {
    if (daysLeft[i] <= maxDay) {
      cnt++;
    } else {
      answer.push(cnt);
      cnt = 1;
      maxDay = daysLeft[i];
    }
  }
  answer.push(cnt);
  return answer;
}
