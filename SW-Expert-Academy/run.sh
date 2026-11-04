#!/usr/bin/env bash
# 문제 실행 + 정답 비교
# 사용: ./run.sh <문제번호>        (어느 위치에서 실행해도 됨)
#       ./run.sh                   (현재 폴더의 Solution.java 실행)
set -uo pipefail
root="$(cd "$(dirname "$0")" && pwd)"

if [ $# -ge 1 ]; then
  dir="$(find "$root" -type d -name "[0-9][0-9]_$1_*" -not -path '*/_template*' | head -1)"
  if [ -z "$dir" ]; then
    echo "문제 폴더 없음: $1" >&2
    exit 1
  fi
else
  dir="$(pwd)"
fi

cd "$dir" || exit 1
if [ ! -s input.txt ]; then
  echo "input.txt 가 비어 있음. SWEA에서 입력 예제를 붙여넣기." >&2
  exit 1
fi

actual="$(mktemp)"
trap 'rm -f "$actual"' EXIT

start=$(perl -MTime::HiRes=time -e 'printf "%d", time*1000')
java Solution.java < input.txt > "$actual"
code=$?
end=$(perl -MTime::HiRes=time -e 'printf "%d", time*1000')
ms=$(( end - start ))

if [ $code -ne 0 ]; then
  echo "런타임 에러 (exit $code)"
  exit $code
fi

if [ ! -s output.txt ]; then
  cat "$actual"
  echo "--- output.txt 비어 있어 비교 생략 (${ms}ms, JVM 기동 포함)"
  exit 0
fi

if diff -w "$actual" output.txt > /dev/null; then
  echo "PASS (${ms}ms, JVM 기동 포함)"
else
  echo "FAIL — 왼쪽: 내 출력 / 오른쪽: 정답"
  diff -w "$actual" output.txt | head -20
  exit 1
fi
