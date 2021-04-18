# Gestão de Horas




[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)





## Features

- Registrar Entradas e Saídas durante Período
- Atualizar horário de lançamento


## Instalação





```sh
git clone https://github.com/GuilhermeJunior/gestao-horas.git
cd gestao-horas
mvn spring-boot:run
Acesse os endpoints através da url http://localhost:8080
```


## Endpoints
- GET localhost:8080/api/lancamentos
- POST localhost:8080/api/lancamentos
- PUT localhost:8080/api/lancamentos/{id}

## Testes

- Sugiro a utilização do Postman Para testar os endpoints
Segue um json para testar o endpoint Post
```json
{
  "data": "10-04-2021",
  "periodo": "MANHA",
  "tipoLancamento": "ENTRADA",
  "horario": "08:00",
  "funcionario": {
    "id": 1
  }
}
```


