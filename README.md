# EICON API - Gestor de Pedidos

## Visão Geral
Esse projeto é uma API REST para recepcionar pedidos dos clientes no formato xml e json com 6 campos:
1. Número de controle - número aleatório informado pelo cliente.
2. Data de cadastro (opcional).
3. Nome do produto.
4. Valor monetário unitário do produto.
5. Quantidade de produtos (opcional).
6. Codigo do cliente - identificação numérica do cliente.

## Tecnologias e Padrões Utilizados

* Clean Architecture
* Spring Boot 3.1.2
* Swagger UI (springdoc)
* Lombok
* MapStruct
* Mockito Framework
* Fixture Factory
* Docker e Docker Compose
* Banco de Dados H2

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

