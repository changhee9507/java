/* LENGTH 함수는 길이를 리턴 */
/* PAD함수는 원하는 패턴의 문자열을 생성할 때 사용 */
/* SUBSTR는 문자열의 특정 부분을 추출할 때 사용 */
SELECT EMPNO, RPAD(SUBSTR(EMPNO, 0, 2), 4, '*') AS MASKING_EMPNO, ENAME, RPAD(SUBSTR(ENAME, 0,1), LENGTH(ENAME), '*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME) = 5;