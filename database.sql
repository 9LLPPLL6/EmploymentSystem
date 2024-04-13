# CREATE USER 'lpl'@'%' IDENTIFIED BY '200296lpl.';
# CREATE DATABASE employment_system;
# GRANT ALL PRIVILEGES ON employment_system.* TO 'lpl'@'%';
#
# FLUSH PRIVILEGES;
use employment_system;

create table users
(
    id       int auto_increment
        primary key,
    username char(20)    null comment '用户姓名',
    password varchar(25) null comment '用户密码',
    phone    char(20)    null comment '用户手机号',
    constraint user_pk_2
        unique (id),
    constraint users_pk
        unique (phone)
);

create table pdf_url
(
    id       int auto_increment
        primary key,
    url char(100)    null comment '文件url',
    foreign_key     int          not null comment '外键',
    constraint pdf_url_pk_2
        unique (id),
    constraint pdf_url_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table club_experience_info
(
    id              int auto_increment
        primary key,
    club_name       char(10)     null comment '社团组织',
    club_start_time datetime     null comment '社团入职时间',
    club_end_time   datetime     null comment '社团离职时间',
    club_detail     varchar(500) null comment '社团细节',
    foreign_key     int          not null comment '外键',
    constraint club_experience_info_pk_2
        unique (id),
    constraint club_experience_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table education_info
(
    id          int auto_increment
        primary key,
    school      char(15) null comment '毕业学校',
    major       char(10) null comment '专业',
    degree      char(10) null comment '学历',
    grade       double   null comment '绩点',
    `rank`      int      null comment '排名',
    foreign_key int      not null comment '外键',
    constraint education_info_pk_2
        unique (id),
    constraint education_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table personal_info
(
    id          int auto_increment
        primary key,
    gender      int      null comment '性别',
    phone       char(20) null comment '手机号',
    email       char(20) null comment 'email',
    identity    char(20) null comment '当前身份',
    foreign_key int      null,
    constraint personal_info_pk_2
        unique (id),
    constraint personal_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table project_experience_info
(
    id                 int auto_increment
        primary key,
    project_name       char(20)     null comment '项目名',
    project_position     char(20)     null comment '职位姓名',
    project_start_time datetime     null comment '开始时间',
    project_end_time   datetime     null comment '结束时间',
    project_detail     varchar(500) null comment '项目经历',
    foreign_key        int          not null,
    constraint project_experience_info_pk_2
        unique (id),
    constraint project_experience_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table scholarship_info
(
    id               int auto_increment
        primary key,
    scholarship      char(20)     null comment '奖学金种类',
    scholarship_time datetime     null comment '获得时间',
    scholarship_detail       varchar(500) null comment '获得经历',
    foreign_key      int          not null,
    constraint scholarship_info_pk_2
        unique (id),
    constraint scholarship_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table social_act_info
(
    id             int auto_increment
        primary key,
    social_act     char(30)     null comment '社会实践',
    act_start_time datetime     null comment '开始时间',
    act_end_time   datetime     null comment '结束时间',
    act_detail     varchar(500) null comment '实践经历',
    foreign_key    int          not null,
    constraint social_act_info_pk_2
        unique (id),
    constraint social_act_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table stu_position_info
(
    id             int auto_increment
        primary key,
    stu_position   char(10)     null comment '学生职务',
    stu_start_time datetime     null comment '开始时间',
    stu_end_time   datetime     null comment '结束时间',
    stu_detail     varchar(500) null comment '职务经历',
    foreign_key    int          not null,
    constraint stu_position_info_pk_2
        unique (id),
    constraint stu_position_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);

create table work_experience_info
(
    id              int auto_increment
        primary key,
    company_name    char(20)     null comment '公司名称',
    work_position   char(20)     null comment '职务经历',
    work_start_time datetime     null comment '开始时间',
    work_end_time   datetime     null comment '结束时间',
    work_detail     varchar(500) null comment '工作经历',
    foreign_key     int          not null,
    constraint work_experience_info_pk_2
        unique (id),
    constraint work_experience_info_users_id_fk
        foreign key (foreign_key) references users (id)
            on delete cascade
);
