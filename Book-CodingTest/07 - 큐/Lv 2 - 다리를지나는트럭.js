function solution(bridge_length, weight, truck_weights) {
  let time = 0;
  const bridge = new Array(bridge_length).fill(0);
  let bridgeWeight = 0;

  while (truck_weights > 0 || bridge.length > 0) {
    time++;
    bridgeWeight -= bridge.shift(); //
    // 대기 트럭이 있다면
    if (truck_weights.length > 0) {
      // 현재 다리에 여유가 있다면 -> 트럭을 넣어줌
      if (truck_weights[0] + bridgeWeight <= weight) {
        const truck = truck_weights.shift();
        bridgeWeight += truck;
        bridge.push(truck);
      } else {
        bridge.push(0); // 현재 다리에 여유가 없다면 -> 0을 넣어줌
      }
    }
  }
  return time;
}
