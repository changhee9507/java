/*
SELECT DEPTNO,AVG(SAL)
FROM EMP
WHERE AVG(SAL) >= 2000;
GROUP BY DEPTNO;

위 코드가 에러가 나는 이유는
함수의 결과에 대해서는 WHERE을 적용해서 WHERE을 이용할 수 없기 때문이다
DEPTNO를 기준으로 묶은 다음 그 평균이 2000 이상인 것만 선택하기 위해서는
HAVING이라는 키워드를 사용해준다.


SELECT DEPTNO,AVG(SAL)
FROM EMP
WHERE SAL >= 1000
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000;
이렇게 HAVING과 WHERE을 섞을수도 있지만 이경우에 WHERE은 엔티티에 조건을 거는 것이고
HAVING은 AVG결과에 대한 조건을 거는 것이다.
*/

SELECT DEPTNO,AVG(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING AVG(SAL) >= 2000;