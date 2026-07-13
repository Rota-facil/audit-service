# audit-service

Serviço de auditoria do Rota Fácil. Consome eventos dos domínios, normaliza o ator, persiste a trilha por prefeitura e disponibiliza consulta administrativa.

## Porta e API

- Porta: `8087`
- Context path: `/audit`
- Via gateway: `http://localhost:8080/audit`
- `GET /audit`: lista registros da prefeitura autenticada.
- Filtros opcionais e combináveis: `actor` e `action`.
- Infra: `GET /audit/health-check`, `/audit/v3/api-docs`, `/audit/swagger-ui.html`.

A rota exige `ADMIN` ou `SUPERUSER`. O `prefectureId` vem sempre do usuário autenticado.

## Contrato de evento

O consumidor usa `AuditEventReceive`. Quando `actorUserId`, `actorEmail` e `actorRole` existem, eles são o autor real; caso contrário, o mapper usa `userId`, `userEmail/email` e `role`.

## Eventos consumidos

- `auth.events`: `user.created`, `user.updated`, `driver.admin.updated`, `user.deleted`, `user.email.changed`, `user.deactivate`, `user.logout`, `prefecture.created`, `prefecture.updated`, `prefecture.deleted`.
- `places.events`: CRUD de `institution.*` e `boarding.*`.
- `transport.events`: CRUD de `route.*` e `bus.*`, `trip.running`, `trip.cancelled`, `trip.deleted` e `user.feedback`.
- `file.events`: `file.created`, `file.updated`, `file.deleted`.

Filas por exchange: `audit.auth.queue`, `audit.places.queue`, `audit.transport.queue` e `audit.file.queue`.

## Persistência

- Banco: `jdbc:postgresql://localhost:5436/audit_database`
- Usuário padrão: `rota-facil`
- Migrations: `src/main/resources/db/migration`
- Hibernate: `ddl-auto=validate`

## Como rodar

```bash
cd audit-service
./mvnw spring-boot:run
```

Requer Java 21, PostgreSQL, Eureka e RabbitMQ. O serviço registra fatos já ocorridos e não comanda outros domínios.
