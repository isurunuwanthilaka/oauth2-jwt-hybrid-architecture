create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);


create table if not exists  permission (
  id serial PRIMARY KEY,
  name varchar(512) default null ,
  unique(name)
);

create table if not exists role (
  id serial primary key,
  name varchar(255) default null,
  unique(name)
);

create table if not exists users(
  id serial primary key,
  username varchar not null,
  password varchar not null,
  email varchar not null,
  enabled integer not null,
  account_non_expired integer not null,
  credentials_non_expired integer not null,
  account_non_locked integer not null,
  unique(username)
);


create table  if not exists permission_role (
id serial primary key,
  permission_id int default null REFERENCES permission(id),
  role_id int default null REFERENCES role(id)
);



create table if not exists role_user (
id serial primary key,
  role_id integer default null REFERENCES role(id),
  user_id integer default null REFERENCES users(id)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

create table oauth_code (
  code VARCHAR(256), authentication bytea
);

create table oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP,
  lastModifiedAt TIMESTAMP
);