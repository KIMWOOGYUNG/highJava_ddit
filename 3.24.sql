--전체 레코드수 : 102개
-- 한 화면에 보여줄 레코드 수 : 10개
-- 보려고 하는 page : 4페이지  
-- 시작번호 : 31번, 끝번호 : 40번
select * from mymember;

select * from(
    select A.*, rownum as RNUM
        from ( -- 이 부분에 조건과 정렬을 처리한다.
        select * from mymember order by mem_id 
        ) A
        where rownum <= 40  --끝번호 지정
    )
    where rnum>30;   -- 시작번호 지정
    
--------------------------------------------------
create table student(
    std_name varchar2(30) not null,
    std_kor Number(3) not null,
    std_eng Number(3) not null,
    std_mat Number(3) not null,
    Constraint std_pk primary key(std_name)
);

select * from student;
insert into student (std_name, STD_KOR, std_eng, std_mat) values ('김우경', 90, 90, 90);

select * from student;

commit;