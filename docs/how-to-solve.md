### 미션 해결 전략 
#### 1. 본인이 이해하고 구현한 내용에 기반해 '다른 근무자와 순서를 바꿔야 하는 경우'를 자신만의 예시를 들어 설명하세요. (필수)       
문제의 조건에 의해, 어떠한 경우에도 같은 근무자가 이틀 연속으로 비상 근무를 수행할 수 없다.   
평일 순번과 휴일 순번이 독립적으로 존재하므로, 평일과 휴일이 맞닿는 지점(평일 -> 휴일 or 휴일 -> 평일)에서 비상 근무자가 연속으로 배정되는 경우에 다른 근무자와 순번을 바꾸어 근무해야 한다.
예를 들어,  
평일 순번: A -> B -> C -> D -> E 이고,
휴일 순번: C -> D -> E -> A -> B 일 때,
법정공휴일인 수요일에 C가 비상 근무를 수행하고, 다음 날인 목요일에는 평일 순번이 C인 경우에는, 다음 평일 근무자(D)와 순서를 바꾸어 근무해야 한다.  
따라서 최종 근무 순서는,  
A(월) -> B(화) -> C(수, 공휴일) -> D(목) -> C(금) -> D(토, 휴일), E(일, 휴일), ... 와 같다.

#### 2. 요구사항에서 제시한 앞의 날짜부터 순서를 변경하는 방법 외에 다른 방법이 있다면 어떤 방식이 있는지, 이 방법은 기존에 제시된 방식과 비교해 어떤 차이가 있는지 설명하세요. (선택)
