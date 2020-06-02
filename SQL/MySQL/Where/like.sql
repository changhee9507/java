/*
 * LIKE을 이용하면 해당 속성이 특정한 포맷을 가지는지 검색할 수 있다.
 * 'A%' => A로 시작하는 모든 문자열
 * '%A%' => A를 포함하는 모든 문자열 
 * 즉 %는 아무 문자열을 의미한다. */

SELECT EMPNO,ENAME
FROM EMP
WHERE ENAME LIKE '%T%'; 

