/* TRUNC �� ROUND ���� �Լ��� �������� �����ϴ� ���ڸ�ŭ ��µǵ��� ����Ǿ� �ִ�. */
SELECT EMPNO, ENAME, SAL, TRUNC(SAL/(21.5), 2) AS DAY_PAY, ROUND(SAL/(21.5*8), 1) AS TIME_PAY
FROM EMP; 