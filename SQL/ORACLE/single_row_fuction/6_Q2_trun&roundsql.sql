/* TRUNC 나 ROUND 같은 함수는 오른쪽의 지정하는 숫자만큼 출력되도록 설계되어 있다. */
SELECT EMPNO, ENAME, SAL, TRUNC(SAL/(21.5), 2) AS DAY_PAY, ROUND(SAL/(21.5*8), 1) AS TIME_PAY
FROM EMP; 