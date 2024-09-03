create table purchase_order
(
    id             bigserial primary key,
    purchase_id    varchar(100) not null UNIQUE,
    status         varchar(20)  not null,
    buyer          jsonb        not null,
    seller         jsonb        not null,
    payment_detail jsonb        not null,
    metadata       jsonb
);

