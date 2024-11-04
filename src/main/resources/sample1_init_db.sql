drop table if exists cars;

create table cars (
	id bigserial primary key,
	vin varchar(128),
	color varchar(128),
	brand_name varchar(128),
	model_name varchar(128),
	engine_number varchar(128),
	engine_horse_power integer
);