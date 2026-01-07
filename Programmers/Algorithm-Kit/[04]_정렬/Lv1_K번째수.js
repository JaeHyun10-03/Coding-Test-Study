function solution(array, commands) {
  var answer = [];
  for (let c = 0; c < commands.length; c++) {
    const [i, j, k] = commands[c];
    const splitArray = array.slice(i - 1, j).sort((a, b) => a - b);

    answer.push(splitArray[k - 1]);
  }

  return answer;
}
