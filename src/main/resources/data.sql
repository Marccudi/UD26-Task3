#create database UD26T3;
#use UD26T3;
drop table if exists venta;
drop table if exists productos;
drop table if exists cajeros;
drop table if exists maquinas_registradoras;

create table maquinas_registradoras(
	codigo int auto_increment,
    piso int,
    primary key (codigo)
);

create table cajeros(
	codigo int auto_increment,
    nomapels varchar(255),
    primary key (codigo)
);
create table productos(
	codigo int auto_increment,
    nombre varchar(100),
    precio int,
    primary key (codigo)
);

create table venta(
	id int auto_increment,
	cajero int,
    maquina int,
    producto int,
    primary key (id, cajero, maquina, producto),
    foreign key (cajero) references cajeros(codigo),
    foreign key (maquina) references maquinas_registradoras(codigo),
    foreign key (producto) references productos(codigo)    
);


insert into cajeros(nomapels) values('1');
insert into cajeros(nomapels) values('2');

insert into maquinas_registradoras(piso) values(1);
insert into maquinas_registradoras(piso) values(2);

insert into productos(nombre, precio) values('patata', 10);
insert into productos(nombre, precio) values('papadelta', 10);

insert into venta(cajero, maquina, producto) values(1, 1, 1);
insert into venta(cajero, maquina, producto) values(2, 2, 2);
