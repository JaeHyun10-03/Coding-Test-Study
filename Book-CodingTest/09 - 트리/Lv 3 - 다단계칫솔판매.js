function solution(enroll, referral, seller, amount) {
  let parent = {};
  for (let i = 0; i < enroll.length; i++) {
    parent[enroll[i]] = referral[i];
  }
  //parent: {john: '-',mary: '-',edward: 'mary',sam: 'edward',emily: 'mary',jaimie: 'mary',tod: 'jaimie',young: 'edward'}

  let total = {};
  for (let name of enroll) {
    total[name] = 0;
  }

  //total: {john: 0,mary: 0,edward: 0,sam: 0,emily: 0,jaimie: 0,tod: 0,young: 0}
  for (let i = 0; i < seller.length; i++) {
    let money = amount[i] * 100;
    let curName = seller[i];
    while (money > 0 && curName != "-") {
      total[curName] += money - Math.floor(money / 10);
      curName = parent[curName];
      money = Math.floor(money / 10);
    }
  }
  return enroll.map((name) => total[name]);
}
