drop table if exists glass;
drop table if exists car;

create table car (
	id bigserial primary key,
	vin varchar(128),
	color varchar(128),
	brand_name varchar(128),
	model_name varchar(128),
	engine_number varchar(128),
	engine_horse_power integer
);

create table glass (
	car_id bigserial references car(id),
	glass_number varchar(128)
)

