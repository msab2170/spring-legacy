# spring-legacy
신입 개발자 과제

개발환경 
spring legacy

STS
mybatis
postgreSQL




요구사항


1. DB 및 테이블 생성 스크립트는 확장자 sql로 별도 저장

2. 파일 업로드를 할 수 있는 html 페이지가 필요

3. 해당 html 페이지에서 form submit을 통해 파일 업로드 가능해야 함

4. 업로드가 가능한 파일의 확장자는 dbfile 이어야 함(이외 확장자는 모두 에러처리)

5. 서버는 업로드된 dbfile을 읽어 DB 테이블에 저장

6. 파일의 특정 라인에서 에러가 발생하는 경우 중단하지 않고 다음 라인을 처리

7. 응답페이지 항목
전체 성공
레코드건수 + 건 입력 성공
조회버튼
전체/일부 실패
성공 XX건 , 실패 XX건
실패한 라인번호와 텍스트 

8. 성공시 표시되는 조회버튼을 클릭하면 서버로 Ajax 요청

9. 위 요청에 서버는 DB 테이블 조회결과를 json 포맷로 응답

10. json 응답 데이터를 아래의 표 형태로 보여줌


1차 과제 결과물 

![1](https://user-images.githubusercontent.com/115135514/209067944-e4fcc48b-9bb7-40c7-8379-7ce18008a6ea.PNG)
![2](https://user-images.githubusercontent.com/115135514/209067957-4ba74f4a-8842-4c43-a50c-aa489eaf6641.PNG)

case.1 - 성공시
![3](https://user-images.githubusercontent.com/115135514/209067969-ea2fc05b-9874-43b6-90f6-a05c9b82730e.PNG)

case.1 - 실패시(일부 또는 전체)
![4](https://user-images.githubusercontent.com/115135514/209068017-5885feba-2ce2-48a5-bdd9-8e4ede9f3b25.PNG)
