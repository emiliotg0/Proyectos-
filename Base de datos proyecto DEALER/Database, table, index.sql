Create database dealer;
Use dealer;

create table sucursales(
id_sucursal int not null primary key,
telefono bigint,
direccion varchar(255)
)

create table cliente (
id_cliente int not null primary key,
Nombre varchar (125),
Apellidos varchar (125),
Direccion varchar (255),
Telefono BIGINT not null,
Cedula BIGINT not null,
Dir_empleo varchar (255)
)
create index idx_cliente on cliente(id_cliente,Cedula)

create table empleado(
Id_empleado int not null primary key,
Nombre varchar (125),
Apellidos varchar (125),
Cargo varchar(125),
Sueldo int,
FK_sucursal int foreign key references sucursales(id_sucursal)
)
create index idx_empleado on empleado(Id_empleado,FK_sucursal)

create table vehiculos (
ID_vehiculo int not null primary key,
Marcha varchar(20),
Modelo varchar(20),
Color varchar(20),
Placa varchar(7),
Chasis varchar(17),
yr int,
FK_sucursal int foreign key references sucursales(id_sucursal)
)
create index idx_vehiculo on vehiculos(ID_vehiculo,placa,chasis)

create table financiamiento(
id_financiamiento int not null primary key,
n_contrato int,
monto int,
FK_cliente int foreign key references cliente(id_cliente),
garantia varchar(255),
nombre_garante varchar(125),
tel_garante bigint,
c_pagare int,
valor_pagare int,
vigencia date,
fecha_venc_pagare date,
)
create index idx_financiamiento on financiamiento(id_financiamiento,n_contrato,FK_cliente)
create table gastos(
id_gastos int not null primary key,
monto bigint,
Descripcion varchar(255),
fecha date,
FK_sucursal int foreign key references sucursales(id_sucursal)
)
create index idx_gastos on gastos (id_gastos,FK_sucursal)
create table ingresos(
id_ingresos int not null primary key,
monto bigint,
Descripcion varchar(255),
fecha date,
FK_sucursal int foreign key references sucursales(id_sucursal)
)

create index idx_ingresos on ingresos(id_ingresos,Fk_sucursal)
create table atendido(
FK_empleado int foreign key references empleado(Id_empleado),
FK_cliente int foreign key references cliente(id_cliente),
fecha date)

