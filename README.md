# java-racingcar-precourse

## 자동차 경주: 기능 목록
&nbsp;
### 1. 자동차 이름 입력 및 Car 객체 생성

- [x]  "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)" 문구 출력  


- [x]  사용자로부터 자동차 이름들을 쉼표(,) 기준으로 입력 받기 


- [x]  Car 클래스 생성 (private 필드: name, position) 


- [x]  Car 생성 시, 이름이 5자 이하인지 검증 (초과 시 IllegalArgumentException) 


- [x]  Car 생성 시, 이름이 공백이 아닌지 검증 (공백 시 IllegalArgumentException) 


- [x]  입력받은 이름들로 List<Car> 객체 리스트 생성 및 반환 

&nbsp;

### 2. 시도할 횟수 입력 및 유효성 검증

- [x]  "시도할 횟수는 몇 회인가요?" 문구 출력


- [x]  사용자로부터 시도할 횟수 입력 받기


- [x]  입력값이 숫자인지 검증 (아닐 시 IllegalArgumentException)


- [x]  입력값이 1 이상의 양수인지 검증 (아닐 시 IllegalArgumentException)

&nbsp;

### 3. 각 시도별 레이싱 실행 및 현재 상태 출력

- [x]  Car 클래스에 move 메서드 생성 (랜덤 값이 4 이상일 경우 position 1 증가: Randoms 라이브러리 활용) 


- [x]  Car 클래스에 printResult 메서드 추가 (현재 이름과 position을 '-'로 출력)


- [x]  입력받은 시도 횟수(tryCount)만큼 루프 실행


- [x]  각 루프마다 모든 Car 객체의 move 메서드 호출


- [x]  각 루프마다 모든 Car 객체의 printResult 메서드 호출


- [x]  각 루프(시도)가 끝날 때마다 공백 라인 출력

&nbsp;


### 4. 최종 우승자 판별 및 출력

- [x]  우승자 판별 책임을 가진 WinnerFinder 클래스 생성


- [x]  WinnerFinder에 private 필드 추가 (자동차 리스트, 최대 점수, 우승자 이름 리스트)


- [x]  WinnerFinder 생성 시, 자동차 리스트를 받아 필드 초기화


- [x]  Car 클래스에 maxScore 비교를 위한 메서드 구현


- [x]  WinnerFinder에 findMaxScore 메서드 구현 


- [x]  Car 클래스에 addNameToListIfWinner 메서드 구현 


- [x]  WinnerFinder에 findWinner 메서드 구현 


- [x]  WinnerFinder에 최종 우승자 리스트를 반환하는 getWinners 메서드 추가 (캡슐화를 위해 getter 사용)


- [x]  main에서 WinnerFinder를 생성 및 실행


- [x]  String.join API를 사용하여 최종 우승자 목록을 형식에 맞게 출력

&nbsp;

### 5. 기능 목록 작동 확인 테스트

- [x]  Car 객체 생성 시 이름 검증 (5자 초과, 공백) 테스트


- [x]  Car 객체 move 메서드 전진/정지 기능 테스트


- [x]  WinnerFinder 단독 우승자 판별 기능 테스트


- [x]  WinnerFinder 공동 우승자 판별 기능 테스트


- [x]  시도 횟수 유효성 검증(숫자, 0 이하) 테스트

&nbsp;


### 리팩토링

코드의 구조를 개선하기 위해 MVC(Model-View-Controller) 패턴을 적용

1. Model: 자동차(Car)의 상태와 핵심 로직(이동, 검증 등), 우승자 판별(WinnerFinder) 로직을 담당



2. View: 사용자 입력을 받고(InputView) 게임 결과를 출력하는(OutputView) 역할



3. Controller: RacingController가 게임의 전체 흐름을 제어하며 Model과 View를 연결



4. Application: main 메서드에서 필요한 객체를 생성하고 Controller를 실행시켜 프로그램을 시작