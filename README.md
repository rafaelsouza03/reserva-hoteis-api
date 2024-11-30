# Hoteliza API

Este projeto é uma API para agendamento de hotéis, desenvolvida em Java, que oferece funcionalidades para gerenciamento de reservas e cadastro de usuários e hotéis. É ideal para sistemas que precisam controlar reservas de quartos e o cadastro de proprietários e usuários interessados em realizar reservas.

## Funcionalidades

### Agendamento de Hotéis
- Permite que usuários agendem hotéis e seus respectivos quartos.
- Disponibiliza opções de quartos, como:
  - Quarto Single
  - Suíte Presidencial
  - Suíte Executiva
  - Suíte Júnior
  - Apartamento
  - Quarto de Casal Deluxe
  - Quarto Twin
  - Quarto de Casal

### Verificação de Disponibilidade
- Implementa uma **thread** para verificar se o quarto selecionado está disponível ou reservado, garantindo maior eficiência no controle de reservas.

### Cadastro de Usuários e Proprietários
- Sistema de cadastro para **proprietários de hotéis**:
  - Permite que proprietários registrem seus hotéis na plataforma.
- Sistema de cadastro para **usuários comuns**:
  - Permite que realizem agendamentos em hotéis cadastrados por proprietários.

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

- **Carlos Eduardo**
- **Eric Rafael**
- **Davi Alves**
- **Iago Rosado**
- **Pedro Henrique Souza**
- **Rujélio Lima**

