--��ü ���ڵ�� : 102��
-- �� ȭ�鿡 ������ ���ڵ� �� : 10��
-- ������ �ϴ� page : 4������  
-- ���۹�ȣ : 31��, ����ȣ : 40��
select * from mymember;

select * from(
    select A.*, rownum as RNUM
        from ( -- �� �κп� ���ǰ� ������ ó���Ѵ�.
        select * from mymember order by mem_id 
        ) A
        where rownum <= 40  --����ȣ ����
    )
    where rnum>30;   -- ���۹�ȣ ����
    
--------------------------------------------------
create table student(
    std_name varchar2(30) not null,
    std_kor Number(3) not null,
    std_eng Number(3) not null,
    std_mat Number(3) not null,
    Constraint std_pk primary key(std_name)
);

select * from student;
insert into student (std_name, STD_KOR, std_eng, std_mat) values ('����', 90, 90, 90);

select * from student;

commit;