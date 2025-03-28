select * from orders where count_of_orders = 10;
update orders set count_of_orders = 100 where count_of_orders = 10;
delete from orders where buyer_id = 1;

select * from products where description = 'Хлеб';
update products set description = 'Хлебобулочное Изделие' where description = 'Хлеб';
delete from products where description = 'Хлебобулочное Изделие';

select * from buyer where first_name_last_name = 'Вячеслав Ястребов';
update buyer set first_name_last_name = 'Ястребов Вячеслав' where first_name_last_name = 'Вячеслав Ястребов';
delete from buyer where first_name_last_name = 'Ястребов Вячеслав';
