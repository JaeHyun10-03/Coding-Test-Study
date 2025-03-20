// 백준 예제 입력을 위한 코드
const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .split("\n");
const newNum = +input[2]; // -1 자리에 들어갈 새로운 숫자
const arr = input[1].split(" ").map(Number); // -1을 포함한 기존 배열

//
arr[arr.indexOf(-1)] = newNum;

arr.sort((a, b) => a - b);

const tree = [];

const max = Math.log(arr.length + 1) / Math.log(2);
let [end, parentIndex] = [arr.length - 1, (arr.length - 1) * 2];
for (let level = 0; level < max; level++) {
  let cnt = 0;

  while (cnt < 2 ** level) {
    cnt === 0 ? tree.push(arr[Math.floor(end / 2)]) : tree.push(arr[Math.floor(end / 2) + (Math.floor(parentIndex / 2) + 1) * cnt]);
    if (++cnt === 2 ** level) {
      end = Math.floor(end / 2);
      parentIndex = Math.floor(parentIndex / 2);
    }
  }
}

// 후위 순회 재귀 함수
function postorder(tree, idx) {
  const result = [];
  if (idx < tree.length) {
    // 왼쪽 자식 노드 방문
    result.push(...postorder(tree, 2 * idx + 1));
    // 오른쪽 자식 노드 방문
    result.push(...postorder(tree, 2 * idx + 2));
    // 현재 노드 방문
    result.push(tree[idx]);
  }
  return result;
}

const postorderResult = postorder(tree, 0).join(" ");
console.log(postorderResult);
