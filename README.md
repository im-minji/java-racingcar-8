# java-racingcar-precourse

## 자동차 경주: 기능 목록

### 1. 자동차 이름 입력 및 Car 객체 생성

- "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)" 문구 출력


- 사용자로부터 자동차 이름들을 쉼표(,) 기준으로 입력 받기


- Car 클래스 생성 (private 필드: name, position)


- Car 생성 시, 이름이 5자 이하인지 검증 (초과 시 IllegalArgumentException)


- Car 생성 시, 이름이 공백이 아닌지 검증 (공백 시 IllegalArgumentException)


- 입력받은 이름들로 List<Car> 객체 리스트 생성 및 반환



### 2. 시도할 횟수 입력 및 유효성 검증

- "시도할 횟수는 몇 회인가요?" 문구 출력


- 사용자로부터 시도할 횟수 입력 받기


- 입력값이 숫자인지 검증 (아닐 시 IllegalArgumentException)


- 입력값이 1 이상의 양수인지 검증 (아닐 시 IllegalArgumentException)



### 3. 각 시도별 레이싱 실행 및 현재 상태 출력

- Car 클래스에 move 메서드 생성 (랜덤 값이 4 이상일 경우 position 1 증가: Randoms 라이브러리 활용) 


- Car 클래스에 printResult 메서드 추가 (현재 이름과 position을 '-'로 출력)


- 입력받은 시도 횟수(tryCount)만큼 루프 실행


- 각 루프마다 모든 Car 객체의 move 메서드 호출


- 각 루프마다 모든 Car 객체의 printResult 메서드 호출


- 각 루프(시도)가 끝날 때마다 공백 라인 출력



### 4. 최종 우승자 판별 및 출력

- 우승자 판별 책임을 가진 WinnerFinder 클래스 생성


- WinnerFinder에 private 필드 추가 (자동차 리스트, 최대 점수, 우승자 이름 리스트)


- WinnerFinder 생성 시, 자동차 리스트를 받아 필드 초기화


- Car 클래스에 maxScore 비교를 위한 메서드 구현


- WinnerFinder에 findMaxScore 메서드 구현 


- Car 클래스에 addNameToListIfWinner 메서드 구현 


- WinnerFinder에 findWinner 메서드 구현 


- WinnerFinder에 최종 우승자 리스트를 반환하는 getWinners 메서드 추가 (캡슐화를 위해 getter 사용)


- main에서 WinnerFinder를 생성 및 실행


- String.join API를 사용하여 최종 우승자 목록을 형식에 맞게 출력



### 5. test: 단위 테스트 코드 작성

- Car 객체 생성 시 이름 검증 (5자 초과, 공백) 테스트


- Car 객체 move 메서드 전진/정지 기능 테스트


- WinnerFinder 단독 우승자 판별 기능 테스트


- WinnerFinder 공동 우승자 판별 기능 테스트


- 시도 횟수 유효성 검증(숫자, 0 이하) 테스트