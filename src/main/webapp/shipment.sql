
create table shipment(ship_num int primary key not null,ext_num varchar(32) not null,create_time timestamp,pickup_loc varchar(32),pickup_time timestamp,pickup_sla timestamp,del_loc varchar(32),del_time timestamp,del_sla timestamp,status int)

CREATE SEQUENCE seq_ship_num
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;