--
-- PostgreSQL database dump
--

-- Dumped from database version 12.2
-- Dumped by pg_dump version 12.2

-- Started on 2020-06-11 13:07:41 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16385)
-- Name: marks; Type: TABLE; Schema: public; Owner: teacher
--

CREATE TABLE public.marks (
    name character varying(64) NOT NULL,
    marks jsonb
);


ALTER TABLE public.marks OWNER TO teacher;

--
-- TOC entry 2919 (class 0 OID 16385)
-- Dependencies: 202
-- Data for Name: marks; Type: TABLE DATA; Schema: public; Owner: teacher
--

COPY public.marks (name, marks) FROM stdin;
\.


--
-- TOC entry 2792 (class 2606 OID 16392)
-- Name: marks marks_pkey; Type: CONSTRAINT; Schema: public; Owner: teacher
--

ALTER TABLE ONLY public.marks
    ADD CONSTRAINT marks_pkey PRIMARY KEY (name);


-- Completed on 2020-06-11 13:07:41 UTC

--
-- PostgreSQL database dump complete
--

