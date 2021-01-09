#### Jsp 모델2 블로그 프로젝트 


## 오라클 12C 사용자 생성
```sql
alter session set "_ORACLE_SCRIPT"=true;  
CREATE USER cos IDENTIFIED BY bitc5600;

GRANT CREATE SESSION TO cos;
GRANT CREATE TABLESPACE TO cos;
GRANT CREATE TABLE TO cos;
GRANT CREATE SEQUENCE TO cos;
alter user cos default tablespace users quota unlimited on users;
```

## 테이블
```sql
CREATE TABLE users(
	id number primary key,
    username varchar2(100) not null unique,
    password varchar2(100) not null,
    email varchar2(100) not null,
    address varchar2(100) not null,
    userProfile varchar2(200),
    userRole varchar2(20),
    createDate timestamp
) ;

CREATE TABLE board(
	id number primary key,
    userId number,
    title varchar2(100) not null,
    content clob,
    readCount number default 0,
    createDate timestamp,
    foreign key (userId) references users (id)
);

CREATE TABLE reply(
	id number primary key,
    userId number,
    boardId number,
    content varchar2(300) not null,
    createDate timestamp,
    foreign key (userId) references users (id) on delete set null,
    foreign key (boardId) references board (id) on delete cascade
);
```

## 스크린샷
![image](https://user-images.githubusercontent.com/59795407/94826373-36486980-0442-11eb-9168-4bb9145f4896.png)
![image](https://user-images.githubusercontent.com/59795407/94826396-3ba5b400-0442-11eb-9dc1-1bb9713b87d0.png)
![image](https://user-images.githubusercontent.com/59795407/94826411-4102fe80-0442-11eb-8e93-e6d09e2e7b8a.png)
![image](https://user-images.githubusercontent.com/59795407/94826446-47917600-0442-11eb-8cbc-799ad14be04c.png)
![image](https://user-images.githubusercontent.com/59795407/94826469-4d875700-0442-11eb-8aa3-7b22ba3ec610.png)
![image](https://user-images.githubusercontent.com/59795407/94826497-5415ce80-0442-11eb-87f3-ed9478af630f.png)
![image](https://user-images.githubusercontent.com/59795407/94826518-5a0baf80-0442-11eb-937c-2b07b5510fd3.png)
![image](https://user-images.githubusercontent.com/59795407/94826535-5f68fa00-0442-11eb-99bb-94545364ac87.png)
![image](https://user-images.githubusercontent.com/59795407/94826560-65f77180-0442-11eb-8bb1-d3b384c6793b.png)
![image](https://user-images.githubusercontent.com/59795407/94826579-6abc2580-0442-11eb-9f06-f3733210f6d5.png)
![image](https://user-images.githubusercontent.com/59795407/94826601-70197000-0442-11eb-9014-db174bb387af.png)
![image](https://user-images.githubusercontent.com/59795407/94826617-77d91480-0442-11eb-9967-52db3e84f409.png)
![image](https://user-images.githubusercontent.com/59795407/94826633-7c9dc880-0442-11eb-965b-3ee468d48661.png)
![image](https://user-images.githubusercontent.com/59795407/94826649-81fb1300-0442-11eb-9053-5a44c10167a0.png)
![image](https://user-images.githubusercontent.com/59795407/94826671-87585d80-0442-11eb-8d28-4d964e90c13a.png)
![image](https://user-images.githubusercontent.com/59795407/94826711-8de6d500-0442-11eb-99cf-ec5d7f3731a6.png)
![image](https://user-images.githubusercontent.com/59795407/94826729-93dcb600-0442-11eb-9b04-bfee6494878e.png)
![image](https://user-images.githubusercontent.com/59795407/94826746-98a16a00-0442-11eb-931e-ff99f55a2f44.png)
![image](https://user-images.githubusercontent.com/59795407/94826767-9dfeb480-0442-11eb-9bfd-fd386ee76497.png)
![image](https://user-images.githubusercontent.com/59795407/94826786-a35bff00-0442-11eb-8c10-66c142c94e3b.png)
