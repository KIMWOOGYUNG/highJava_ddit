select * from lprod;    --왼쪽 콤보박스용

select * from prod where prod_lgu = 'p301'; --오른쪽 콤보박스용

select * from prod where prod_id='p301000002'; --테이블 뷰용

--DB테이블의 컬럼명을  Java의 vo객체의 멤버변수로 변환하기

select 'private ' || decode(lower(data_type), 'number', 'int ', 'String ') || lower(column_name) || ';'
from cols
where lower(table_name) = 'prod';