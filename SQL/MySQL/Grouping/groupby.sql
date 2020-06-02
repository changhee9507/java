/*
GROUP BY는 AVG처럼 하나의 결과를 가져오는 함수와 함께쓰이면서
특정 속서을 바탕으로 묶어주는 역활을 한다. */ 
SELECT DEPTNO, AVG(SAL)
FROM EMP
GROUP BY DEPTNO;