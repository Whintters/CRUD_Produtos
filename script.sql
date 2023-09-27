create table produtos (
id int not null auto_increment primary key,
nome varchar(30) not null,
preco double not null,
categoria varchar(30) not null,
dataCadastro date not null,
dataVenda date,
dataFabricacao date not null,
dataValidade date,
ingredientes varchar(30) not null)