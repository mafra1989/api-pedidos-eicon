insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (1,'2022-01-12',41.50,1)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Monitor',2,20.75,1)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (1,1)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (2,'2022-01-12',41.50,2)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Teclado',2,20.75,2)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (2,2)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (3,'2022-01-12',41.50,3)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Mouse',2,20.75,3)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (3,3)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (4,'2022-01-12',41.50,4)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Pen Drive',2,20.75,4)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (4,4)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (5,'2022-01-12',41.50,5)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Relógio',2,20.75,5)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (5,5)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (6,'2022-01-12',41.50,6)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Carteira',2,20.75,6)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (6,6)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (7,'2022-01-12',41.50,7)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Agenda',2,20.75,7)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (7,7)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (8,'2022-01-12',41.50,8)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'SmartPhone',2,20.75,8)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (8,8)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (9,'2022-01-12',41.50,9)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Boné',2,20.75,9)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (9,9)

insert into tb_pedido (codigo_cliente,data_cadastro,valor_total,numero_controle) values (10,'2022-01-12',41.50,10)
insert into tb_produto (desconto,nome,quantidade,valor_unitario,id) values (0,'Bicicleta',2,20.75,10)
insert into tb_pedido_produtos (pedido_numero_controle,produtos_id) values (10,10)

update tb_produto_seq set next_val= 11