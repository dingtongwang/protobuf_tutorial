CREATE TABLE person (
  id SERIAL PRIMARY KEY,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  birth_date varchar(255) DEFAULT NULL,
  country varchar(255) DEFAULT NULL,
  city varchar(255) DEFAULT NULL,
  postal_code varchar(255) DEFAULT NULL,
  street varchar(255) DEFAULT NULL,
  house_no varchar(255) DEFAULT NULL,
  flat_no varchar(255) DEFAULT NULL
);