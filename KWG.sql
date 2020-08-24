create table jdbc_board(
    board_no number not null,           --글번호(자동증가) -- seq_board 시퀀스 이용
    board_title varchar2(100) not null, --글제목
    board_writer varchar2(50) not null, --작성자
    board_content clob,                 --내용
    board_date date not null,           --작성날짜
    board_cnt number not null,          --조회수
    constraint pk_jdbc_board primary key(board_no)
);

--시퀀스 만들기
create sequence seq_board
start with 1      --시작값
increment by 1;  --증가값

-- DB테이블의 컬럼명을 Java의 VO객체의 멤버변수로 변환하기
select 'private ' || 
        decode((lower(data_type), 'number', 'int ', 'String ")