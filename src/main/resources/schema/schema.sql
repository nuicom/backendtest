create table if not exists oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INT,
  refresh_token_validity INT,
  additional_information VARCHAR(4096),
  autoapprove TINYINT
);

create table if not exists oauth_client_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255),
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);

create table if not exists oauth_access_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication BLOB,
  refresh_token VARCHAR(255)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(255),
  token BLOB,
  authentication BLOB
);

create table if not exists oauth_code (
  code VARCHAR(255),
  authentication BLOB
);

create table if not exists oauth_approvals (
  user_id VARCHAR(255),
  client_id VARCHAR(255),
  scope VARCHAR(255),
  status VARCHAR(10),
  expires_at DATETIME,
  last_modified_at DATETIME
);

create table if not exists ACCOUNT
( ID int(10) not null auto_increment,
DISABLED INT(1),
PASSWORD VARCHAR(80) not null,
USERNAME VARCHAR(10) not null,
 VERSIONS INT(10) not null,
 REFERENCE_CODE VARCHAR(12) not null,
 TYPE VARCHAR(10) not null,
 SALARY INT(10) not null);

