
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

    create sequence hibernate_sequence;
