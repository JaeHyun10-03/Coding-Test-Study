function solution(arr, query) {
  var answer = [];
  for (let i = 0; i < query.length; i++) {
    i % 2 == 0 ? (arr = arr.splice(0, query[i] + 1)) : (arr = arr.splice(query[i], arr.length));
  }
  return arr;
}
