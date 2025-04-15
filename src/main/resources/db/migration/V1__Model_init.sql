create TABLE car (
  id UUID NOT NULL,
  marque VARCHAR(255),
  model VARCHAR(255),
  motorisation VARCHAR(255),
  CONSTRAINT pk_car PRIMARY KEY (id)
);

create TABLE category (
  id UUID NOT NULL,
  name VARCHAR(255),
  CONSTRAINT pk_category PRIMARY KEY (id)
);

create TABLE person (
  id UUID NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  email VARCHAR(255),
  phone VARCHAR(255),
  password VARCHAR(255),
  enabled BOOLEAN,
  token_expired BOOLEAN,
  CONSTRAINT pk_person PRIMARY KEY (id)
);

create TABLE persons_roles (
  person_id UUID NOT NULL,
  role_id UUID NOT NULL,
  CONSTRAINT pk_persons_roles PRIMARY KEY (person_id, role_id)
);

create TABLE piece (
  id UUID NOT NULL,
  nom VARCHAR(255),
  prix FLOAT,
  subcategory_id UUID,
  CONSTRAINT pk_piece PRIMARY KEY (id)
);

create TABLE privilege (
  id UUID NOT NULL,
  name VARCHAR(255),
  CONSTRAINT pk_privilege PRIMARY KEY (id)
);

create TABLE role (
  id UUID NOT NULL,
  name VARCHAR(255),
  CONSTRAINT pk_role PRIMARY KEY (id)
);

create TABLE roles_privileges (
  privilege_id UUID NOT NULL,
  role_id UUID NOT NULL,
  CONSTRAINT pk_roles_privileges PRIMARY KEY (privilege_id, role_id)
);

create TABLE subcategory (
  id UUID NOT NULL,
  name VARCHAR(255),
  category_id UUID,
  CONSTRAINT pk_subcategory PRIMARY KEY (id)
);

alter table piece add CONSTRAINT FK_PIECE_ON_SUBCATEGORY FOREIGN KEY (subcategory_id) REFERENCES subcategory (id);

alter table subcategory add CONSTRAINT FK_SUBCATEGORY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

alter table persons_roles add CONSTRAINT fk_perrol_on_person FOREIGN KEY (person_id) REFERENCES person (id);

alter table persons_roles add CONSTRAINT fk_perrol_on_role FOREIGN KEY (role_id) REFERENCES role (id);

alter table roles_privileges add CONSTRAINT fk_rolpri_on_privilege FOREIGN KEY (privilege_id) REFERENCES privilege (id);

alter table roles_privileges add CONSTRAINT fk_rolpri_on_role FOREIGN KEY (role_id) REFERENCES role (id);