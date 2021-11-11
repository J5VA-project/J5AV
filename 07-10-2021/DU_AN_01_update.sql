create database du_an_01
go
use du_an_01

drop database du_an_01

go
create table dbo.customer
(
username_custo varchar(50) primary key,
password varchar(50) not null,
fullName varchar(100) not null,
phone_No varchar(15),
address nvarchar(255),
email varchar(100) not null,
image varchar(255)
)

go
create table dbo.account
(
username varchar(50) primary key,
password varchar(50) not null,
fullname nvarchar(100),
email varchar(100),
address nvarchar(250),
phone varchar(15),
hire_date date not null,
salary money not null,
gender bit,
birthdate date,
image varchar(255)
)

go
create table dbo.role
(
role_id int primary key identity(1,1),
role_name nvarchar(100) not null
)
go
create table dbo.authorized
(
authorized_id int primary key identity(1,1),
username varchar(50) not null,
role_id int not null
)
go
create table dbo.size
(
size_id int primary key identity(1,1),
name nvarchar(30) not null
)
go
create table dbo.foodCategory
(
foodCategory_id int primary key identity(1,1),
foodCategory_name nvarchar(100) not null,
description nvarchar(255) not null
)

go
create table dbo.food
(
food_id int primary key identity(1,1),
food_name nvarchar(255) not null,
price money not null,
photo varchar(255)
)
go
create table dbo.favorite
(
favorite_id int primary key identity(1,1),
food_id int not null,
username_custo varchar(50) not null
)
go
create table dbo.foodDetail
(
food_id int primary key identity(1,1),
category_id int not null,
status bit not null,
description nvarchar(255),
size_id int not null,
image_title1 varchar(255),
image_title2 varchar(255)
)

go
create table dbo.orders
(
order_id int primary key identity(1,1),
username varchar(50) not null,
username_custo varchar(50) not null,
orderDate date not null,
discount int,
status int not null,
address nvarchar(255) not null
)
go
create table dbo.orderDetail
(
orderDetail_id int primary key identity(1,1),
order_id int not null,
food_id int not null,
quantity int not null,
price money
)

alter table dbo.authorized
add constraint fk_au_role
foreign key (role_id)
references dbo.role(role_id)

alter table dbo.authorized
add constraint fk_au_acc
foreign key(username)
references dbo.account(username)

alter table dbo.foodDetail
add constraint fk_fd_fc
foreign key ( category_id)
references dbo.foodCategory(FoodCategory_id)

alter table dbo.foodDetail
add constraint fk_fd_f
foreign key(food_id)
references dbo.food(food_id)

alter table dbo.foodDetail
add constraint fk_fd_size
foreign key(size_id)
references dbo.size(size_id)

alter table dbo.orderDetail
add constraint fk_orD_Od
foreign key (order_id)
references dbo.orders(order_id)

alter table dbo.orderDetail
add constraint fk_orD_F
foreign key (food_id)
references dbo.food(food_id)

alter table dbo.orders
add constraint fk_orD_Acc
foreign key (username)
references dbo.Account(username)

alter table dbo.orders
add constraint fk_orD_Cus
foreign key (username_custo)
references dbo.customer(username_custo)

alter table dbo.favorite
add constraint fk_fav_f
foreign key ( food_id)
references dbo.food(food_id)

alter table dbo.favorite
add constraint fk_fav_cus
foreign key (username_custo)
references dbo.customer(username_custo)


----
--dbo.size
SET IDENTITY_INSERT dbo.size ON
insert into dbo.size (size_id, name) values
('1','small'),
('2','medium'),
('3','large')
SET IDENTITY_INSERT dbo.size OFF
--dbo.foodCategory
SET IDENTITY_INSERT dbo.foodCategory ON
insert into dbo.foodCategory (foodCategory_id, foodCategory_name, description) values
('1','Dishes','no'),
('2','Nuts & Green','no'),
('3','Smoothies','no'),
('4','Vegetables','no'),
('5','Takeaway Pack','no'),
('6','Fresh Fruits','no')
SET IDENTITY_INSERT dbo.foodCategory OFF
--dbo.food
SET IDENTITY_INSERT dbo.food ON
insert into dbo.food (food_id, food_name, price, photo) values
('1','Chicken In Teriyaki','22.35','feature-item-1.jpg'),
('2','Hotdog With Sausage','30.35','feature-item-2.jpg'),
('3','Breakfast With Sweet','52.35','feature-item-3.jpg'),
('4','Grilled Chicken Stick','25.35','feature-item-4.jpg'),
('5','Chicken Barista platter','32.35','feature-item-5.jpg'),
('6','French Fries Pack','15.35','feature-item-6.jpg')
SET IDENTITY_INSERT dbo.food OFF
--dbo.foodDetail
SET IDENTITY_INSERT dbo.foodDetail ON
insert into dbo.foodDetail (food_id, category_id, status, description, size_id, image_title1, image_title2) values
('1','1','1','no','1','feature-item-1.jpg','feature-item-1.jpg'),
('2','1','1','no','2','feature-item-2.jpg','feature-item-2.jpg'),
('3','4','1','no','1','feature-item-3.jpg','feature-item-3.jpg'),
('4','5','1','no','2','feature-item-4.jpg','feature-item-4.jpg'),
('5','2','1','no','3','feature-item-5.jpg','feature-item-5.jpg'),
('6','5','1','no','3','feature-item-6.jpg','feature-item-6.jpg')
SET IDENTITY_INSERT dbo.foodDetail OFF
--dbo.customer

insert into dbo.customer (username_custo, password, fullName, phone_No, address, email, image) values
('vuongnm','123','Nguyen Minh Vuong','0375578181','Phan Thiet','vuongnm@gmail.com','photo.jpg'),
('dathx','123','Hoang Xuan Dat','0375578182','Dak Lak','dathx@gmail.com','photo.jpg'),
('phucvh','123','Vu Hoang Phuc','0375578183','Dong Thap','phucvh@gmail.com','photo.jpg'),
('phuocqd','123','Quach Diem Phuoc','0375578184','TP.HCM','phuocqd@gmail.com','photo.jpg'),
('ngocnt','123','Nguyen Thi Ngoc','0375578185','Quang Nam','ngocnt@gmail.com','photo.jpg'),
('phuongtt','123','Tran Thi Phuong','0375578186','Da Nang','phuongtt@gmail.com','photo.jpg'),
('liemnv','123','Nguyen Van Liem','0375578187','Quang Ngai','liemnv@gmail.com','photo.jpg'),
('chinhnv','123','Nguyen Van Chinh','0375578188','Hue','chinhnv@gmail.com','photo.jpg')

--dbo.favorite
SET IDENTITY_INSERT dbo.favorite ON
insert into dbo.favorite(favorite_id, food_id, username_custo) values
('1','1','vuongnm'),
('2','1','dathx'),
('3','2','vuongnm'),
('4','3','vuongnm')
SET IDENTITY_INSERT dbo.favorite OFF
--dbo.account
insert into dbo.account (username, password, fullname, email, address, phone, hire_date, salary, gender, birthdate, image) values
('nv01','cannv','123','Nguyen Van Can','cannv@gmail.com','0375578190','2017/05/05','2500','1','1999/05/15','photo.jpg'),
('nv02','liempv','123','Pham Van Kiem','liempv@gmail.com','0375578191','2017/05/05','2700','1','1998/04/25','photo.jpg'),
('nv03','liemtv','123','Tran Van Liem','liemtv@gmail.com','0375578192','2017/05/05','2300','1','1997/03/05','photo.jpg'),
('nv04','chinhhv','123','Huynh Van Chinh','chinhhv@gmail.com','0375578193','2017/05/05','2200','1','1999/07/23','photo.jpg')

--dbo.role
SET IDENTITY_INSERT dbo.role ON
insert into dbo.role (role_id, role_name) values
('1','Manager'),
('2','Staff'),
('3','Boss'),
('4','Chef')
SET IDENTITY_INSERT dbo.role OFF
--dbo.authorized
SET IDENTITY_INSERT dbo.authorized ON
insert into dbo.authorized (authorized_id, username, role_id) values
('1','nv01','1'),
('2','nv02','2'),
('3','nv03','3'),
('4','nv04','4')
SET IDENTITY_INSERT dbo.authorized OFF
--dbo.orders
SET IDENTITY_INSERT dbo.orders ON
insert into dbo.orders (order_id, username, username_custo, orderDate, discount, status, address) values
('1','nv02','vuongnm','2021/09/29','10','1','HCM'),
('2','nv02','dathx','2021/09/29','10','1','HCM'),
('3','nv02','phuocqd','2021/09/29','5','1','HCM'),
('4','nv02','phucvh','2021/09/29','10','1','HCM'),
('5','nv02','vuongnm','2021/09/29','20','1','HCM')
SET IDENTITY_INSERT dbo.orders OFF
--dbo.orderDetail
SET IDENTITY_INSERT dbo.orderDetail ON
insert into dbo.orderDetail (orderDetail_id, order_id, food_id, quantity, price) values
('1','1','1','1','22.35'),
('2','2','1','1','22.35'),
('3','3','2','1','30.35'),
('4','4','2','1','30.35'),
('5','5','3','1','52.35')
SET IDENTITY_INSERT dbo.orderDetail OFF


