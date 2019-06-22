create table LFREXAM_UserCrud (
	uuid_ VARCHAR(75) null,
	userCrudId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null,
	birthDate DATE null
);