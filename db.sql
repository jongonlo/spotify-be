{\rtf1\ansi\ansicpg1252\cocoartf2821
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 -- Table: public.track\
\
-- DROP TABLE IF EXISTS public.track;\
\
CREATE TABLE IF NOT EXISTS public.track\
(\
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),\
    name text COLLATE pg_catalog."default",\
    artist_name text COLLATE pg_catalog."default" NOT NULL,\
    album_id text COLLATE pg_catalog."default",\
    is_explicit boolean,\
    playback_seconds integer,\
    isrc text COLLATE pg_catalog."default" NOT NULL,\
    album_name text COLLATE pg_catalog."default",\
    cover text COLLATE pg_catalog."default",\
    CONSTRAINT track_pkey PRIMARY KEY (id)\
)\
\
TABLESPACE pg_default;\
\
ALTER TABLE IF EXISTS public.track\
    OWNER to postgres;}