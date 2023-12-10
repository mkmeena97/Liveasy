-- Table: public.loads

-- DROP TABLE IF EXISTS public.loads;

CREATE TABLE IF NOT EXISTS public.loads
(
    load_id integer NOT NULL DEFAULT nextval('loads_load_id_seq'::regclass),
    loading_point character varying(255) COLLATE pg_catalog."default" NOT NULL,
    unloading_point character varying(255) COLLATE pg_catalog."default" NOT NULL,
    product_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    truck_type character varying(255) COLLATE pg_catalog."default" NOT NULL,
    no_of_trucks integer NOT NULL,
    weight integer NOT NULL,
    comment text COLLATE pg_catalog."default",
    shipper_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
    date date NOT NULL,
    CONSTRAINT loads_pkey PRIMARY KEY (load_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.loads
    OWNER to postgres;