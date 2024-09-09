create table renda_fixa_ativo
(
    id              bigserial primary key,
    emissor         varchar(255) not null,
    tipo            varchar(255) not null,
    indexador       varchar(255) not null,
    taxa            bigint       not null,
    data_compra     date         not null,
    data_vencimento date         not null,
    valor_investido bigint       not null,
    data_venda      date,
    valor_liquidado bigint
);

GRANT ALL ON SEQUENCE renda_fixa_ativo_id_seq TO stakfin_user;
