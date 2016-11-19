--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-11-19 16:21:10

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2195 (class 0 OID 33652)
-- Dependencies: 183
-- Data for Name: image; Type: TABLE DATA; Schema: public; Owner: lolo
--



--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 182
-- Name: image_image_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lolo
--

SELECT pg_catalog.setval('image_image_id_seq', 1, false);


--
-- TOC entry 2199 (class 0 OID 33686)
-- Dependencies: 187
-- Data for Name: ingredient; Type: TABLE DATA; Schema: public; Owner: lolo
--

INSERT INTO ingredient VALUES (1, 'augo', 'augo', NULL, '2016-11-19 16:15:11.6062+02', '2016-11-19 16:15:11.6062+02');
INSERT INTO ingredient VALUES (2, 'patates', 'patates', NULL, '2016-11-19 16:15:11.6122+02', '2016-11-19 16:15:11.6122+02');
INSERT INTO ingredient VALUES (3, 'loukaniko', 'loukaniko', NULL, '2016-11-19 16:15:11.6632+02', '2016-11-19 16:15:11.6632+02');
INSERT INTO ingredient VALUES (4, 'psomi', 'psomi', NULL, '2016-11-19 16:15:11.6652+02', '2016-11-19 16:15:11.6652+02');
INSERT INTO ingredient VALUES (5, 'galopoula', 'galopoula', NULL, '2016-11-19 16:15:11.6822+02', '2016-11-19 16:15:11.6822+02');
INSERT INTO ingredient VALUES (6, 'kaseri', 'kaseri', NULL, '2016-11-19 16:15:11.6842+02', '2016-11-19 16:15:11.6842+02');
INSERT INTO ingredient VALUES (7, 'makaronia', 'makaronia', NULL, '2016-11-19 16:15:11.7032+02', '2016-11-19 16:15:11.7032+02');
INSERT INTO ingredient VALUES (8, 'kimas', 'kimas', NULL, '2016-11-19 16:15:11.7052+02', '2016-11-19 16:15:11.7052+02');
INSERT INTO ingredient VALUES (9, 'ntomata', 'ntomata', NULL, '2016-11-19 16:15:11.7072+02', '2016-11-19 16:15:11.7072+02');
INSERT INTO ingredient VALUES (10, 'feta', 'feta', NULL, '2016-11-19 16:15:11.7092+02', '2016-11-19 16:15:11.7092+02');
INSERT INTO ingredient VALUES (11, 'mpouti kotopoulo', 'mpouti-kotopoulo', NULL, '2016-11-19 16:15:11.7392+02', '2016-11-19 16:15:11.7392+02');
INSERT INTO ingredient VALUES (12, 'ladi', 'ladi', NULL, '2016-11-19 16:15:11.7412+02', '2016-11-19 16:15:11.7412+02');
INSERT INTO ingredient VALUES (13, 'alati', 'alati', NULL, '2016-11-19 16:15:11.7432+02', '2016-11-19 16:15:11.7432+02');
INSERT INTO ingredient VALUES (14, 'piperi', 'piperi', NULL, '2016-11-19 16:15:11.7452+02', '2016-11-19 16:15:11.7452+02');
INSERT INTO ingredient VALUES (15, 'moustarda', 'moustarda', NULL, '2016-11-19 16:15:11.7472+02', '2016-11-19 16:15:11.7472+02');
INSERT INTO ingredient VALUES (16, 'rigani', 'rigani', NULL, '2016-11-19 16:15:11.7502+02', '2016-11-19 16:15:11.7502+02');
INSERT INTO ingredient VALUES (17, 'voutiro', 'voutiro', NULL, '2016-11-19 16:15:11.7782+02', '2016-11-19 16:15:11.7782+02');
INSERT INTO ingredient VALUES (18, 'zaxari', 'zaxari', NULL, '2016-11-19 16:15:11.7802+02', '2016-11-19 16:15:11.7802+02');
INSERT INTO ingredient VALUES (19, 'farina', 'farina', NULL, '2016-11-19 16:15:11.7822+02', '2016-11-19 16:15:11.7822+02');
INSERT INTO ingredient VALUES (20, 'gala', 'gala', NULL, '2016-11-19 16:15:11.7852+02', '2016-11-19 16:15:11.7852+02');
INSERT INTO ingredient VALUES (21, 'mpeikin paounter', 'mpeikin-paounter', NULL, '2016-11-19 16:15:11.7862+02', '2016-11-19 16:15:11.7862+02');
INSERT INTO ingredient VALUES (22, 'kakao', 'kakao', NULL, '2016-11-19 16:15:11.7882+02', '2016-11-19 16:15:11.7882+02');
INSERT INTO ingredient VALUES (23, 'portokali', 'portokali', NULL, '2016-11-19 16:15:11.7892+02', '2016-11-19 16:15:11.7892+02');


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 186
-- Name: ingredient_ingredient_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lolo
--

SELECT pg_catalog.setval('ingredient_ingredient_id_seq', 23, true);


--
-- TOC entry 2197 (class 0 OID 33665)
-- Dependencies: 185
-- Data for Name: recipe; Type: TABLE DATA; Schema: public; Owner: lolo
--

INSERT INTO recipe VALUES (1, 'auga me patates', 'auga-me-patates', '{"klevoume duo auga","kai 250 grammaria patates"}', NULL, NULL, NULL, '2016-11-19 16:15:11.6242+02', '2016-11-19 16:15:11.6362+02');
INSERT INTO recipe VALUES (2, 'hot dog', 'hot-dog', '{"afou ksereis apo loukanika"}', NULL, NULL, NULL, '2016-11-19 16:15:11.6682+02', '2016-11-19 16:15:11.6722+02');
INSERT INTO recipe VALUES (3, 'toast me galopoula', 'toast-me-galopoula', '{"vazoume kaseri kai galopoula anamesa stis fetes psomi","ta patame sti tostiera",win}', NULL, NULL, NULL, '2016-11-19 16:15:11.6882+02', '2016-11-19 16:15:11.6912+02');
INSERT INTO recipe VALUES (4, 'makaronia me kima kai feta', 'makaronia-me-kima-kai-feta', '{"kovoume tis ntomates kommatakia","vrazoume nero","vazoume makaronia","mathe mpalitsa apo ton arxonta"}', NULL, NULL, NULL, '2016-11-19 16:15:11.7152+02', '2016-11-19 16:15:11.7202+02');
INSERT INTO recipe VALUES (5, 'mpouti kotopoulo', 'mpouti-kotopoulo', '{"valta sti gastra","kai teleione"}', NULL, NULL, NULL, '2016-11-19 16:15:11.7522+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe VALUES (6, 'muffin sokolata', 'muffin-sokolata', '{chocoooo,win}', NULL, NULL, NULL, '2016-11-19 16:15:11.7952+02', '2016-11-19 16:15:11.8022+02');


--
-- TOC entry 2200 (class 0 OID 33697)
-- Dependencies: 188
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: lolo
--

INSERT INTO unit VALUES ('kilo', 'kilo', '2016-11-19 16:15:11.5362+02', '2016-11-19 16:15:11.5362+02');
INSERT INTO unit VALUES ('gr', 'gr', '2016-11-19 16:15:11.5362+02', '2016-11-19 16:15:11.5362+02');
INSERT INTO unit VALUES ('koutali glukou', 'koutali-glukou', '2016-11-19 16:15:11.5362+02', '2016-11-19 16:15:11.5362+02');
INSERT INTO unit VALUES ('koutali soupas', 'koutali soupas', '2016-11-19 16:15:11.5362+02', '2016-11-19 16:15:11.5362+02');
INSERT INTO unit VALUES ('kommati', 'kommati', '2016-11-19 16:15:11.5362+02', '2016-11-19 16:15:11.5362+02');
INSERT INTO unit VALUES ('koupa', 'koupa', '2016-11-19 16:15:11.5362+02', '2016-11-19 16:15:11.5362+02');


--
-- TOC entry 2201 (class 0 OID 33709)
-- Dependencies: 189
-- Data for Name: recipe_ingredient; Type: TABLE DATA; Schema: public; Owner: lolo
--

INSERT INTO recipe_ingredient VALUES (1, 1, 2.00, 'kommati', 'auga-me-patates-augo', NULL, NULL, '2016-11-19 16:15:11.6362+02', '2016-11-19 16:15:11.6362+02');
INSERT INTO recipe_ingredient VALUES (1, 2, 0.25, 'kilo', 'auga-me-patates-patates', NULL, NULL, '2016-11-19 16:15:11.6362+02', '2016-11-19 16:15:11.6362+02');
INSERT INTO recipe_ingredient VALUES (2, 3, 4.20, 'kommati', 'hot-dog-loukaniko', NULL, NULL, '2016-11-19 16:15:11.6722+02', '2016-11-19 16:15:11.6722+02');
INSERT INTO recipe_ingredient VALUES (2, 4, 3.20, 'kommati', 'hot-dog-psomi', NULL, NULL, '2016-11-19 16:15:11.6722+02', '2016-11-19 16:15:11.6722+02');
INSERT INTO recipe_ingredient VALUES (3, 4, 2.00, 'kommati', 'toast-me-galopoula-psomi', NULL, NULL, '2016-11-19 16:15:11.6912+02', '2016-11-19 16:15:11.6912+02');
INSERT INTO recipe_ingredient VALUES (3, 5, 1.00, 'kommati', 'toast-me-galopoula-galopoula', NULL, NULL, '2016-11-19 16:15:11.6912+02', '2016-11-19 16:15:11.6912+02');
INSERT INTO recipe_ingredient VALUES (3, 6, 1.00, 'kommati', 'toast-me-galopoula-kaseri', NULL, NULL, '2016-11-19 16:15:11.6912+02', '2016-11-19 16:15:11.6912+02');
INSERT INTO recipe_ingredient VALUES (4, 7, 250.00, 'gr', 'makaronia-me-kima-kai-feta-makaronia', NULL, NULL, '2016-11-19 16:15:11.7202+02', '2016-11-19 16:15:11.7202+02');
INSERT INTO recipe_ingredient VALUES (4, 8, 100.00, 'gr', 'makaronia-me-kima-kai-feta-kimas', NULL, NULL, '2016-11-19 16:15:11.7202+02', '2016-11-19 16:15:11.7202+02');
INSERT INTO recipe_ingredient VALUES (4, 9, 2.00, 'kommati', 'makaronia-me-kima-kai-feta-ntomata', NULL, NULL, '2016-11-19 16:15:11.7202+02', '2016-11-19 16:15:11.7202+02');
INSERT INTO recipe_ingredient VALUES (4, 10, 100.00, 'gr', 'makaronia-me-kima-kai-feta-feta', NULL, NULL, '2016-11-19 16:15:11.7202+02', '2016-11-19 16:15:11.7202+02');
INSERT INTO recipe_ingredient VALUES (5, 11, 2.00, 'kommati', 'mpouti-kotopoulo-mpouti-kotopoulo', NULL, NULL, '2016-11-19 16:15:11.7572+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe_ingredient VALUES (5, 12, 5.50, 'koutali glukou', 'mpouti-kotopoulo-ladi', NULL, NULL, '2016-11-19 16:15:11.7572+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe_ingredient VALUES (5, 13, 10.00, 'gr', 'mpouti-kotopoulo-alati', NULL, NULL, '2016-11-19 16:15:11.7572+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe_ingredient VALUES (5, 14, 10.00, 'gr', 'mpouti-kotopoulo-piperi', NULL, NULL, '2016-11-19 16:15:11.7572+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe_ingredient VALUES (5, 15, 2.00, 'koutali glukou', 'mpouti-kotopoulo-moustarda', NULL, NULL, '2016-11-19 16:15:11.7572+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe_ingredient VALUES (5, 16, 5.00, 'gr', 'mpouti-kotopoulo-rigani', NULL, NULL, '2016-11-19 16:15:11.7572+02', '2016-11-19 16:15:11.7572+02');
INSERT INTO recipe_ingredient VALUES (6, 22, 2.00, 'koutali soupas', 'muffin-sokolata-kakao', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 23, 1.00, 'kommati', 'muffin-sokolata-portokali', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 1, 1.00, 'kommati', 'muffin-sokolata-augo', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 17, 250.00, 'gr', 'muffin-sokolata-voutiro', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 18, 0.50, 'koupa', 'muffin-sokolata-zaxari', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 19, 1.00, 'koupa', 'muffin-sokolata-farina', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 20, 1.00, 'koupa', 'muffin-sokolata-gala', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');
INSERT INTO recipe_ingredient VALUES (6, 21, 1.00, 'koutali glukou', 'muffin-sokolata-mpeikin-paounter', NULL, NULL, '2016-11-19 16:15:11.8022+02', '2016-11-19 16:15:11.8022+02');


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 184
-- Name: recipe_recipe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lolo
--

SELECT pg_catalog.setval('recipe_recipe_id_seq', 6, true);


--
-- TOC entry 2203 (class 0 OID 33736)
-- Dependencies: 191
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: lolo
--

INSERT INTO tag VALUES (1, 'eukolo', 'eukolo', '2016-11-19 16:15:11.6182+02', '2016-11-19 16:15:11.6182+02');
INSERT INTO tag VALUES (2, 'paketo', 'paketo', '2016-11-19 16:15:11.7112+02', '2016-11-19 16:15:11.7112+02');
INSERT INTO tag VALUES (3, 'zumarika', 'zumarika', '2016-11-19 16:15:11.7132+02', '2016-11-19 16:15:11.7132+02');
INSERT INTO tag VALUES (4, 'gluko', 'gluko', '2016-11-19 16:15:11.7912+02', '2016-11-19 16:15:11.7912+02');
INSERT INTO tag VALUES (5, 'vegetarian', 'vegetarian', '2016-11-19 16:15:11.7942+02', '2016-11-19 16:15:11.7942+02');


--
-- TOC entry 2204 (class 0 OID 33749)
-- Dependencies: 192
-- Data for Name: recipe_tag; Type: TABLE DATA; Schema: public; Owner: lolo
--

INSERT INTO recipe_tag VALUES (1, 1, '2016-11-19 16:15:11.6242+02', '2016-11-19 16:15:11.6242+02');
INSERT INTO recipe_tag VALUES (2, 1, '2016-11-19 16:15:11.6682+02', '2016-11-19 16:15:11.6682+02');
INSERT INTO recipe_tag VALUES (3, 1, '2016-11-19 16:15:11.6882+02', '2016-11-19 16:15:11.6882+02');
INSERT INTO recipe_tag VALUES (4, 2, '2016-11-19 16:15:11.7152+02', '2016-11-19 16:15:11.7152+02');
INSERT INTO recipe_tag VALUES (4, 3, '2016-11-19 16:15:11.7152+02', '2016-11-19 16:15:11.7152+02');
INSERT INTO recipe_tag VALUES (5, 2, '2016-11-19 16:15:11.7522+02', '2016-11-19 16:15:11.7522+02');
INSERT INTO recipe_tag VALUES (6, 2, '2016-11-19 16:15:11.7952+02', '2016-11-19 16:15:11.7952+02');
INSERT INTO recipe_tag VALUES (6, 4, '2016-11-19 16:15:11.7952+02', '2016-11-19 16:15:11.7952+02');
INSERT INTO recipe_tag VALUES (6, 5, '2016-11-19 16:15:11.7952+02', '2016-11-19 16:15:11.7952+02');

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 190
-- Name: tag_tag_id_seq; Type: SEQUENCE SET; Schema: public; Owner: lolo
--

SELECT pg_catalog.setval('tag_tag_id_seq', 5, true);


-- Completed on 2016-11-19 16:21:10

--
-- PostgreSQL database dump complete
--

