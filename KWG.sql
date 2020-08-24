create table jdbc_board(
    board_no number not null,           --�۹�ȣ(�ڵ�����) -- seq_board ������ �̿�
    board_title varchar2(100) not null, --������
    board_writer varchar2(50) not null, --�ۼ���
    board_content clob,                 --����
    board_date date not null,           --�ۼ���¥
    board_cnt number not null,          --��ȸ��
    constraint pk_jdbc_board primary key(board_no)
);

--������ �����
create sequence seq_board
start with 1      --���۰�
increment by 1;  --������

-- DB���̺��� �÷����� Java�� VO��ü�� ��������� ��ȯ�ϱ�
select 'private ' || 
        decode((lower(data_type), 'number', 'int ', 'String ")