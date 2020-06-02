/* Subquery */

/*
서브쿼리는 select문을 ()안에 넣어서 만들 수 있다.
*/

SELECT DNAME 
FROM DEPT
WHERE DEPTNO = (SELECT DEPTNO FROM EMP WHERE ENAME = 'JONES');

/*
from에 테이블 대신으로도 사용할 수 있다. 
*/

SELECT E.ENAME,D.DNAME
FROM EMP E,
(
    SELECT DEPTNO,DNAME
    FROM DEPT
    WHERE DEPTNO = 10
) D
WHERE E.DEPTNO = D.DEPTNO;