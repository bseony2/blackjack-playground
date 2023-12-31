## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

# 기능목록

--------------------
* 게임 진행을 위한 UI 기능
  * 사용자의 이름을 입력받아 ,로 분리한다.
  * 게임 시작 전 각 플레이어의 배팅금액을 입력 받는다.
  * 분배받은 카드를 출력한다.
  * 각 플레이어에게 추가 카드를 받을지 입력 받는다.
  * 최종 수익을 출력한다.

* 카드 지급
  * 클로버, 스페이드, 하트, 다이아몬드의 문양당 13개의 카드로 총 52개의 카드가 있다.
  * 0 ~ 51 의 난수를 입력 받아 카드를 생성한다.
  * 생성된 카드 목록을 유지하여 중복된 카드가 분배되지 않도록 한다.

* 세부 규칙
  * 게임 시작시 받은 딜러의 카드 점수합이 16 이하면 1장의 카드를 추가로 받는다.
  * 게임 시작시 받은 딜러의 카드 점수합이 17 이상이면 카드를 추가로 받을 수 없다.
  * 딜러의 카드 점수합이 21을 초과할 경우 남아있던 플레이어는 무조건 승리한다.

* 게임의 승패 
  * 각 카드를 가지고 점수를 계산한다.
  * 점수가 21 이하이며 딜러보다 점수가 높은 플레이어가 게임을 승리한다.
  * 점수가 21이 초과될 경우 무조건 패배한다.

* 게임 종료후 상금 분배
  * 게임에 이길 경우 배팅금액의 1.5배를 받는다.
  * 게임에 패배할 경우 배팅액을 잃는다.
  * 딜러와 같은 점수일 경우 배팅금액을 돌려받는다.