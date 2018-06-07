--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.6
-- Dumped by pg_dump version 9.6.6

-- Started on 2018-06-07 14:18:13

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 190 (class 1259 OID 16418)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE category (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE category OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16416)
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categories_id_seq OWNER TO postgres;

--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 189
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE categories_id_seq OWNED BY category.id;


--
-- TOC entry 188 (class 1259 OID 16407)
-- Name: hierarchy; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE hierarchy (
    id integer NOT NULL,
    name character varying NOT NULL,
    employee_id integer NOT NULL,
    manager_id integer NOT NULL
);


ALTER TABLE hierarchy OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16405)
-- Name: hierarchy_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hierarchy_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hierarchy_id_seq OWNER TO postgres;

--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 187
-- Name: hierarchy_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE hierarchy_id_seq OWNED BY hierarchy.id;


--
-- TOC entry 200 (class 1259 OID 16498)
-- Name: master; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE master (
    id integer NOT NULL,
    slave_id integer
);


ALTER TABLE master OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16496)
-- Name: master_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE master_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE master_id_seq OWNER TO postgres;

--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 199
-- Name: master_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE master_id_seq OWNED BY master.id;


--
-- TOC entry 192 (class 1259 OID 16426)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE post (
    id integer NOT NULL,
    category_id integer NOT NULL,
    user_id integer,
    title character varying(100) NOT NULL,
    body character varying NOT NULL,
    created date NOT NULL
);


ALTER TABLE post OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16424)
-- Name: post_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE post_id_seq OWNER TO postgres;

--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 191
-- Name: post_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE post_id_seq OWNED BY post.id;


--
-- TOC entry 194 (class 1259 OID 16447)
-- Name: post_tag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE post_tag (
    id integer NOT NULL,
    post_id integer NOT NULL,
    tag_id integer NOT NULL
);


ALTER TABLE post_tag OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 16445)
-- Name: post_tag_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE post_tag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE post_tag_id_seq OWNER TO postgres;

--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 193
-- Name: post_tag_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE post_tag_id_seq OWNED BY post_tag.id;


--
-- TOC entry 198 (class 1259 OID 16480)
-- Name: rang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE rang (
    id integer NOT NULL,
    rang_name character varying(100) NOT NULL,
    name character varying(100)
);


ALTER TABLE rang OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 16478)
-- Name: rang_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE rang_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE rang_id_seq OWNER TO postgres;

--
-- TOC entry 2229 (class 0 OID 0)
-- Dependencies: 197
-- Name: rang_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE rang_id_seq OWNED BY rang.id;


--
-- TOC entry 202 (class 1259 OID 16506)
-- Name: slave; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE slave (
    id integer NOT NULL,
    name character varying(100)
);


ALTER TABLE slave OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16504)
-- Name: slave_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE slave_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE slave_id_seq OWNER TO postgres;

--
-- TOC entry 2230 (class 0 OID 0)
-- Dependencies: 201
-- Name: slave_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE slave_id_seq OWNED BY slave.id;


--
-- TOC entry 195 (class 1259 OID 16453)
-- Name: tag; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tag (
    id integer DEFAULT nextval(('public.tag_id_seq'::text)::regclass) NOT NULL,
    tag_name character varying(100) NOT NULL
);


ALTER TABLE tag OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16468)
-- Name: tag_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE tag_id_seq OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16396)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "user" (
    id integer NOT NULL,
    firstname character varying,
    lastname character varying,
    created date NOT NULL,
    rang_id integer NOT NULL
);


ALTER TABLE "user" OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16394)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;

--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 185
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 2054 (class 2604 OID 16421)
-- Name: category id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 16410)
-- Name: hierarchy id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hierarchy ALTER COLUMN id SET DEFAULT nextval('hierarchy_id_seq'::regclass);


--
-- TOC entry 2059 (class 2604 OID 16501)
-- Name: master id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY master ALTER COLUMN id SET DEFAULT nextval('master_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 16429)
-- Name: post id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post ALTER COLUMN id SET DEFAULT nextval('post_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 16450)
-- Name: post_tag id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post_tag ALTER COLUMN id SET DEFAULT nextval('post_tag_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 16483)
-- Name: rang id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rang ALTER COLUMN id SET DEFAULT nextval('rang_id_seq'::regclass);


--
-- TOC entry 2060 (class 2604 OID 16509)
-- Name: slave id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY slave ALTER COLUMN id SET DEFAULT nextval('slave_id_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 16399)
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 189
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('categories_id_seq', 2, true);


--
-- TOC entry 2206 (class 0 OID 16418)
-- Dependencies: 190
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY category (id, name) FROM stdin;
1	Sport
2	Politic
\.


--
-- TOC entry 2204 (class 0 OID 16407)
-- Dependencies: 188
-- Data for Name: hierarchy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY hierarchy (id, name, employee_id, manager_id) FROM stdin;
1	Jonn	1	0
2	Mary	2	1
3	Karl	3	1
4	Mark	4	2
5	Gustav	5	2
\.


--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 187
-- Name: hierarchy_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hierarchy_id_seq', 5, true);


--
-- TOC entry 2216 (class 0 OID 16498)
-- Dependencies: 200
-- Data for Name: master; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY master (id, slave_id) FROM stdin;
3	\N
1	2
2	1
\.


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 199
-- Name: master_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('master_id_seq', 4, true);


--
-- TOC entry 2208 (class 0 OID 16426)
-- Dependencies: 192
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY post (id, category_id, user_id, title, body, created) FROM stdin;
1	1	1	first post	first post body	2018-05-20
2	2	2	second post	second post text	2018-05-21
6	1	1	third post	ddddd	2018-05-25
\.


--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 191
-- Name: post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('post_id_seq', 6, true);


--
-- TOC entry 2210 (class 0 OID 16447)
-- Dependencies: 194
-- Data for Name: post_tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY post_tag (id, post_id, tag_id) FROM stdin;
1	1	1
2	1	2
3	2	2
4	2	3
\.


--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 193
-- Name: post_tag_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('post_tag_id_seq', 4, true);


--
-- TOC entry 2214 (class 0 OID 16480)
-- Dependencies: 198
-- Data for Name: rang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY rang (id, rang_name, name) FROM stdin;
1	user	user name
2	admin	admin name
\.


--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 197
-- Name: rang_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('rang_id_seq', 3, true);


--
-- TOC entry 2218 (class 0 OID 16506)
-- Dependencies: 202
-- Data for Name: slave; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY slave (id, name) FROM stdin;
1	first
2	second
\.


--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 201
-- Name: slave_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('slave_id_seq', 2, true);


--
-- TOC entry 2211 (class 0 OID 16453)
-- Dependencies: 195
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tag (id, tag_name) FROM stdin;
1	happy
2	calm
3	love
\.


--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 196
-- Name: tag_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tag_id_seq', 1, false);


--
-- TOC entry 2202 (class 0 OID 16396)
-- Dependencies: 186
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "user" (id, firstname, lastname, created, rang_id) FROM stdin;
1	Иванов	Сергей	2017-03-12	1
2	Watson	Jonn	2017-03-20	2
3	Сергеева	Клавдия	2017-03-10	1
\.


--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 185
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 3, true);


--
-- TOC entry 2066 (class 2606 OID 16423)
-- Name: category categories_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 16415)
-- Name: hierarchy hierarchy_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY hierarchy
    ADD CONSTRAINT hierarchy_pkey PRIMARY KEY (id);


--
-- TOC entry 2076 (class 2606 OID 16503)
-- Name: master master_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY master
    ADD CONSTRAINT master_pkey PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 16434)
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);


--
-- TOC entry 2070 (class 2606 OID 16452)
-- Name: post_tag post_tag_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post_tag
    ADD CONSTRAINT post_tag_pkey PRIMARY KEY (id);


--
-- TOC entry 2074 (class 2606 OID 16485)
-- Name: rang rang_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY rang
    ADD CONSTRAINT rang_pkey PRIMARY KEY (id);


--
-- TOC entry 2078 (class 2606 OID 16511)
-- Name: slave slave_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY slave
    ADD CONSTRAINT slave_pkey PRIMARY KEY (id);


--
-- TOC entry 2072 (class 2606 OID 16471)
-- Name: tag tag_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT tag_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 16404)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2080 (class 2606 OID 16435)
-- Name: post post_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post
    ADD CONSTRAINT post_fk FOREIGN KEY (category_id) REFERENCES category(id);


--
-- TOC entry 2081 (class 2606 OID 16440)
-- Name: post post_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post
    ADD CONSTRAINT post_fk1 FOREIGN KEY (user_id) REFERENCES "user"(id);


--
-- TOC entry 2082 (class 2606 OID 16456)
-- Name: post_tag post_tag_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post_tag
    ADD CONSTRAINT post_tag_fk FOREIGN KEY (post_id) REFERENCES post(id);


--
-- TOC entry 2083 (class 2606 OID 16472)
-- Name: post_tag post_tag_fk1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY post_tag
    ADD CONSTRAINT post_tag_fk1 FOREIGN KEY (tag_id) REFERENCES tag(id);


--
-- TOC entry 2079 (class 2606 OID 16491)
-- Name: user user_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_fk FOREIGN KEY (rang_id) REFERENCES rang(id);


-- Completed on 2018-06-07 14:18:14

--
-- PostgreSQL database dump complete
--

