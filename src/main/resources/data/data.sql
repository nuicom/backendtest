insert into oauth_client_details (
  client_id,
  client_secret,
  authorized_grant_types,
  scope,
  authorities,
  access_token_validity
) values (
  'trustedclient',
  'trustedsecret',
  'password',
  'read',
  null,
  43200
);

