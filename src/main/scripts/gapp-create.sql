
   
    create table additionalfields (
        addFieldId int4 not null,
        fieldName varchar(255),
        fieldType varchar(255),
        fileValue bytea,
        isRequired boolean,
        numberValue int4,
        textValue varchar(255),
        application_appId int4,
        dept_deptId int4,
        primary key (addFieldId)
    );

    create table applicationStatuses (
        AppStatusId int4 not null,
        comments varchar(255),
        dateChanged varchar(255),
        status varchar(255),
        appId_appId int4,
        updatedBy_id int4,
        primary key (AppStatusId)
    );

    create table applications (
        appId int4 not null,
        cin varchar(255),
        citizenship varchar(255),
        dateSubmitted timestamp,
        dob varchar(255),
        email varchar(255),
        filename varchar(255),
        fname varchar(255),
        gender varchar(255),
        greScore int4,
        isInternationalStudent boolean,
        lname varchar(255),
        phoneNo int8,
        term varchar(255),
        tofelScore int4,
        transcript bytea,
        department_deptId int4,
        program_prgmId int4,
        status_AppStatusId int4,
        user_id int4,
        primary key (appId)
    );

    create table departments (
        deptId int4 not null,
        deptName varchar(255),
        primary key (deptId)
    );

    create table educationalbackgrounds (
        edBckId int4 not null,
        degreeEarned varchar(255),
        degreeMajor varchar(255),
        gpa varchar(255),
        timeAttendedFrom varchar(255),
        timeAttendedTo varchar(255),
        univName varchar(255),
        applicationId_appId int4,
        user_id int4,
        primary key (edBckId)
    );

    create table materials (
        Id int4 not null,
        material bytea,
        materialName varchar(255),
        appli_appId int4,
        user_id int4,
        primary key (Id)
    );

    create table programs (
        prgmId int4 not null,
        programName varchar(255),
        dept_deptId int4,
        primary key (prgmId)
    );

    create table users (
        id int4 not null,
        email varchar(255) not null,
        fname varchar(255),
        isAdmin boolean not null,
        isStaff boolean not null,
        isStudent boolean not null,
        lname varchar(255),
        password varchar(255),
        primary key (id)
    );

    alter table users 
        add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email);

    alter table additionalfields 
        add constraint FK_hse64wqnu69egpdm13j5959n3 
        foreign key (application_appId) 
        references applications;

    alter table additionalfields 
        add constraint FK_pn7sk076jpbbxdnjp15kc0scx 
        foreign key (dept_deptId) 
        references departments;

    alter table applicationStatuses 
        add constraint FK_9fbba5os8m22ikw95hjp3wfc 
        foreign key (appId_appId) 
        references applications;

    alter table applicationStatuses 
        add constraint FK_sb4792d5ll69h5w4153padain 
        foreign key (updatedBy_id) 
        references users;

    alter table applications 
        add constraint FK_jkmhre0l44lj4ua89l9s01s9i 
        foreign key (department_deptId) 
        references departments;

    alter table applications 
        add constraint FK_j8ibfh51fj4yaj51hrkcgeivj 
        foreign key (program_prgmId) 
        references programs;

    alter table applications 
        add constraint FK_alfu66n253oafmtqyte2aau8 
        foreign key (status_AppStatusId) 
        references applicationStatuses;

    alter table applications 
        add constraint FK_il296b7i4a8es7mgs2a79gl8o 
        foreign key (user_id) 
        references users;

    alter table educationalbackgrounds 
        add constraint FK_fd2xnxr7mm5vtcdr0004gcmjs 
        foreign key (applicationId_appId) 
        references applications;

    alter table educationalbackgrounds 
        add constraint FK_irwh1boblcdmc289vsr00ioaw 
        foreign key (user_id) 
        references users;

    alter table materials 
        add constraint FK_hdqlmgqsyudinaypwntif8h5p 
        foreign key (appli_appId) 
        references applications;

    alter table materials 
        add constraint FK_c0fxt68sv6ggmpdsqt3vk07n1 
        foreign key (user_id) 
        references users;

    alter table programs 
        add constraint FK_nukuqs5hc9dxrp4b4f9mvn4yt 
        foreign key (dept_deptId) 
        references departments;

    create sequence hibernate_sequence minvalue 100;


    
insert into users values(1,'admin@localhost.localdomain','Tom',true,false,false,'Hardy','abcd');
insert into users values(2,'staff1@localhost.localdomain','James',false,true,false,'Pitt','1234');
insert into users values(3,'staff2@localhost.localdomain','Peter',false,true,false,'Dsouza','xyz');
insert into users values(4,'student1@localhost.localdomain','Rachel',false,false,true,'Green','6789');
insert into users values(5,'student2@localhost.localdomain','Pheobe',false,false,true,'Buffay','new');
insert into users values(6,'stud4@localhost.localdomain','Priya',false,false,true,'Rane','6789');
insert into users values(7,'stud5@localhost.localdomain','Rohan',false,false,true,'Rizwan','new');


insert into departments values(8,'Accounting Department');
insert into departments values(9,'Computer Science');
insert into programs values(10,'MS in Accounting',8);
insert into programs values(11,'MS in Finance',8);
insert into programs values(12,'MS in Maths',8);
insert into programs values(13,'MS in Computer Science',9);
insert into programs values(14,'MS in Networks',9);
insert into programs values(15,'Security',9);
insert into additionalfields values(16,'GMAT','Number',null,true,null,null,null,8);



insert into applicationstatuses values(17,' the application is submitted by the student',null,'new',null,4);
insert into applicationstatuses values(18,' the application is submitted by the student',null,'new',null,5);
insert into applicationstatuses values(19,'the department recommends the admission of the student',null,'Recommend Admit',null,6);
insert into applicationstatuses values(20,'the department recommends the admission of the student',null,'Recommend admit',null,7);

insert into applications values(21,304378534,'American',null,'08/10/1990','stud2@localhost.localdomain','null','Deep','male',304,true,'Amrutiya',9999888866,'Fall 2016',108,null,8,10,17,4);
insert into applications values(22,304378234,'Russian',null,'03/13/1991','stud3@localhost.localdomain','null','Riya','female',308,true,'Roy',9999888999,'Spring 2016',118,null,8,11,18,5);
insert into applications values(23,304378536,'Indian',null,'04/10/1992','stud4@localhost.localdomain','null','Priya','female',309,true,'Rane',9999888878,'Winter 2016',112,null,9,12,19,6);
insert into applications values(24,304378538,'Indian',null,'08/11/1990','stud5@localhost.localdomain','null','Rohan','male',310,true,'Rizwan',9999888865,'Summer 2016',111,null,9,13,20,7);
insert into applications values(500,4455555,'American',null,'08/10/1990','stud6@localhost.localdomain','null','Rohan','male',310,true,'Rizwan',9999888865,'Summer 2016',111,null,9,13,20,7);


insert into educationalbackgrounds values(25,'Masters','MS in CS','4','08/10/2008','06/13/2012','CSULA',21,4);