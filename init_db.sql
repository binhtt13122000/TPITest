CREATE TABLE public.execution_record
(
    serno             serial NOT NULL,
    serviceName       varchar(127) NOT NULL,
    msgid             varchar(63) NOT NULL,
    requestPayload    varchar(65535) NOT NULL,
    request_timestamp timestamp NOT NULL,
    CONSTRAINT execution_record_pk PRIMARY KEY (serno)
);