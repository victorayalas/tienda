--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.3

-- Started on 2021-11-26 00:10:10

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

--
-- TOC entry 3057 (class 1262 OID 40960)
-- Name: tienda; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE tienda WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';


ALTER DATABASE tienda OWNER TO postgres;

\connect tienda

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

--
-- TOC entry 4 (class 2615 OID 40967)
-- Name: app_tienda; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA app_tienda;


ALTER SCHEMA app_tienda OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 40974)
-- Name: apti_clientes; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_clientes (
    id_cliente integer NOT NULL,
    nombre character varying(100),
    documento_identidad character varying(13)
);


ALTER TABLE app_tienda.apti_clientes OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 40977)
-- Name: apti_clientes_id_cliente_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_clientes_id_cliente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_clientes_id_cliente_seq OWNER TO postgres;

--
-- TOC entry 3058 (class 0 OID 0)
-- Dependencies: 204
-- Name: apti_clientes_id_cliente_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_clientes_id_cliente_seq OWNED BY app_tienda.apti_clientes.id_cliente;


--
-- TOC entry 211 (class 1259 OID 41023)
-- Name: apti_detalle_pedido; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_detalle_pedido (
    id_detalle_pedido integer NOT NULL,
    id_pedido integer,
    id_producto integer,
    cantidad double precision,
    id_tienda integer
);


ALTER TABLE app_tienda.apti_detalle_pedido OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 41026)
-- Name: apti_detalle_pedido_id_detalle_pedido_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_detalle_pedido_id_detalle_pedido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_detalle_pedido_id_detalle_pedido_seq OWNER TO postgres;

--
-- TOC entry 3059 (class 0 OID 0)
-- Dependencies: 212
-- Name: apti_detalle_pedido_id_detalle_pedido_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_detalle_pedido_id_detalle_pedido_seq OWNED BY app_tienda.apti_detalle_pedido.id_detalle_pedido;


--
-- TOC entry 208 (class 1259 OID 40998)
-- Name: apti_pedidos; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_pedidos (
    id_pedido integer NOT NULL,
    id_cliente integer,
    fecha date
);


ALTER TABLE app_tienda.apti_pedidos OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 41001)
-- Name: apti_pedidos_id_pedidos_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_pedidos_id_pedidos_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_pedidos_id_pedidos_seq OWNER TO postgres;

--
-- TOC entry 3060 (class 0 OID 0)
-- Dependencies: 209
-- Name: apti_pedidos_id_pedidos_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_pedidos_id_pedidos_seq OWNED BY app_tienda.apti_pedidos.id_pedido;


--
-- TOC entry 202 (class 1259 OID 40971)
-- Name: apti_productos; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_productos (
    id_producto integer NOT NULL,
    nombre character varying(100),
    precio double precision,
    codigo character varying(20)
);


ALTER TABLE app_tienda.apti_productos OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 40983)
-- Name: apti_productos_id_producto_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_productos_id_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_productos_id_producto_seq OWNER TO postgres;

--
-- TOC entry 3061 (class 0 OID 0)
-- Dependencies: 205
-- Name: apti_productos_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_productos_id_producto_seq OWNED BY app_tienda.apti_productos.id_producto;


--
-- TOC entry 207 (class 1259 OID 40995)
-- Name: apti_stock; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_stock (
    id_stock integer NOT NULL,
    id_producto integer,
    id_tienda integer,
    estado boolean DEFAULT true
);


ALTER TABLE app_tienda.apti_stock OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 41007)
-- Name: apti_stok_id_stok_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_stok_id_stok_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_stok_id_stok_seq OWNER TO postgres;

--
-- TOC entry 3062 (class 0 OID 0)
-- Dependencies: 210
-- Name: apti_stok_id_stok_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_stok_id_stok_seq OWNED BY app_tienda.apti_stock.id_stock;


--
-- TOC entry 201 (class 1259 OID 40968)
-- Name: apti_tiendas; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_tiendas (
    id_tienda integer NOT NULL,
    nombre character varying(100),
    direccion character varying(100)
);


ALTER TABLE app_tienda.apti_tiendas OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 40989)
-- Name: apti_tiendas_id_tienda_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_tiendas_id_tienda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_tiendas_id_tienda_seq OWNER TO postgres;

--
-- TOC entry 3063 (class 0 OID 0)
-- Dependencies: 206
-- Name: apti_tiendas_id_tienda_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_tiendas_id_tienda_seq OWNED BY app_tienda.apti_tiendas.id_tienda;


--
-- TOC entry 214 (class 1259 OID 41060)
-- Name: apti_tiendas_productos; Type: TABLE; Schema: app_tienda; Owner: postgres
--

CREATE TABLE app_tienda.apti_tiendas_productos (
    id_tienda_producto integer NOT NULL,
    id_tienda integer,
    id_producto integer,
    cantidad integer
);


ALTER TABLE app_tienda.apti_tiendas_productos OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 41058)
-- Name: apti_tiendas_productos_id_tienda_producto_seq; Type: SEQUENCE; Schema: app_tienda; Owner: postgres
--

CREATE SEQUENCE app_tienda.apti_tiendas_productos_id_tienda_producto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE app_tienda.apti_tiendas_productos_id_tienda_producto_seq OWNER TO postgres;

--
-- TOC entry 3064 (class 0 OID 0)
-- Dependencies: 213
-- Name: apti_tiendas_productos_id_tienda_producto_seq; Type: SEQUENCE OWNED BY; Schema: app_tienda; Owner: postgres
--

ALTER SEQUENCE app_tienda.apti_tiendas_productos_id_tienda_producto_seq OWNED BY app_tienda.apti_tiendas_productos.id_tienda_producto;


--
-- TOC entry 2889 (class 2604 OID 40979)
-- Name: apti_clientes id_cliente; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_clientes ALTER COLUMN id_cliente SET DEFAULT nextval('app_tienda.apti_clientes_id_cliente_seq'::regclass);


--
-- TOC entry 2893 (class 2604 OID 41028)
-- Name: apti_detalle_pedido id_detalle_pedido; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_detalle_pedido ALTER COLUMN id_detalle_pedido SET DEFAULT nextval('app_tienda.apti_detalle_pedido_id_detalle_pedido_seq'::regclass);


--
-- TOC entry 2892 (class 2604 OID 41003)
-- Name: apti_pedidos id_pedido; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_pedidos ALTER COLUMN id_pedido SET DEFAULT nextval('app_tienda.apti_pedidos_id_pedidos_seq'::regclass);


--
-- TOC entry 2888 (class 2604 OID 40985)
-- Name: apti_productos id_producto; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_productos ALTER COLUMN id_producto SET DEFAULT nextval('app_tienda.apti_productos_id_producto_seq'::regclass);


--
-- TOC entry 2890 (class 2604 OID 41009)
-- Name: apti_stock id_stock; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_stock ALTER COLUMN id_stock SET DEFAULT nextval('app_tienda.apti_stok_id_stok_seq'::regclass);


--
-- TOC entry 2887 (class 2604 OID 40991)
-- Name: apti_tiendas id_tienda; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas ALTER COLUMN id_tienda SET DEFAULT nextval('app_tienda.apti_tiendas_id_tienda_seq'::regclass);


--
-- TOC entry 2894 (class 2604 OID 41063)
-- Name: apti_tiendas_productos id_tienda_producto; Type: DEFAULT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas_productos ALTER COLUMN id_tienda_producto SET DEFAULT nextval('app_tienda.apti_tiendas_productos_id_tienda_producto_seq'::regclass);


--
-- TOC entry 2900 (class 2606 OID 41014)
-- Name: apti_clientes pk_id_cliente; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_clientes
    ADD CONSTRAINT pk_id_cliente PRIMARY KEY (id_cliente);


--
-- TOC entry 2910 (class 2606 OID 41033)
-- Name: apti_detalle_pedido pk_id_detalle_pedido; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_detalle_pedido
    ADD CONSTRAINT pk_id_detalle_pedido PRIMARY KEY (id_detalle_pedido);


--
-- TOC entry 2905 (class 2606 OID 41016)
-- Name: apti_pedidos pk_id_pedido; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_pedidos
    ADD CONSTRAINT pk_id_pedido PRIMARY KEY (id_pedido);


--
-- TOC entry 2898 (class 2606 OID 41018)
-- Name: apti_productos pk_id_producto; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_productos
    ADD CONSTRAINT pk_id_producto PRIMARY KEY (id_producto);


--
-- TOC entry 2902 (class 2606 OID 41020)
-- Name: apti_stock pk_id_stok; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_stock
    ADD CONSTRAINT pk_id_stok PRIMARY KEY (id_stock);


--
-- TOC entry 2896 (class 2606 OID 41022)
-- Name: apti_tiendas pk_id_tienda; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas
    ADD CONSTRAINT pk_id_tienda PRIMARY KEY (id_tienda);


--
-- TOC entry 2914 (class 2606 OID 41070)
-- Name: apti_tiendas_productos pk_id_tienda_producto; Type: CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas_productos
    ADD CONSTRAINT pk_id_tienda_producto PRIMARY KEY (id_tienda_producto);


--
-- TOC entry 2906 (class 1259 OID 41094)
-- Name: fki_fk_dp_id_teinda; Type: INDEX; Schema: app_tienda; Owner: postgres
--

CREATE INDEX fki_fk_dp_id_teinda ON app_tienda.apti_detalle_pedido USING btree (id_tienda);


--
-- TOC entry 2903 (class 1259 OID 41057)
-- Name: fki_fk_id_cliente; Type: INDEX; Schema: app_tienda; Owner: postgres
--

CREATE INDEX fki_fk_id_cliente ON app_tienda.apti_pedidos USING btree (id_cliente);


--
-- TOC entry 2907 (class 1259 OID 41039)
-- Name: fki_fk_id_pedido; Type: INDEX; Schema: app_tienda; Owner: postgres
--

CREATE INDEX fki_fk_id_pedido ON app_tienda.apti_detalle_pedido USING btree (id_pedido);


--
-- TOC entry 2908 (class 1259 OID 41045)
-- Name: fki_fk_id_producto; Type: INDEX; Schema: app_tienda; Owner: postgres
--

CREATE INDEX fki_fk_id_producto ON app_tienda.apti_detalle_pedido USING btree (id_producto);


--
-- TOC entry 2911 (class 1259 OID 41087)
-- Name: fki_fk_tienda_producto_id_producto; Type: INDEX; Schema: app_tienda; Owner: postgres
--

CREATE INDEX fki_fk_tienda_producto_id_producto ON app_tienda.apti_tiendas_productos USING btree (id_producto);


--
-- TOC entry 2912 (class 1259 OID 41081)
-- Name: fki_fk_tienda_producto_id_tienda; Type: INDEX; Schema: app_tienda; Owner: postgres
--

CREATE INDEX fki_fk_tienda_producto_id_tienda ON app_tienda.apti_tiendas_productos USING btree (id_tienda);


--
-- TOC entry 2918 (class 2606 OID 41089)
-- Name: apti_detalle_pedido fk_dp_id_tienda; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_detalle_pedido
    ADD CONSTRAINT fk_dp_id_tienda FOREIGN KEY (id_tienda) REFERENCES app_tienda.apti_tiendas(id_tienda) NOT VALID;


--
-- TOC entry 2915 (class 2606 OID 41052)
-- Name: apti_pedidos fk_id_cliente; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_pedidos
    ADD CONSTRAINT fk_id_cliente FOREIGN KEY (id_cliente) REFERENCES app_tienda.apti_clientes(id_cliente) NOT VALID;


--
-- TOC entry 2916 (class 2606 OID 41034)
-- Name: apti_detalle_pedido fk_id_pedido; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_detalle_pedido
    ADD CONSTRAINT fk_id_pedido FOREIGN KEY (id_pedido) REFERENCES app_tienda.apti_pedidos(id_pedido) NOT VALID;


--
-- TOC entry 2917 (class 2606 OID 41040)
-- Name: apti_detalle_pedido fk_id_producto; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_detalle_pedido
    ADD CONSTRAINT fk_id_producto FOREIGN KEY (id_producto) REFERENCES app_tienda.apti_productos(id_producto) NOT VALID;


--
-- TOC entry 2919 (class 2606 OID 41071)
-- Name: apti_tiendas_productos fk_id_tienda; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas_productos
    ADD CONSTRAINT fk_id_tienda FOREIGN KEY (id_tienda) REFERENCES app_tienda.apti_tiendas(id_tienda) NOT VALID;


--
-- TOC entry 2921 (class 2606 OID 41082)
-- Name: apti_tiendas_productos fk_tienda_producto_id_producto; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas_productos
    ADD CONSTRAINT fk_tienda_producto_id_producto FOREIGN KEY (id_producto) REFERENCES app_tienda.apti_productos(id_producto) NOT VALID;


--
-- TOC entry 2920 (class 2606 OID 41076)
-- Name: apti_tiendas_productos fk_tienda_producto_id_tienda; Type: FK CONSTRAINT; Schema: app_tienda; Owner: postgres
--

ALTER TABLE ONLY app_tienda.apti_tiendas_productos
    ADD CONSTRAINT fk_tienda_producto_id_tienda FOREIGN KEY (id_tienda) REFERENCES app_tienda.apti_tiendas(id_tienda) NOT VALID;


-- Completed on 2021-11-26 00:10:11

--
-- PostgreSQL database dump complete
--

