function solution(want, number, discount) {
  let answer = 0;
  let wantMap = new Map();

  // want과 number를 기반으로 wantMap 설정
  for (let i = 0; i < want.length; i++) {
    wantMap.set(want[i], number[i]);
  }

  // 10일 동안의 할인 정보를 확인
  for (let i = 0; i <= discount.length - 10; i++) {
    let windowMap = new Map(wantMap);

    // 10일 동안의 제품 수량을 계산
    for (let j = 0; j < 10; j++) {
      let product = discount[i + j];
      if (windowMap.has(product)) {
        windowMap.set(product, windowMap.get(product) - 1);
        if (windowMap.get(product) === 0) {
          windowMap.delete(product);
        }
      }
    }

    // 모든 원하는 제품이 충족되었는지 확인
    if (windowMap.size === 0) {
      answer++;
    }
  }

  return answer;
}
