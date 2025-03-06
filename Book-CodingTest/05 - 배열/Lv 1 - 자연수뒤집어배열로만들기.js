function solution(n) {
  const answer = [];
  const arr = String(n); // "12345" 문자열로 변환
  for (let i = 0; i < arr.length; i++) {
    answer.push(Number(arr[arr.length - 1 - i]));
  }
  return answer;
}
