## Instalação do PostgreSQL

1. [Instalar clientes do PostgreSQL](#instalar-clientes-do-postgresql)
    1. [Instalar cliente de terminal do PostgreSQL](#instalar-cliente-de-terminal-do-postgresql)
    1. [Instalar pgAdmin4 (cliente web) localmente](#instalar-pgadmin4-cliente-web-localmente)
1. Execute uma das opções abaixo:
    1. [Opção 1: Instalar servidor PostgreSQL localmente](#opção-1-instalar-servidor-postgresql-localmente)
    1. [Opção 2: Instalar servidor PostgreSQL no Supabase](#opção-2-instalar-servidor-postgresql-no-supabase)
    1. [Opção 3: Instalar servidor PostgreSQL e pgAdmin4 no docker](#opção-3-instalar-servidor-postgresql-e-pgadmin4-no-docker)
1. [Criar e restaurar banco de dados `dvdrental`](#criar-e-restaurar-banco-de-dados-dvdrental)
1. [Compilar e rodar programa que conecta no banco de dados](#compilar-e-rodar-programa-que-conecta-no-banco-de-dados)

## Instalar clientes do PostgreSQL

### Instalar cliente de terminal do PostgreSQL

- Instalar o cliente do PostgreSQL
```bash
sudo apt install -y postgresql-common
sudo /usr/share/postgresql-common/pgdg/apt.postgresql.org.sh
sudo apt update
sudo apt install postgresql-client
```

- Verificar se a instalação foi bem sucedida
```bash
psql --version
```

### Instalar pgAdmin4 (cliente web) localmente

- Instalar pgAdmin4
```bash
curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg
sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'
sudo apt install pgadmin4-web
```

- Configuar o pgAdmin
```bash
export PGADMIN_SETUP_EMAIL="admin@admin.com"
export PGADMIN_SETUP_PASSWORD="admin"

sudo -E /usr/pgadmin4/bin/setup-web.sh
```

- Alterar a porta para rodar o pgAdmin para 8888
```bash
sudo nano /etc/apache2/ports.conf
```

- Adicionar a configuração `ServerName localhost` ao final do arquivo
```bash
sudo nano /etc/apache2/apache2.conf
```

- Reiniciar o serviço
```bash
sudo service apache2 start
```
- Acesse no browser o endereço http://localhost:8888/pgadmin4

## Instalar servidor do PostgreSQL

### Opção 1: Instalar servidor PostgreSQL localmente

- Instalar o PostgreSQL
```bash
sudo apt install postgresql
```

- Iniciar o serviço do PostgreSQL
```bash
sudo service postgresql start
```

- Se necessário, definir a senha inicial do usuário postgres
```bash
sudo -u postgres psql
```

```bash
postgres=#  \password postgres
```

Caso o comando `sudo -u postgres psql` solicite senha do root e você não tenha, alterar o tipo de conexão para `trust` executando o comando abaixo

```bash
sudo nano /etc/postgresql/18/main/pg_hba.conf
```

- Verificar instalação
```bash
pg_config --version
```

### Opção 2: Instalar servidor PostgreSQL no Supabase

- Criar conta no [Supabase](https://supabase.com/)

- Criar nova organização

- Criar novo projeto

- No topo da página, clicar em `connect`. Na aba `Connection String`, escolher os seguintes parâmetros:
    - Type: `URI`
    - Source: `Primary Database` 
    - Method: `Session Provider`

- Clicar na opção `View Parameters` e anotar os parâmetros (`host`, `port`, `database`, `user`)

### Opção 3: Instalar servidor PostgreSQL e pgAdmin4 no docker
```bash
docker-compose up -d
```

## Conectar no servidor PostgreSQL

- Conectar no servidor usando o cliente de banco de dados, com os parâmetros abaixo (se estiver usando docker ou supabase adaptar valores):
    - HOST: `localhost`
    - PORT: `5432`
    - USER: `postgres`
    - DATABASE: `postgres`

```bash
psql -h [HOST] -p [PORT] -U [USER] -d [DATABASE]
postgres=> \l
postgres=> exit
```

## Criar e restaurar banco de dados `dvdrental`

- Conectar no servidor PostgreSQL
```bash
psql -h [HOST] -p [PORT] -U [USER] -d [DATABASE]
postgres=> \l
postgres=> exit
```

- Criar banco de dados `dvdrental`
```bash
postgres=# CREATE DATABASE dvdrental;
postgres=# \l
postgres=# exit
```

- Baixar o banco de dados de exemplo
```bash
/14-jdbc> mkdir db
/14-jdbc> cd db
/14-jdbc/db> wget https://neon.com/postgresqltutorial/dvdrental.zip
/14-jdbc/db> sudo apt install unzip
/14-jdbc/db> unzip dvdrental.zip
```

- Restaurar o banco de dados. Se necessário, adaptar nome do servidor e porta
```bash
/14-db/db> pg_restore -h [HOST] -p [PORT] -U [USER]  -d dvddental -v dvdrental.tar --no-owner --clean --if-exists
```

- Testar conexão com banco
```bash
psql -h [HOST] -p [PORT] -U [USER] -d dvdrental
```

- Realizar consulta de verificação

```bash
postgres=> SELECT * FROM ACTOR;
postgres=> exit
```

## Compilar e rodar programa que conecta no banco de dados

- Criar arquivo `db.properties` a partir do arquivo exemplo `db.properties.sample` e atualizar valores
```bash
url=jdbc:postgresql://[HOST]:5432/postgres
user=[USER]
password=[PASSWORD]
```

- Baixar driver de conexão com o PostgreSQL
```bash
/14-db> mkdir lib
/14-db> cd lib/
/14-db/lib> wget https://jdbc.postgresql.org/download/postgresql-42.7.8.jar
```

- Compilar e rodar programa

Substituir [PROGRAM] pelo nome do programa que deja rodar.

```bash
/14-db> javac -d bin src/[PROGRAM].java
/14-db> java -cp bin:lib/* [PROGRAM]
```
