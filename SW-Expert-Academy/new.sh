#!/usr/bin/env bash
# 새 문제 폴더 생성
# 사용: ./new.sh <폴더경로> <문제번호> <제목> <난이도>   (순서 번호 자동: 마지막+1)
# 예시: ./new.sh Phase1_구현-시뮬레이션 1873 상호의배틀필드 D3
set -euo pipefail
cd "$(dirname "$0")"

if [ $# -lt 4 ]; then
  echo "사용: ./new.sh <폴더경로> <문제번호> <제목> <난이도>" >&2
  exit 1
fi

parent="$1"; num="$2"; title="$3"; level="$4"

if ls -d "$parent"/[0-9][0-9]_"${num}"_* >/dev/null 2>&1; then
  echo "이미 존재: $(ls -d "$parent"/[0-9][0-9]_"${num}"_*)" >&2
  exit 1
fi

# 순서 번호: 해당 폴더의 마지막 번호 + 1 (풀이 순서 = 폴더 정렬 순서)
mkdir -p "$parent"
last=$(ls -1 "$parent" | grep -E '^[0-9]{2}_' | sort | tail -1 | cut -c1-2)
order=$(printf '%02d' $(( 10#${last:-00} + 1 )))
dir="$parent/${order}_${num}_${title}"

mkdir -p "$dir"
sed -e "s/{{NUM}}/$num/g" -e "s/{{TITLE}}/$title/g" -e "s/{{LEVEL}}/$level/g" \
  _template/Solution.java > "$dir/Solution.java"
: > "$dir/input.txt"
: > "$dir/output.txt"
echo "생성: $dir"
