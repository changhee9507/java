/* Cartesian product */

/* 두 테이블을 단순하게 반복하면서 합친다. 
	그래서 테이블의 크기가 굉장히 커진다.
    
	첫번째 속성이 A개 두번째 속성이 B개 였다면
    결과는 A*B개가 된다. */

SELECT EMP.ENAME,DEPT.DNAME
FROM EMP,DEPT