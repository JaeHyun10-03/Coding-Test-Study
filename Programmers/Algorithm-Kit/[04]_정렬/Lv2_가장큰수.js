function solution(numbers) {
  const array = numbers
    .map(String)
    .sort((a, b) => (b + a).localeCompare(a + b))
    .join("");
  return array[0] === "0" ? "0" : array;
}
