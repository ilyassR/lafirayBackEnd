INSERT INTO person
            (id,
             first_name,
             last_name,
             email,
             phone,
             password,
             enabled,
             token_expired)
VALUES      ( '531e4cdd-bb78-4769-a0c7-cb948a9f1238',
              'ilyass',
              'rahmoune',
              'ilyass.rahmoune@gmail.com',
              '01234567',
              'ilyass',
              'true',
              '0');

INSERT INTO role
    (id,
    name)
VALUES  (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1239',
    'admin'
);

INSERT INTO privilege
    (id,
    name)
VALUES  (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1240',
    'WRITE_PRIVILEGE'
);

INSERT INTO persons_roles(
    person_id,
    role_id)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1238',
    '531e4cdd-bb78-4769-a0c7-cb948a9f1239'
);

INSERT INTO roles_privileges(
    role_id,
    privilege_id
) VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1239',
    '531e4cdd-bb78-4769-a0c7-cb948a9f1240'
);