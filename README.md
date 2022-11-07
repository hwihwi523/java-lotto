# 로또

## 기능 목록

### 문자열 계산기
* 사칙연산
  - 입력 값에 따라 계산 순서 결정 (사칙연산 계산 우선순위 X)  
    - ex) 2 + 3 * 4 / 2 = 10
* 사용자 입력
  - 문자열 입력 받음
  - 문자열 형식 체크 : 숫자 + 빈 공백 문자열 + 숫자
    - ex) 2 + 3 * 4 / 2

<br><br><br>

### 로또

로또
* 6개의 숫자 목록
  - 중복 불가
  - 1~ 31 사이의 램덤값
  - 정렬
  - 일치 여부

숫자 전략 패턴

랜덤 전략 패턴
* 1 ~ 31 사이의 랜덤값

구입
* 구입 금액에 맞는 로또 리스트 생성
* 로또 한장 금액 1000원

당청 통계
* 번호 개수별 당첨 로또 개수
* 수익률 계산

사용자 입력
* 구입 금액 입력
  - 널 체크, 숫자 여부 체크




## 프로그래밍 요구사항
* indent(들여쓰기) depth를 2단계에서 1단계로 줄여라. 
  -depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다. 
* 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
  - method가 한 가지 일만 하도록 최대한 작게 만들어라.
* else를 사용하지 마라.