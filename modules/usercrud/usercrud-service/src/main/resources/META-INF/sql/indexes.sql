create index IX_DCAD21CB on LFREXAM_UserCrud (groupId, userCrudId);
create index IX_8D78248B on LFREXAM_UserCrud (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7F4651CD on LFREXAM_UserCrud (uuid_[$COLUMN_LENGTH:75$], groupId);