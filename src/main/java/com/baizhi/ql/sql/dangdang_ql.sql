/*==============================================================*/
/* DBMS name:      ORACLE Version 10g                           */
/* Created on:     2018/05/30 星期三 下午 8:52:02               */
/*==============================================================*/

-- drop table d_admin cascade constraints;

-- drop table d_category cascade constraints;

-- drop table d_book cascade constraints;

-- drop table d_user cascade constraints;

-- drop table d_address cascade constraints;

-- drop table d_order cascade constraints;

-- drop table d_item cascade constraints;

-- select * from d_admin;

-- select * from d_category;

--   select * from d_book;

--   select * from d_user;

--  select * from d_address;

--  select * from d_order;

--  select * from d_item;

/*==============================================================*/
/* Table: d_admin                                           */
/*==============================================================*/
create table d_admin   (
   id                  varchar(40)                    not null,
   username            varchar(40),  --用户名
   password            varchar(40),  --密码
   primary key (id)
);

insert into d_admin values ('1', 'admin','admin');		

/*==============================================================*/
/* Table: d_category                                           */
/*==============================================================*/
create table d_category  (
   id                   varchar(40)                    not null,
   cate_name            varchar(30),  --类别名
   count                NUMBER(8),     --图书数量 
   parent_id            varchar(40),  --父类别id
   levels               NUMBER(1),     --等级
   primary key (id)
);

insert into d_category values ('1', '小说', 9, '0',1);
insert into d_category values ('2', '武侠小说', 3, '1',2);
insert into d_category values ('3', '言情小说', 1, '1',2);
insert into d_category values ('4', '玄幻小说', 1, '1',2);
insert into d_category values ('5', '校园小说', 4, '1',2);
insert into d_category values ('6', '名著', 4, '0',1);
insert into d_category values ('7', '红楼梦', 1, '6',2);
insert into d_category values ('8', '西游记', 1, '6',2);
insert into d_category values ('9', '三国', 1, '6',2);
insert into d_category values ('10', '水浒传', 1, '6',2);
insert into d_category values ('11', '外语', 9, '0',1);
insert into d_category values ('12', '英语', 2, '11',2);
insert into d_category values ('13', '德语', 0, '11',2);
insert into d_category values ('14', '法语', 1, '11',2);
insert into d_category values ('15', '葡萄牙语', 1, '11',2);
insert into d_category values ('16', '汉语言', 1, '11',2);
insert into d_category values ('17', '日语', 1, '11',2);
insert into d_category values ('18', '韩语', 3, '11',2);
insert into d_category values ('19', '儿童', 0, '0',1);
insert into d_category values ('20', '0~3岁', 0, '19',2);
insert into d_category values ('21', '4~6岁', 0, '19',2);
insert into d_category values ('22', '7~12岁', 0, '19',2);
insert into d_category values ('23', '13~15岁', 0, '19',2);
insert into d_category values ('24', '16~18岁', 0, '19',2);
insert into d_category values ('25', '儿童心理学', 0, '19',2);
insert into d_category values ('26', '胎教', 0, '19',2);
insert into d_category values ('27', '计算机科学与技术', 2, '0',1);
insert into d_category values ('28', '计算机基础', 2, '27',2);
insert into d_category values ('29', 'c语言基础', 0, '27',2);
insert into d_category values ('30', '数据库', 0, '27',2);
insert into d_category values ('31', '计算机组成', 0, '27',2);
insert into d_category values ('32', '信号与系统', 0, '27',2);
insert into d_category values ('33', '数字电子线路', 0, '27',2);
insert into d_category values ('34', '模拟电子线路', 0, '27',2);

/*==============================================================*/
/* Table: d_book                                               */
/*==============================================================*/
create table d_book  (
   id                   varchar(40)                    not null,
   book_name            varchar(30),    --图书名
   author               varchar(20),    --作者
   price                NUMERIC(10, 2),  --价格
   dd_price             NUMERIC(10, 2),  --当当价
   company              varchar(40),    --出版社
   publish_time         DATE,            --出版时间
   public_count         varchar(20),    --出版字数
   isbn                 varchar(20),    --isbn编码
   print_time           DATE,            --打印时间
   print_count          varchar(20),    --打印字数
   sale_count           NUMBER(8),       --销售量
   cate_id              varchar(40),    --所属类别
   e_recommend          NUMBER(10),      --编辑推荐度
   src                  varchar(20),    --封面图片路径
   stock                NUMBER(8),       --库存
   edition              varchar(20),    --版次
   impression           varchar(20),    --印次
   format               varchar(20),    --开本
   paper                varchar(20),    --纸张
   packaging            varchar(20),    --包装
   pagination           varchar(20),    --页数
   recom                varchar(100),   --编辑推荐
   brief                varchar(100),   --内容简介
   about_author         varchar(100),   --作者简介
   directory            varchar(100),   --基本目录
   media                varchar(100),   --媒体评论
   primary key (id)
);
/*库存，版次，印次，开本，纸张，包装，页数，编辑推荐，内容简介，作者简介，基本目录，媒体评论*/

insert into d_book values ('101', '一个陌生女人的来信', '薛莹莹', '56.50', '52.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1050000', '13246523', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '10521231', '8', '2', '3', '16.jpg','999','5','4','4k','普通','硬纸','100','十分感人','一个陌生女人的来信','薛莹莹','目录信息','十分感人');
insert into d_book values ('102', '悲伤逆流成河', '刘旭', '42.50', '39.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '10534000', '1534523', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1343431', '3', '3', '5', '17.jpg','999','5','4','4k','普通','硬纸','100','十分感人','悲伤逆流成河', '刘旭','目录信息','十分感人');
insert into d_book values ('103', '老子说', '薛莹莹', '55.50', '48.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1054000', '43423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '111431', '6', '4', '5', '18.jpg','999','5','4','4k','普通','硬纸','100','十分感人','老子说', '薛莹莹','目录信息','十分感人');
insert into d_book values ('104', '达芬奇.密码', '薛莹莹', '12.50', '10.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1114000', '156323', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1385431', '0', '5', '5', '19.jpg','999','5','4','4k','普通','硬纸','100','十分感人','达芬奇.密码', '薛莹莹','目录信息','十分感人');
insert into d_book values ('105', '淘气包与马小跳', '薛莹莹', '53.50', '39.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '10534012', '3534523', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '134342', '0', '5', '5', '20.jpg','999','5','4','4k','普通','硬纸','100','淘气包与马小跳', '薛莹莹', '薛莹莹','目录信息','十分感人');
insert into d_book values ('106', '夏洛的网', '薛莹莹', '36.50', '30.50', '青春出版社', to_date('2018-08-15 11:10:52', 'yyyy-mm-dd hh24:mi:ss'), '10534321', '1204523', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '185431', '0', '5', '5', '21.jpg','999','5','4','4k','普通','硬纸','100','十分感人','夏洛的网', '薛莹莹','目录信息','十分感人');
insert into d_book values ('107', '十里桃花', '唐七', '56.50', '55.50', '青春出版社', to_date('2018-08-15 11:11:53', 'yyyy-mm-dd hh24:mi:ss'), '1053485', '19852523', to_date('2018-08-15 11:09:52', 'yyyy-mm-dd hh24:mi:ss'), '1348651', '0', '5', '5', '22.jpg','999','5','4','4k','普通','硬纸','100','十分感人','十里桃花', '唐七','目录信息','十分感人');
insert into d_book values ('108', '卢隐', '薛莹莹', '56.50', '55.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1079879000', '146515523', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1385231', '0', '14', '5', '23.jpg','999','5','4','4k','普通','硬纸','100','十分感人','卢隐', '薛莹莹','目录信息','十分感人');
insert into d_book values ('109', '全职高手', '薛莹莹', '50', '49.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1056850', '89456523', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '134398652', '0', '15', '5', '24.jpg','999','5','4','4k','普通','硬纸','100','十分感人','全职高手', '薛莹莹','目录信息','十分感人');
insert into d_book values ('110', '扶摇皇后', '薛莹莹', '33.50', '30', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '87651352', '87652', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1385621', '0', '16', '5', '2.jpg','999','5','4','4k','普通','硬纸','100','十分感人','扶摇皇后', '薛莹莹','目录信息','十分感人');
insert into d_book values ('111', '阳光城', '薛莹莹', '33', '29.50', '青春出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '865532', '98561', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '185321', '0', '17', '5', '3.jpg','999','5','4','4k','普通','硬纸','100','十分感人','阳光城', '薛莹莹','目录信息','十分感人');
insert into d_book values ('112', '小妇人', '郭敬明', '39.50', '39.50', '最小说文化出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132434', '153', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '1321', '0', '18', '5', '4.jpg','999','5','4','4k','普通','硬纸','100','十分感人','小妇人', '郭敬明','目录信息','十分感人');
insert into d_book values ('113', '简.爱', '郭敬明', '58.50', '39.50', '最小说文化出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '2', '5', '6.jpg','999','5','4','4k','普通','硬纸','100','十分感人','简.爱', '郭敬明','目录信息','十分感人');
insert into d_book values ('114', 'java培训', '郭敬明', '58.50', '39.50', '最小说文化出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '2', '5', '7.jpg','999','5','4','4k','普通','硬纸','100','十分感人','java培训', '郭敬明','目录信息','十分感人');
insert into d_book values ('115', '红楼梦', '曹雪芹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '7', '5', '8.jpg','999','5','4','4k','普通','硬纸','100','十分感人','红楼梦', '曹雪芹','目录信息','十分感人');
insert into d_book values ('116', '西游记', '吴承恩', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '8', '5', '9.jpg','999','5','4','4k','普通','硬纸','100','十分感人','西游记', '吴承恩','目录信息','十分感人');
insert into d_book values ('117', '三国', '罗贯中', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '9', '5', '16.jpg','999','5','4','4k','普通','硬纸','100','十分感人','三国', '罗贯中','目录信息','十分感人');
insert into d_book values ('118', '水浒传', '薛莹莹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '10', '5', '22.jpg','999','5','4','4k','普通','硬纸','100','十分感人','水浒传', '薛莹莹','目录信息','十分感人');
insert into d_book values ('119', '俞敏洪英语', '俞敏洪', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '12', '5', '3.jpg','999','5','4','4k','普通','硬纸','100','十分感人','俞敏洪英语', '俞敏洪','目录信息','十分感人');
insert into d_book values ('120', '完形填空', '薛莹莹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '12', '5', '8.jpg','999','5','4','4k','普通','硬纸','100','十分感人','完形填空', '薛莹莹','目录信息','十分感人');
insert into d_book values ('121', '儿童心理学', '薛莹莹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '18', '5', '22.jpg','999','5','4','4k','普通','硬纸','100','十分感人','儿童心理学', '薛莹莹','目录信息','十分感人');
insert into d_book values ('122', '孩子的成长', '薛莹莹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '18', '5', '23.jpg','999','5','4','4k','普通','硬纸','100','十分感人','孩子的成长', '薛莹莹','目录信息','十分感人');
insert into d_book values ('123', '计算机原理', '薛莹莹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '28', '5', '22.jpg','999','5','4','4k','普通','硬纸','100','十分感人','计算机原理', '薛莹莹','目录信息','十分感人');
insert into d_book values ('124', '计算机组成原理', '薛莹莹', '58.50', '39.50', '薛莹莹有限公司出版社', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '132440', '15423', to_date('2018-08-15 11:10:53', 'yyyy-mm-dd hh24:mi:ss'), '13431', '0', '28', '5', '5.jpg','999','5','4','4k','普通','硬纸','100','十分感人','计算机组成原理', '薛莹莹','目录信息','十分感人');

/*==============================================================*/
/* Table: d_user                                               */
/*==============================================================*/
create table d_user  (
   id                   varchar(40)                    not null,
   nick_name            varchar(64),  --昵称
   email                varchar(64),  --邮箱
   password             varchar(32),  --密码
   status               NUMBER(8),     --状态
   regist_time          DATE,          --注册时间
   salt                 varchar(10),  --盐
   code                 varchar(40),  --邮箱激活码
   primary key (id)
);
insert into d_user values ('111', '小可爱', '15236674712@163.com', '111111', 1, to_date('2018-06-20 11:55:52', 'yyyy-mm-dd hh24:mi:ss'),'df43','aaaaa');

/*==============================================================*/
/* Table: dd_address                                            */
/*==============================================================*/
create table d_address  (
   id                   varchar(40)                    not null,
   name                 varchar(20),  --姓名
   detail               varchar(20),  --地址
   zip_code             varchar(20),  --邮编
   phone                varchar(20),  --电话
   mobile               varchar(20),  --手机
   user_id              varchar(40),  --用户id
   primary key (id)
);

/*==============================================================*/
/* Table: dd_order                                              */
/*==============================================================*/
create table d_order  (
   id                   varchar(40)                    not null,
   order_number         varchar(30),    --订单编号
   order_times          DATE,            --订单时间
   addr_user            varchar(30),    --收货人
   addr_name            varchar(30),    --收货地址
   total_price          NUMERIC(12, 2),  --总价
   status               varchar(40),    --订单状态
   addr_id              varchar(40),    --地址id
   user_id              varchar(40),    --用户id
   primary key (id)
);
 
/*==============================================================*/
/* Table: d_item                                               */
/*==============================================================*/
create table d_item  (
   id                   varchar(40)                    not null,
   book_name            varchar(20),   --图书名
   book_src             varchar(20),   --图片路径
   price                NUMERIC(8, 2),   --价格
   count                NUMBER(8),       --数量
   amount               NUMERIC(8, 2),   --小计
   book_id              varchar(40),    --图书id
   order_id             varchar(40),    --订单id
   primary key (id)
);