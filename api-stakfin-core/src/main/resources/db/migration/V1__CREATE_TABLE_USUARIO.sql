create table usuario
(
    id    bigserial primary key,
    email varchar(255) not null UNIQUE,
    nome  varchar(100) not null
);


