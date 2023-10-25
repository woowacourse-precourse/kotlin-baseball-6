# 기능 목록

## View
- JudgmentView
  - 판정 출력하는 파일
- NoticeView
  - 안내문을 출력하는 파일
- UserInputView
  - 사용자에게 입력 받는 파일

## Controller
- BaseballController
  - 야구를 진행할때 필요한 기능을 구현한 파일
- BaseballGame
  - 게임의 전체적인 진행을 실행하는 기능을 구현한 파일 

## Model
 - TargetNumbersModel
   - 목푶 숫자를 저장하는 모델 
 - TargetNumbersGenerator
    - 목표 숫자를 생성하는 모델 
 - RetryNumberGenerator
   - 다시 시작할지 여부의 숫자를 입력 받아 검사하고 변환하여 생성하는 모델
 - RetryNumberModel
   - 다시 시작할지 여부의 숫자를 저장하는 모델
 - UserNumbersGenerator
   - 사용자의 숫자를 입력받아 검사하고 변환하여 생성하는 모델
 - UserNumbersModel
   - 사용자의 숫자를 입력받아 저장하는 모델
 - NumberGenerator
   - 숫자를 생성하는 Interface
 - NumbersGenerator
   - 숫자들을 생성하는 Interface