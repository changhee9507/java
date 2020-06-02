/*
ORDER BY는 출력 순서를 결정해주며
여러개를 두면 첫번째꺼를 기준으로 하되 같은 것은 다음의 기준을 이용한다
DESC를 이용하면 내림차순으로 만들수 있다. 

*/
SELECT EMPNO,ENAME,SAL
FROM EMP
ORDER BY SAL DESC,ENAME ASC;