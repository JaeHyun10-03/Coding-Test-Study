function solution(citations) {
    const sortedArray = citations.sort((a,b)=>b-a);
    for(let i=0; i<sortedArray.length; i++){
        if(i+1 == sortedArray[i]){
            return i+1
        }else if(i+1 > sortedArray[i]){
            return i
        }
    }
    return sortedArray.length;
}