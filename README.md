# Prova Tokio Marine

Repositório de versionamento da aplicação relacionada ao processo de avaliação e conhecimento da empresa Tokio Marine.

## Sobre a Aplicação

Esta aplicação foi desenvolvida utilizando a linguaguem [java](https://www.java.com/pt-BR/) e o framework [spring Boot](https://docs.spring.io/spring-boot/index.html)

## Versões

A aplicação utiliza as seguintes versões:

| Software | Versão |
| --- | --- |
| JDK | 11.0.12 |

## Executar aplicação local

No diretório raiz desse repositório, execute o comando abaixo num termina bash:

``` sh
mvn clean install &&
mvn spring-boot:run
```

Se a instalação ocorrer com sucesso, estará disponível no host: __http://localhost:8080__

## Consumo API

Essa aplicação disponibiliza duas api com operações CRUD ( create, read, update e delete):

- http://localhost:8080/clients/
- http://localhost:8080/addresses/

Na raiz desse projeto esta disponível o arquivo *desafio-tokio.postman_collection*, uma coleção postman com os recursos e verbos http mapeados.