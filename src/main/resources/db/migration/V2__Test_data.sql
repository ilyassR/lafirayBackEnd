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

INSERT INTO car
    (id,
    marque,
    model,
    motorisation)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1250',
    'Mercedes',
    'AMG',
    'DIESEL'
);

INSERT INTO category
    (id,
    name)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1260',
    'Classic'
);

INSERT INTO category
    (id,
    name)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1261',
    'moderne'
);

INSERT INTO subcategory
    (id,
    category_id,
    name)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1270',
    '531e4cdd-bb78-4769-a0c7-cb948a9f1260',
    'Cabriolet'
);

INSERT INTO subcategory
    (id,
    category_id,
    name)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1271',
    '531e4cdd-bb78-4769-a0c7-cb948a9f1260',
    'Coupé'
);

INSERT INTO subcategory
    (id,
    category_id,
    name)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1272',
    '531e4cdd-bb78-4769-a0c7-cb948a9f1261',
    'Berline'
);

INSERT INTO piece
    (id,
    subcategory_id,
    nom,
    prix)
VALUES (
    '531e4cdd-bb78-4769-a0c7-cb948a9f1280',
    '531e4cdd-bb78-4769-a0c7-cb948a9f1270',
    'AUTO',
    200
);