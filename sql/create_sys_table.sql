-- 创建库
create database if not exists my_db;
-- 切换库
use my_db;

-- 用户表
drop table if exists sys_user;
create table if not exists sys_user
(
    id          bigint                             not null comment '主键'
        primary key,
    account     varchar(100)                       not null comment '用户账号',
    password    varchar(300)                       not null comment '用户密码',
    username    varchar(100)                       not null comment '用户昵称',
    status      tinyint  default 1                 not null comment '用户状态，0无效，1有效',
    org_id      bigint                             not null comment '用户所属组织',
    phone       varchar(50)                        not null comment '电话',
    email       varchar(50)                        null comment '邮箱',
    sex         tinyint  default 1                 not null comment '性别，1男，2女',
    is_delete   tinyint  default 0                 not null comment '是否删除，0否，1是',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '修改时间',
    create_by   bigint                             null comment '创建用户id',
    update_by   bigint                             null comment '修改用户id'
)
    comment '用户表';
truncate table sys_user;
insert into sys_user value
    (1, 'admin', '$2a$10$YPnG.IYUk0mMechaxSibBuKmNeTzvuHdcxkqvoxizsll6WCQG9CHG', '管理员', default, 2, 1, 1, default,
     default, default, default, 1, 1),
    (2, 'test', '$2a$10$YPnG.IYUk0mMechaxSibBuKmNeTzvuHdcxkqvoxizsll6WCQG9CHG', '测试人员', default, 2, 1, 1, default,
     default, default, default, 1, 1);


-- 组织表
drop table sys_org;
create table if not exists sys_org
(
    id            bigint                             not null comment '主键'
        primary key,
    code          varchar(100)                       not null comment '机构编码',
    name          varchar(100)                       not null comment '组织名称',
    parent_id     bigint                             null comment '父类id',
    path          varchar(300)                       null comment '路径',
    sort          int      default 1                 not null comment '排序',
    level         tinyint  default 1                 not null comment '等级,1一级，2二级，3三级',
    manager_name  varchar(100)                       null comment '负责人姓名',
    manager_phone varchar(20)                        null comment '负责人电话',
    remarks       varchar(300)                       null comment '备注信息',
    is_delete     tinyint  default 0                 not null comment '是否删除，0否，1是',
    create_time   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time   datetime default CURRENT_TIMESTAMP null comment '修改时间',
    create_by     bigint                             null comment '创建用户id',
    update_by     bigint                             null comment '修改用户id'
)
    comment '组织表';
truncate table sys_org;
insert into sys_org value
    (1, 'root', '根节点', -1, null, 1, 1, null, null, null, default, default, default, default, default),
    (2, 'CDYW', '成都壹为', 1, '1,2', 1, 2, null, null, null, default, default, default, default, default);


-- 角色表
drop table if exists sys_role;
create table if not exists sys_role
(
    id          bigint                             not null comment '主键'
        primary key,
    code        varchar(100)                       not null comment '角色编码',
    name        varchar(100)                       not null comment '角色名称',
    description varchar(300)                       null comment '描述',
    org_id      bigint                             not null comment '角色所属组织',
    is_delete   tinyint  default 0                 not null comment '是否删除，0否，1是',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '修改时间',
    create_by   bigint                             null comment '创建用户id',
    update_by   bigint                             null comment '修改用户id'
)
    comment '角色表';
truncate table sys_role;
insert into sys_role value
    (1, 'admin', '管理员', default, 2, default, default, default, default, default),
    (2, 'test', '测试人员', default, 2, default, default, default, default, default);

-- 菜单功能表
drop table if exists sys_menu;
create table if not exists sys_menu
(
    id          bigint                             not null comment '主键'
        primary key,
    code        varchar(100)                       not null comment '编码',
    name        varchar(100)                       not null comment '名称',
    parent_id   bigint                             null comment '父类id',
    path        varchar(300)                       null comment '路径',
    sort        int      default 1                 not null comment '排序',
    level       tinyint  default 1                 not null comment '等级',
    node_type   tinyint  default 1                 not null comment '节点类型，1根节点,2菜单,3页面,4按钮', --
    link_url    varchar(255)                       null comment '页面对应地址',
    icon_url    varchar(20)                        null comment '图标地址',

    is_delete   tinyint  default 0                 not null comment '是否删除，0否，1是',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '修改时间',
    create_by   bigint                             null comment '创建用户id',
    update_by   bigint                             null comment '修改用户id'
)
    comment '菜单功能表';
truncate table sys_menu;
insert into sys_menu
values (0, 'root', '根节点', 0, null, 1, 1, 1, null, null, 0, default, default, default, default),
       (1, 'system', '系统配置', 0, '0,1', 1, 2, 2, null, null, 0, default, default, default, default),
       (2, 'orgMgr', '机构管理', 1, '0,1,2', 1, 3, 3, null, null, 0, default, default, default,
        default),
       (3, 'userMgr', '用户管理', 1, '0,1,3', 2, 3, 3, null, null, 0, default, default, default,
        default),
       (4, 'userMgr:list', '用户管理-查看', 3, '0,1,3,4', 1, 4, 4, null, null, 0, default, default,
        default, default),
       (5, 'userMgr:add', '用户管理-新增', 3, '0,1,3,5', 2, 4, 4, null, null, 0, default, default,
        default, default);

-- 用户角色表
drop table sys_user_role;
create table if not exists sys_user_role
(
    id      bigint       not null comment '主键'
        primary key,
    user_id varchar(100) not null comment '用户id',
    role_id varchar(100) not null comment '角色id'
)
    comment '用户角色表';
truncate table sys_user_role;
insert into sys_user_role value (1, 1, 1), (2, 2, 2);


-- 角色功能表
drop table sys_role_menu;
create table if not exists sys_role_menu
(
    id      bigint       not null comment '主键'
        primary key,
    role_id varchar(100) not null comment '角色id',
    menu_id varchar(100) not null comment '菜单ID'
)
    comment '角色功能表';
truncate table sys_role_menu;
insert into sys_role_menu
values (1, 1, 4),
       (2, 1, 5),
       (3, 2, 4);

-- 字典类型表
drop table if exists sys_dict_type;
create table if not exists sys_dict_type
(
    id          bigint                             not null comment '主键'
        primary key,
    code        varchar(100)                       not null comment '字典名称',
    name        varchar(100)                       not null comment '字典类型',
    remarks     varchar(500)                       null comment '备注',

    is_delete   tinyint  default 0                 not null comment '是否删除，0否，1是',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '修改时间',
    create_by   bigint                             null comment '创建用户id',
    update_by   bigint                             null comment '修改用户id'
)
    comment '字典类型表';


-- 字典信息表
drop table if exists sys_dict_data;
create table if not exists sys_dict_data
(
    id          bigint                             not null comment '字典项id'
        primary key,
    dict_key    varchar(100)                       not null comment '字典项key',
    dict_value  varchar(100)                       not null comment '字典项value',
    type_id     varchar(100)                       not null comment '字典类型标识',
    sort        tinyint  default 1                 not null comment '字典项排序',

    is_delete   tinyint  default 0                 not null comment '是否删除，0否，1是',
    create_time datetime default CURRENT_TIMESTAMP null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '修改时间',
    create_by   bigint                             null comment '创建用户id',
    update_by   bigint                             null comment '修改用户id'
)
    comment '字典信息表';
