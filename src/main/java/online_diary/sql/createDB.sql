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
    userID int not null generated always as identity (start with 1, increment by 1),
    userName varchar(30) not null unique,
    fname varchar(30),
    lname varchar(30),
    address varchar(200),
    phone varchar(12),
    email varchar(100),
    password varchar(60),
    primary key (userid)
);
create table appointment(
    appointmentID int not null generated always as identity (start with 1, increment by 1),
    appointmentStart timestamp,
    appointmentEnd timestamp,
    title varchar(30),
    description varchar(300),
    creatorID int references userInfo(userid),
    primary key (appointmentID)
);
create table appointmentGuest(
    appointmentGuestID int not null generated always as identity (start with 1, increment by 1),
    guestID int references userInfo(userid),
    appointmentID int references appointment(appointmentid),
    primary key (appointmentGuestID)
);
