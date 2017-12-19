drop schema public cascade;
create schema public;

CREATE TABLE public."user" (
  id SERIAL,
  firstname VARCHAR,
  lastname VARCHAR,
  created TIMESTAMP(0) WITHOUT TIME ZONE,
  login VARCHAR,
  password VARCHAR,
  lastlogin TIMESTAMP(0) WITHOUT TIME ZONE,
  CONSTRAINT user_pkey PRIMARY KEY(id)
)
WITH (oids = false);

ALTER SEQUENCE public.user_id_seq RESTART WITH 3;

CREATE TABLE public.source (
  id SERIAL,
  user_id INTEGER NOT NULL,
  url VARCHAR NOT NULL,
  lastupdate TIMESTAMP(0) WITHOUT TIME ZONE,
  parser VARCHAR NOT NULL,
  created TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
  CONSTRAINT source_pkey PRIMARY KEY(id)
)
WITH (oids = false);

ALTER SEQUENCE public.source_id_seq RESTART WITH 5;

CREATE TABLE public.category (
  id SERIAL,
  name VARCHAR NOT NULL,
  CONSTRAINT category_name_key UNIQUE(name),
  CONSTRAINT category_pkey PRIMARY KEY(id)
)
WITH (oids = false);

ALTER SEQUENCE public.category_id_seq RESTART WITH 5;

CREATE TABLE public.post (
  id SERIAL,
  user_id INTEGER NOT NULL,
  category_id INTEGER NOT NULL,
  created TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
  title VARCHAR NOT NULL,
  body TEXT NOT NULL,
  CONSTRAINT posts_pkey PRIMARY KEY(id),
  CONSTRAINT posts_fk1 FOREIGN KEY (category_id)
  REFERENCES public.category(id)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
    NOT DEFERRABLE
)
WITH (oids = false);

ALTER SEQUENCE public.post_id_seq RESTART WITH 4;



