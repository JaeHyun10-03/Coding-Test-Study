class Node {
  constructor(nodeinfo, left = null, right = null) {
    this.info = nodeinfo; // 노드 좌표
    this.left = left; // 노드 왼쪽자식
    this.right = right; // 노드 오른쪽자식
  }
  hasLeft() {
    return this.left !== null;
  }
  hasRight() {
    return this.right !== null;
  }
}

function makeBT(nodeinfo) {
  [
    [x, y, idx],
    [x, y, idx],
    [x, y],
    [x, y],
    [x, y],
    [x, y],
  ];
  // 1. nodeinfo의 인덱스를 push 해준다. -> [x, y, idx] 형태로 nodeinfo를 저장
  for (const i in nodeinfo) {
    nodeinfo[i].push(parseInt(i) + 1);
  }
  // 2. nodeinfo를 y값 기준으로 내림차순 정렬 + y값이 같을 경우 x가 작은 수 먼저오게 정렬
  nodeinfo.sort((a, b) => b[1] - a[1] || a[0] - b[0]);

  // 3. 트리 형태로 저장
  let root = null;
  for (let i = 0; i < nodeinfo.length; i++) {
    // 루트가 null일 때
    if (!root) {
      root = new Node(nodeinfo[i]);
    } else {
      // 루트가 null이 아닐 때
      let parent = root;
      const newNode = new Node(nodeinfo[i]);
      while (true) {
        // newNode의 x좌표 < parent의 x 좌표
        if (newNode.info[0] < parent.info[0]) {
          // 왼쪽 자식에 이미 값이 있다면 : 부모 포인터만 넘겨줌
          if (parent.hasLeft()) {
            parent = parent.left;
            continue;
          }
          parent.left = newNode;
          break;
        } else {
          // parent의 x좌표 < newNode의 x좌표
          // 오른쪽 자식에 이미 값이 있다면 : 부모 포인터만 넘겨줌
          if (parent.hasRight()) {
            parent = parent.right;
            continue;
          }
          parent.right = newNode;
          break;
        }
      }
    }
  }
  return root;
}

function 전위순회함수(root, answer) {
  if (root === null) return;
  answer[0].push(root.info[2]);
  전위순회함수(root.left, answer);
  전위순회함수(root.right, answer);
}

function 후위순회함수(root, answer) {
  if (root === null) return;
  후위순회함수(root.left, answer);
  후위순회함수(root.right, answer);
  answer[1].push(root.info[2]);
}

function solution(nodeinfo) {
  const answer = [[], []];
  const root = makeBT(nodeinfo);
  전위순회함수(root, answer);
  후위순회함수(root, answer);
  return answer;
}

/*
  1. 각 노드마다 숫자를 알기 위해선 nodeinfo의 인덱스를 알아야한다. 
      1. 따라서 nodeinfo 인덱스를 [x,y, idx] 형태로 재가공한다.
  2. 재가공한 nodeinfo 배열을 y를 기준으로 내림차순 정렬을 한다.
  3. 정렬된 nodeinfo 배열을 트리 형태로 생성한다.
  4. 생성된 트리를 순회하며 결과값을 배열에 담는다.
  */
