create table cities (state_id integer not null, id bigint not null auto_increment, population bigint, name varchar(255) not null, population_class varchar(255), state_name varchar(255), type varchar(255), primary key (id)) engine=InnoDB;
create table states (id integer not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
alter table states add constraint UKnau09mwrvhjj0n0a6gfo5xmp3 unique (name);
alter table cities add constraint FKsu54e1tlhaof4oklvv7uphsli foreign key (state_id) references states (id);
