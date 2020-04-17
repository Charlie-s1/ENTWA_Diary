/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Charlie Smith
 * Created: 17 Apr 2020
 */

create table userInfo(
    userid int not null generated always as identity (start with 1, increment by 1),
    userName varchar(30) not null unique,
    fname varchar(30),
    lname varchar(30),
    address varchar(200),
    phone varchar(12),
    email varchar(100),
    password varchar(60),
    primary key (userid)
)


