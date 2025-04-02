create table if not exists users (
    id bigserial primary key,
    first_name_last_name text not null
);

create table if not exists orders (
    id bigserial primary key,
    users_id bigint references users (id) on delete cascade,
    order_date date default now(),
    count_of_orders int not null,
    discount int not null
);

insert into users (first_name_last_name) values ('Покупатель №1');
insert into users (first_name_last_name) values ('Покупатель №2');
insert into users (first_name_last_name) values ('Покупатель №3');
insert into users (first_name_last_name) values ('Покупатель №4');
insert into users (first_name_last_name) values ('Покупатель №5');

insert into orders (users_id, count_of_orders, discount)
values ((SELECT id FROM users where users."id"=1), 1, 1);

insert into orders (users_id, count_of_orders, discount)
values ((SELECT id FROM users where users."id"=2), 2, 2);

insert into orders (users_id, count_of_orders, discount)
values ((SELECT id FROM users where users."id"=3), 3, 3);

insert into orders (users_id, count_of_orders, discount)
values ((SELECT id FROM users where users."id"=4), 4, 4);

insert into orders (users_id, count_of_orders, discount)
values ((SELECT id FROM users where users."id"=5), 5, 5);
