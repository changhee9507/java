/* LENGTH �Լ��� ���̸� ���� */
/* PAD�Լ��� ���ϴ� ������ ���ڿ��� ������ �� ��� */
/* SUBSTR�� ���ڿ��� Ư�� �κ��� ������ �� ��� */
SELECT EMPNO, RPAD(SUBSTR(EMPNO, 0, 2), 4, '*') AS MASKING_EMPNO, ENAME, RPAD(SUBSTR(ENAME, 0,1), LENGTH(ENAME), '*') AS MASKING_ENAME
FROM EMP
WHERE LENGTH(ENAME) = 5;