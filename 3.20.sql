select * from lprod;    --���� �޺��ڽ���

select * from prod where prod_lgu = 'p301'; --������ �޺��ڽ���

select * from prod where prod_id='p301000002'; --���̺� ���

--DB���̺��� �÷�����  Java�� vo��ü�� ��������� ��ȯ�ϱ�

select 'private ' || decode(lower(data_type), 'number', 'int ', 'String ') || lower(column_name) || ';'
from cols
where lower(table_name) = 'prod';