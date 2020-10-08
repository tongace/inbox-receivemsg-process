CREATE TABLE USER_PROFILE
(
	CIF_ID varchar(50) NOT NULL,
	CONSUMER_NAME_TH varchar(1000) NULL,
	CONSUMER_NAME_EN varchar(1000) NULL,
	CONSUMER_ID varchar(20) NOT NULL,
	CONSUMER_MOBILE varchar(10) NOT NULL,
	IDENTIFIER varchar(100) NOT NULL,
	IDENTIFIER_TYPE varchar(20) NOT NULL,
	CUSTOMER_HASH_ID varchar(100),
	STATUS varchar(50),
	IS_ACTIVE varchar(1) NULL,
	CONSUMER_LATITUDE decimal(18, 6) NULL,
	CONSUMER_LONGITUDE decimal(18, 6) NULL,
	QR_ALIAS_NAME varchar(100) NULL,
	QR_AMT_LMT_VER_PIN decimal(17, 2) NULL,
	QR_ENABLE_AMT_LMT_VER_PIN varchar(5) NULL,
	QR_ENABLE_AMT_LMT_PER_DAY varchar(5) NULL,
	CREATE_DATE datetime NULL ,
	CREATE_BY varchar(200) NULL,
	UPDATE_DATE datetime NULL ,
	UPDATE_BY varchar(200) NULL,
	UPDATE_DESC varchar(2000) NULL,
	CONSTRAINT PK_CIF_ID PRIMARY KEY(CIF_ID)
);

CREATE INDEX IX_USER_PROFILE_IS_ACTIVE_CIF_ID ON USER_PROFILE(IS_ACTIVE ,CIF_ID);
CREATE INDEX USER_PROFILE_INDEX2 ON USER_PROFILE(CONSUMER_MOBILE);
CREATE INDEX USER_PROFILE_INDEX3 ON USER_PROFILE(CONSUMER_ID,CIF_ID);
CREATE INDEX USER_PROFILE_INDEX4 ON USER_PROFILE(CONSUMER_ID,IS_ACTIVE);
CREATE INDEX USER_PROFILE_INDEX_IDENTIFIER_IDENTIFIERTYPE ON USER_PROFILE(IDENTIFIER,IDENTIFIER_TYPE);
CREATE INDEX USER_PROFILE_INDEX_CUSTOMER_HASH_ID ON USER_PROFILE(CUSTOMER_HASH_ID);

---------------------------------------------------------------------------
create table PROFILE_DEVICE
(
	UUID varchar(200) not null,
	APP_ID varchar(200) not null,
	CIF_ID varchar(50) not null,
	CREATE_DATE datetime,
	IS_ACTIVE char,
	UPDATE_DATE datetime,
	FCM_TOKEN varchar(200),
	DEVICE_OS varchar(50),
	OS_VERSION varchar(100),
	BRAND varchar(200),
	MODEL varchar(200),
	TOKEN_ENABLE char,
	DISABLE_APP char,
	DISABLE_DEVICE char,
	constraint PK_DEVICE_MERCHANT
		primary key (UUID, APP_ID)
);

create index PROFILE_DEVICE_INDEX1
	on PROFILE_DEVICE (CIF_ID);

create index PROFILE_DEVICE_INDEX2
	on PROFILE_DEVICE (IS_ACTIVE, CIF_ID, APP_ID);

create index [PROFILE_DEVICE-APP_ID,CIF_ID]
	on PROFILE_DEVICE (APP_ID, CIF_ID, UPDATE_DATE);

---------------------------------------------------------------------------
CREATE TABLE TRANSACTION_HISTORY
(
	TRAH_SEQ_ID int IDENTITY(1,1) NOT NULL,
	TRAH_DTM datetime NOT NULL,
	TRAH_TXN_REF_ID varchar(50) NOT NULL,
	TRAH_SERVICE varchar(50) NOT NULL,
	TRAH_SUB_SERVICE varchar(50) NOT NULL,
	TRAH_BUS_KEYWORD varchar(200) NULL,
	TRAH_VERBOSE varchar(2000) NULL,
	TRAH_CIF_ID varchar(50) NULL,
	TRAH_REQ_CHANNEL varchar(30) NULL,
	TRAH_REQ_BY varchar(30) NULL,
	TRAH_GRP_CODE varchar(50) NULL,
	TRAH_EMP_FLAG varchar(1) NULL,
	TRAH_DESCRIPTION varchar(2000) NULL,
	TRAH_STATUS_RESP varchar(10) NULL,
	TRAH_CLIENT_IP nvarchar(2000) NULL,
	TRAH_SERVER_IP nvarchar(2000) NULL,
	TRAH_START_DTM datetime NULL,
	TRAH_END_DTM datetime NULL,
	TRAH_SOF_TYPE varchar(5) NULL,
	CONSTRAINT PK_TRAH_SEQ_ID PRIMARY KEY (TRAH_SEQ_ID)
);
---------------------------------------------------------------------------
create table SOURCE_OF_FUND
(
	CIF_ID varchar(50) not null,
	SOF_NO varchar(50) not null,
	SOF_TYPE varchar(5),
	SOF_NAME varchar(2000),
	SOF_DISPLAY varchar(2000),
	SOF_ALIAS varchar(2000),
	SOF_BANKCODE varchar(3),
	SOF_IS_ACTIVE varchar(1),
	SOF_CREATE_DATE datetime ,
	SOF_UPDATE_DATE datetime ,
	SOF_CIF_ID varchar(100),
	SOF_IDENTIFICATION varchar(100),
	OPT_1 varchar(100),
	OPT_2 varchar(100),
	OPT_3 varchar(100),
	OPT_4 varchar(100),
	OPT_5 varchar(100),
	primary key (CIF_ID, SOF_NO)
);
---------------------------------------------------------------------------
create table PROFILE_PIN
(
	USER_ID varchar(20) NOT NULL,
	CIF_ID varchar(50) NOT NULL,
	UUID varchar(200) NOT NULL,
	APP_ID varchar(200) NOT NULL,
	PIN varchar(50) NULL,
	PIN_EXPIRE datetime NULL,
	PIN_LOCK varchar(2) NULL,
	CREATE_DATE datetime NULL,
	UPDATE_DATE datetime NULL,
	primary key (USER_ID)
);
---------------------------------------------------------------------------
create table MATCHING_REGISTER
(
	CUSTOMER_ID varchar(60) NOT NULL,
	MATCHING_ID varchar(60) NOT NULL,
	DOPA_STATUS boolean,
	FACE_STATUS boolean,
	FORM_STATUS boolean,
	primary key (CUSTOMER_ID,MATCHING_ID)
);
