# Hoteliza API

Este projeto é uma API para agendamento de hotéis, desenvolvida em Java, que oferece funcionalidades para gerenciamento de reservas e cadastro de usuários e hotéis. É ideal para sistemas que precisam controlar reservas de quartos e o cadastro de proprietários e usuários interessados em realizar reservas.

## Funcionalidades


- Sistema de cadastro para **proprietários de hotéis**:
- Permite que proprietários registrem seus hotéis na plataforma.
- Sistema de cadastro para **usuários comuns**:
- Permite que realizem agendamentos em hotéis cadastrados por proprietários.
- Verificações das reservas feitas pelo usuário Customer
- Verificação de valores das reservas feitas
- Disponibiliza todos os tipo de quarto para reserva
- Verificações do Owner das reservas feitas pelos usuários Customers 
- Implementa uma **thread** para verificar se o quarto selecionado está disponível ou reservado, garantindo maior eficiência no controle de reservas.

## Como Executar o Projeto

Para executar este projeto localmente, siga os passos abaixo no terminal:

1. Clone o repositório:
   ```bash
   git clone https://github.com/rafaelsouza03/reserva-hoteis-api.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd reserva-hoteis-api-dev
   ```

3. Instale as dependências do projeto:
   ```bash
   mvn clean install
   ```

4. Inicie a aplicação:
   ```bash
   mvn spring-boot:run
   ```

Após executar os comandos acima, a API estará disponível para uso.

## Colaboradores

alunos que contribuíram para a construção deste projeto:

-- **Eric Rafael da Silva Souza**
-- **Davi Alves do Nascimento**
-- **Iago Fernandes Teixeira Rosado**
-- **Rujélio da Costa Lima**
-- **Pedro Henrique Souza Freitas** 
