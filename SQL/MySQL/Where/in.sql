SELECT EMPNO,ENAME,COMM
FROM EMP
WHERE COMM IN (300,500,1400); /* IN은 특정값 중에 하나인지 확인할때 사용되며 () 안에 나열된 것들이 대상이다 */