# audit-service

Servico de auditoria do Rota Facil. Ele consome eventos dos demais microservicos, persiste registros de acoes relevantes e disponibiliza consulta por prefeitura autenticada, ator e tipo de acao.

## Para que serve

- Registrar acoes de usuarios, prefeituras, arquivos, instituicoes, pontos de embarque, rotas e viagens.
- Centralizar trilha de auditoria assincrona via RabbitMQ.
- Expor consulta HTTP para administradores.

## Porta e base path

- Aplicacao: `audit-service`
- Porta: `8087`
- Context path: `/audit`
- Via gateway: `http://localhost:8080/audit`

## Endpoints principais

- `GET /audit`: lista registros de auditoria da prefeitura do usuario autenticado.

A prefeitura e resolvida pelo header `x-prefecture-id` recebido via gateway.

Query params opcionais:

- `actor`: email do ator.
- `action`: tipo de acao.

Infra:

- `GET /audit/health-check`
- `/audit/v3/api-docs`
- `/audit/swagger-ui.html`

## Eventos consumidos

Exchange `auth.events`:

- `user.created`
- `user.updated`
- `driver.admin.updated`
- `user.deleted`
- `user.email.changed`
- `user.deactivate`
- `user.logout`
- `prefecture.created`
- `prefecture.updated`
- `prefecture.deleted`

Exchange `file.events`:

- `file.created`
- `file.updated`
- `file.deleted`

Exchange `places.events`:

- `institution.created`
- `institution.updated`
- `institution.deleted`
- `boarding.created`
- `boarding.updated`
- `boarding.deleted`

Exchange `transport.events`:

- `route.created`
- `route.updated`
- `route.deleted`
- `trip.running`
- `trip.cancelled`
- `trip.deleted`
- `bus.created`
- `bus.updated`
- `bus.deleted`
- `user.feedback`

## Banco de dados

- Default: `jdbc:postgresql://localhost:5436/audit_database`
- Usuario default: `rota-facil`
- Senha default: `admin`
- Migrations: `src/main/resources/db/migration`
- A tabela `audit_tb` possui `prefecture_id` para segregacao por prefeitura e `created_at` para ordenacao.

## Como rodar

Pre-requisitos:

- Java 21.
- PostgreSQL com banco `audit_database`.
- Eureka.
- RabbitMQ.

Comando:

```bash
cd audit-service
./mvnw spring-boot:run
```

## Especializacao

Este servico deve ser consumidor e consultor de auditoria. Ele nao deve comandar alteracoes nos dominios; recebe eventos e grava historico.
