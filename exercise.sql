drop table tbl_lecture;
drop table tbl_subject;
drop table tbl_teacher;
drop table tbl_department;

drop sequence seq_lecture;

create table tbl_department (
dept_code	varchar2(10)	primary key,
dept_name	varchar2(30)	not null
);

create table tbl_teacher (
t_id	varchar2(10)	primary key,
t_pass	varchar2(10)	not null,
t_name	varchar2(20)	not null,
dept_code	varchar2(10) not null,
t_addr	varchar2(50)	not null,
constraint fk_teacher_department foreign key (dept_code) references tbl_department(dept_code)
);

create table tbl_subject (
sub_id	varchar2(10)	primary key,
sub_name varchar2(30)	not null,
sub_info varchar2(100)	not null,
dept_code varchar2(10),
constraint fk_subject_department foreign key (dept_code) references tbl_department(dept_code)
);

create table tbl_lecture (
lec_num	number(5)	primary key,
t_id	varchar2(10),
sub_id	varchar2(10),
constraint fk_t_id foreign key (t_id) references tbl_teacher(t_id),
constraint fk_sub_id foreign key (sub_id) references tbl_subject(sub_id)
);

create sequence seq_lecture
start with 1
increment by 1;

insert into tbl_department
values ('d01', '�����а�');

insert into tbl_department
values ('d02', '�����а�');

insert into tbl_department
values ('d03', '����Ʈ������а�');

insert into tbl_subject
values ('sub01', 'Java', '�ڹ� �⺻ ����', 'd03');

insert into tbl_subject
values ('sub02', 'Database', '����Ŭ �����ͺ��̽�', 'd03');

insert into tbl_subject
values ('sub03', 'web', '������ JSP', 'd03');

insert into tbl_subject
values ('sub04', '����翬��', '������ ����', 'd01');

insert into tbl_subject
values ('sub05', '�������', '������ ���� ��ǰ �м�', 'd02');

commit;