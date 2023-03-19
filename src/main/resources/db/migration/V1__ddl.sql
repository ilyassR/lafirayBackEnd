drop table if exists person;

drop table if exists role;

drop table if exists privilege;

drop table if exists persons_roles;

drop table if exists roles_privileges;

drop table if exists car;

drop table if exists category;

drop table if exists subcategory;

drop table if exists piece;

create table person (
    id UUID NOT NULL,
    first_name VARCHAR(200),
    last_name VARCHAR(200),
    email VARCHAR(300),
    phone VARCHAR(13),
    password VARCHAR(500),
    enabled BOOLEAN NOT NULL,
    token_expired BOOLEAN NOT NULL,
    PRIMARY KEY (id)
);
create table role(
    id UUID NOT NULL,
    name VARCHAR(40),
    PRIMARY KEY (id)
);
create table privilege(
    id UUID NOT NULL,
    name VARCHAR(100),
    PRIMARY KEY (id)
);
create table persons_roles(
    person_id UUID NOT NULL,
    role_id UUID NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (role_id) REFERENCES role(id),
    UNIQUE (person_id, role_id)
);
create table roles_privileges(
    role_id UUID NOT NULL,
    privilege_id UUID NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(id),
    FOREIGN KEY (privilege_id) REFERENCES privilege(id),
    UNIQUE(role_id, privilege_id)
);
create table car(
    id UUID NOT NULL,
    marque VARCHAR(100),
    model VARCHAR(100),
    motorisation VARCHAR(100),
    PRIMARY KEY (id)
);
create table category(
    id UUID NOT NULL UNIQUE,
    nom VARCHAR(100)
);

create table subcategory(
    id UUID NOT NULL UNIQUE,
    category_id UUID NOT NULL,
    nom VARCHAR(100),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

create table piece(
    id UUID NOT NULL,
    subcategory_id UUID NOT NULL,
    nom VARCHAR(100),
    prix FLOAT,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(id)
);