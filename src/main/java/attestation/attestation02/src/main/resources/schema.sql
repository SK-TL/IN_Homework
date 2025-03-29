create table if not exists products (
    id bigserial primary key,
    description text not null,
    price numeric not null,
    quantity int not null
);

comment on table products is 'Таблица Товаров';

create table if not exists buyer (
    id bigserial primary key,
    first_name_last_name text not null
);

comment on table buyer is 'Таблица Покупателей';

create table if not exists orders (
    id bigserial primary key,
    buyer_id bigint references buyer (id),
    product_id bigint references products (id),
    order_date date default now(),
    count_of_orders int not null
);

comment on table orders is 'Таблица Заказов';

insert into products (description, price, quantity) values ('Хлеб', '10', '10');
insert into products (description, price, quantity) values ('Молоко', '20', '20');
insert into products (description, price, quantity) values ('Масло', '30', '30');
insert into products (description, price, quantity) values ('Торт', '40', '40');
insert into products (description, price, quantity) values ('Батон', '50', '50');
insert into products (description, price, quantity) values ('Курица', '60', '60');
insert into products (description, price, quantity) values ('Сгущенка', '70', '70');
insert into products (description, price, quantity) values ('Шоколадка', '80', '80');
insert into products (description, price, quantity) values ('Сметана', '90', '90');
insert into products (description, price, quantity) values ('Конфеты', '100', '100');

insert into buyer (first_name_last_name) values ('Вячеслав Ястребов');
insert into buyer (first_name_last_name) values ('Иван Иванов');
insert into buyer (first_name_last_name) values ('Лидия Петровна');
insert into buyer (first_name_last_name) values ('Марья Ивановна');
insert into buyer (first_name_last_name) values ('Андрей Орлов');
insert into buyer (first_name_last_name) values ('Георгий Васильев');
insert into buyer (first_name_last_name) values ('Алёна Попова');
insert into buyer (first_name_last_name) values ('Елизавета Соколова');
insert into buyer (first_name_last_name) values ('Анастасия Михайлова');
insert into buyer (first_name_last_name) values ('Василий Пупкин');

insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=1), (SELECT id FROM products where products."id" = 1), 1);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=2), (SELECT id FROM products where products."id" = 2), 2);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=3), (SELECT id FROM products where products."id" = 3), 3);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=4), (SELECT id FROM products where products."id" = 4), 4);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=5), (SELECT id FROM products where products."id" = 5), 5);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=6), (SELECT id FROM products where products."id" = 6), 6);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=7), (SELECT id FROM products where products."id" = 7), 7);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=8), (SELECT id FROM products where products."id" = 8), 8);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=9), (SELECT id FROM products where products."id" = 9), 9);
insert into orders (buyer_id, product_id, count_of_orders)
values ((SELECT id FROM buyer where buyer."id"=10), (SELECT id FROM products where products."id" = 10), 10);