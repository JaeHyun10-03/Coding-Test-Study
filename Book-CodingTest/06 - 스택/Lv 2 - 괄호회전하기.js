function solution(s) {
  var answer = 0;
  const len = s.length;

  // 배열 회전을 위한 반복문
  for (let i = 0; i < len; i++) {
    let isToggle = true;
    const stack = [];
    for (let j = 0; j < len; j++) {
      if (s[(i + j) % len] == "(" || s[(i + j) % len] == "{" || s[(i + j) % len] == "[") {
        stack.push(s[(i + j) % len]);
      } else {
        if (stack.length === 0) {
          isToggle = false;
          break;
        }
        const top = stack[stack.length - 1];
        if (s[(i + j) % len] == ")" && top == "(") {
          stack.pop();
        } else if (s[(i + j) % len] == "]" && top == "[") {
          stack.pop();
        } else if (s[(i + j) % len] == "}" && top == "{") {
          stack.pop();
        } else {
          isToggle = false;
          break;
        }
      }
    }
    if (isToggle && stack.length === 0) {
      answer++;
    }
  }
  return answer;
}
