# EICON API - Gestor de Pedidos

## Visão Geral
Esse projeto é uma API REST para recepcionar pedidos dos clientes no formato xml e json com 6 campos:
1. Número de controle - número aleatório informado pelo cliente.
2. Data de cadastro (opcional).
3. Nome do produto.
4. Valor monetário unitário do produto.
5. Quantidade de produtos (opcional).
6. Codigo do cliente - identificação numérica do cliente.

## Critérios aceitação e manipulação do arquivo:
* O arquivo pode conter 1 ou mais pedidos, limitado a 10.
* Não poderá aceitar um número de controle já cadastrado.
* Caso a data de cadastro não seja enviada o sistema deve assumir a data atual.
* Caso a quantidade não seja enviada considerar 1.
* Caso a quantidade seja maior que 5 aplicar 5% de desconto no valor total, para quantidades a partir de 10 aplicar 10% de desconto no valor total.
* O sistema deve calcular e gravar o valor total do pedido.
* Assumir que já existe 10 clientes cadastrados, com códigos de 1 a 10.

### Criar um serviço onde possa consultar os pedidos enviados pelos clientes.
* O retorno deve trazer todos os dados do pedido.
* Filtros da consulta: número pedido, data cadastro, todos

## Tecnologias e Padrões Utilizados

* Clean Architecture
* Spring Boot 3.1.2 / Java 17
* Swagger UI (springdoc)
* Lombok
* MapStruct
* Mockito Framework
* Fixture Factory
* Docker e Docker Compose
* Banco de MySQL 8.0

## Executando o Projeto

### Instalar Docker
https://docs.docker.com/get-docker/

### Após instalação do Docker, seguir os passos:
1. Clonar este repositório
2. Vá para o diretório raiz do projeto: cd ./api-pedidos-eicon
3. Rodar o comando: docker-compose up

### Verificando imagens docker rodando
```
docker ps
```
Para visualizar a documentação Swagger, acesse: http://localhost:8080/swagger-ui.html

## CURL para teste via postman

* Cadastro de pedido com JSON
```
curl --location 'http://localhost:8080/v1/pedidos' \
--header 'Content-Type: application/json' \
--data '{
    "pedidos": [
        {
            "numeroControle": 1,
            "dataCadastro": "2024-01-12",
            "produtos": [
                {
                    "nome": "Monitor",
                    "valorUnitario": 20.75,
                    "quantidade": 6
                }
            ],
            "codigoCliente": 1
        }
    ]
}'
```

* Cadastro de pedido com XML
```
curl --location 'http://localhost:8080/v1/pedidos' \
--header 'Content-Type: application/xml' \
--data '<?xml version="1.0" encoding="UTF-8"?>
<root>
   <pedidos>
      <element>
         <numeroControle>2</numeroControle>     
         <dataCadastro>2024-01-12</dataCadastro>         
         <produtos>
            <element>
               <nome>Monitor</nome>
               <quantidade>6</quantidade>
               <valorUnitario>20.75</valorUnitario>
            </element>
         </produtos>
         <codigoCliente>1</codigoCliente>
      </element>
   </pedidos>
</root>'
```

* Listar todos os pedidos
```
curl --location 'http://localhost:8080/v1/pedidos'
```

* Buscar pedido pelo numero de controle
```
curl --location 'http://localhost:8080/v1/pedidos/3'
```

* Filtrar pedidos pela data de cadastro
```
curl --location 'http://localhost:8080/v1/pedidos/filtro?dataCadastro=2024-01-12'
```