create table if not exists buyer (
    id bigserial primary key,
    first_name_last_name text not null
);

create table if not exists orders (
    id bigserial primary key,
    buyer_id bigint references buyer (id),
    order_date date default now(),
    count int not null,
    discount int
);