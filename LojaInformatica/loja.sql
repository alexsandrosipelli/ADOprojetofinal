CREATE schema  lojainformatica; 

use lojainformatica;
CREATE TABLE computador(
numeroDoComputador int primary key auto_increment,
marca varchar(20) NOT NULL,
Processador varchar(20) NOT NULL,
hd varchar(20) NOT NULL
);
 
 select * from computador;
 