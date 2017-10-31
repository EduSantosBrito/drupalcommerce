# Marco - VirtualShop

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5f4ff8ec01914e4e9e2a14c9d70423a5)](https://www.codacy.com/app/alessandromacanha/Marco-VirtualShop?utm_source=github.com&utm_medium=referral&utm_content=macanhajc/Marco-VirtualShop&utm_campaign=badger)

Essa aplicação será desenvolvida como forma de trabalho final para a matéria de DesignPatters ministrada pelo professor Marco Antônio Araujo.

# Virtual Shop
Virtual Shop é um sistema web de e-comerce de eletrônicos.

# Tecnologias
A aplicação web será construida utilizando a linguagem Java, deverá ser desenvolvida utilizando dos padrões de projeto aprendidos em sala.<br />
(Até o momento: Singleton, MVC, DAO, Facade(Front Controller), Action, Factory Method, State, Strategy, Template Method, Observer, Memento).
<br />
<br />
   
# Funcionalidades
  1. O sistema permitira que o usuário possa se cadastrar no site.
  2. O sistema deverá permitir que o usuário cadastrado realize o compras no site.
  3. O sistema deverá conter um carrinho de compras para armazenar os pedidos(Metodos de pagamento: Cartão de crédito e Boleto).
  4. O sistema deverá permitir que o usuário cadastrado visualize o andamento dos seus pedidos(Os estados do pedido são: Em Análise, Em  Atraso, Em Separação, Cancelado e Enviado).

# Padrões
<b>MVC:</b> Padrão utilizado para o desenvolvimento das camadas. <b>FEITO</b>
<br />
<b>Singleton:</b> Utilizações atuais: Criar a conexão com o banco. <b>FEITO</b>
<br />
<b>DAO:</b> Utilizado na aplicacão para realizar o acesso ao banco e a execucão de tarefas. <b>FEITO</b>
<br />
<b>Facade(Front Controller):</b> Utilizado na aplicacão para controlar as ações. <b>FEITO</b>
<br /> 
<b>Action:</b> Será utilizado em conjunto ao Front Controller, controlará as ações do sistema. <b>FEITO</b>
<br />
<b>Factor Method:</b> Será utilizado em conjunto ao Front Controller, auxiliando no redirecionamento para as ações. <b>FEITO</b>
<br />
<b>Strategy:</b> Será utilizado na definicão de promocões, descontos na compra. <b>FEITO</b>
<br />
<b>State:</b> Será utilizado no controle dos estados dos pedidos dos clientes. <b>FEITO</b>
<br />
<b>Template Method:</b> Será utilizado para controlar o algoritimo de descontos de produtos. <b>FEITO</b>
<br />
<b>Observer:</b> Será utilizado para realizar o envio de emails e alertas para o usuário caso o estado de um pedido mude ou um pedido em interesse seja alterado <b>FEITO</b>
<br />
<b>Memento:</b> Será utilizado para controlar o retorno de ações. <b>FEITO</b>
<br />
 # Etapas
 1. Construção dos modelos: <b>FEITO</b>
 2. Construção das telas: <b>FEITO</b>
 3. Construção dos controladores e ações: <b>FEITO</b>
 4. Implementação dos modelos e controladores: <b>FEITO</b>
 5. Construção e Implementação dos padrões mais complexos: <b>FEITO</b>
 6. Migração para Maven: <b>FEITO</b>
