use newservlet;

insert into role(code,name) values('ADMIN','Quản Trị');
insert into role(code,name) values('USER','Người Dùng');

insert into user(username,password,fullname,status, roleid) values('admin','123456','admin',1,1);
insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','Nguyễn văn a',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','Nguyễn Văn b',1,2);
