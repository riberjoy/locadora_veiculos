<br>
  <h2>Locadora de Veículos</h2>
<br>

<!-- What is: -->

## O que é Locadora Veículos?

O sistema Locadora, é uma microserviço responsável por realizar todo o processo de locação de um veículo
podendo armazenar seus clientes, veiculos, tipos de veículos, dados de funcionarios.
Este microserviço foi divido em cinco 5 API com responsábilidades destintas, sendo elas:

**Cliente**
<br>
Responsável por armazenar toda informação dos clientes da locadora, como nome, cnh, endereço e telefone. Podendo
também atualizar e buscar informações de qualquer cliente em especifico.

**Funcionario**
<br>
Responsável por armazenar toda informação dos funcionarios que trabalham na locadora, como nome, telefone, RG e CPF. Podendo
também habilitar e desabilitar um funcionario caso ele seja desligado ou recontratado pela equipe, também responsável por 
também atualizar e buscar informações de qualquer funcionario em especifico.

**Veículo**
<br>
Responsável por armazenar toda informação dos veículos da locadora, como marca, modelo, ano, placa, cor e tipo. Podendo
também atualizar e buscar informações de qualquer veículo em especifico.

**Tipo de veículo**
<br>
Responsável por armazenar toda informação dos tipos de veículo da locadora, como nome e preço. Podendo
também atualizar e buscar informações de qualquer tipo de veiculo em especifico.

**Locação**
<br>
Responsável por armazenar toda informação das locações da locadora, como funcionario, cliente, veiculo, odometro,
data saída e chegada, combustivel, tempo de locação. Podendo também atualizar e buscar informações de qualquer 
locação em especifico.



<!-- Tecnologics: -->

## Principais tecnologias utilizadas?

- **Java String:** - Framework utilizado para o desenvolvimento.
- **Java:** Linguagem de programação escolhida para realizar a solução.
- **Lombok:** Framework que auxilia no desenvolvimento.
- **Swagger:** API de desenvolvimento, utilizada como documentação.
- **Mongo:** Software de banco de dados.

<!-- Get Started / Install: -->

## Começar

Pré requisitos: Para rodar o projeto em sua maquina, você precisa ter a configuração e instalação completa
do Java Spring na sua maquina, recomendo a instalação e configuração por este link (https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html)

1. Instalar
   [Git](http://git-scm.com/downloads) e
   [NodeJS](http://nodejs.org/download/),
   no caso de você não tiver nenhum deles.

2. Clone o repositorio:

   ```sh
   $ git clone https://github.com/riberjoy/locadora_veiculos.git
   ```

3. Configure o Mongo:

   Nesta etapa você precisará colocar a configuração do seu Mongo para habilitar os cadastros e buscas da api
   
   Entre dentro do arquivo **application.yml**
   
   E configure sua **uri**
   
   ```sh
     mongodb:
              uri: --sua-uri-aqui--
   ```
   
4. Dependências

   Verifique se seu editar não precisa baixar nenhuma dependência utilizada no projeto.

5. Finalmente rodar:

   Entre dentro do arquivo principal **Main** da api desejada e rode seu microserviço desejado, atravez da opção **Run main()**

   Prontinho, agora é só aproveitar :D

<!-- Create by: -->

## Quem está por trás disso?

Desenvolvedores apaixonados por programação e tecnologias.

**Criado por**:

- [Joyce Ribeiro](https://github.com/riberjoy)
- [Hyan Kelwin](http://github.com/hyankelwin)
- [Leonardo Neves](https://github.com/neves-c-leonardo)
