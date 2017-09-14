# Marco - VirtualShop
Essa aplicação será desenvolvida como forma de trabalho final para a matéria de DesignPatters ministrada pelo professor Marco Antônio Araujo.

# Virtual Shop
Virtual Shop é um sistema web de e-comerce, que permitirá que usuários cadastrados possam criar "mini lojas" e fazer anúncio de seus produtos.

# Tecnologias
A aplicação web será construida utilizando a linguagem Java, deverá ser desenvolvida utilizando dos padrões de projeto aprendidos em sala.<br />
(Até o momento: Singleton, MVC, DAO, Facade(Front Controller), Action, Factory Method, State, Strategy, Template Method, Observer).
<br />
<br />
<b>Frameworks?:</b><br />
   Materialize, Spring
   
# Funcionalidades
  1. O sistema permitira que o usuário possa se cadastrar no site.
  2. O sistema deverá permitir que o usuário cadastrado realize o compras no site.
  3. O sistema deverá conter um carrinho de compras para armazenar os pedidos(Metodos de pagamento: Cartão de crédito e Boleto).
  4. O sistema deverá permitir que o usuário cadastrado visualize o andamento dos seus pedidos(Os estados do pedido são: Em Análise, Na fila/Em espera, Em  Atraso, Em Separação, Cancelado e Finalizado).
  5. O sistema deverá permitir ao usuário a criação de uma "Web loja".
  6. O sistema deverá permitir ao usuário que possui uma "Web loja" realizar o cadastro de produtos para a venda.
  7. O sistema deverá permitir ao usuário que possui uma "Web loja" realizar promoções de seus produtos.
  8. O sistema deverá permitir ao usuário que já possui uma "Web loja" realizar o cadastro de uma nova mediante a um pagamento

# Padroes
<b>MVC:</b> Padrão utilizado para o desenvolvimento das camadas.
<br />
<b>Singleton:</b> Utilizações atuais: Criar a conexão com o banco.
<br />
<b>DAO:</b> Utilizado na aplicacão para realizar o acesso ao banco e a execucão de tarefas.
<br />
<b>Facade(Front Controller):</b> Utilizado na aplicacão para controlar as ações.
<br />
<b>Action:</b> Será utilizado em conjunto ao Front Controller, controlará as ações do sistema.
<br />
<b>Factor Method:</b> Será utilizado em conjunto ao Front Controller, auxiliando no redirecionamento para as ações.
<br />
<b>Strategy:</b> Será utilizado na definicão de promocões, descontos.
<br />
<b>State:</b> Será utilizado no controle dos estados dos pedidos dos clientes.
<br />
<b>Template Method:</b> Será utilizado para controlar o algoritimo de descontos de produtos.
<br />
<b>Observer:</b> Será utilizado para realizar o envio de emails e alertas para o usuário caso uma venda seja realizada ou o estado de um pedido mude.
<br />

# Observações
   <b>Web Lojas</b>: Web lojas são pequenas lojas dentro do site, onde uma pessoa pode realizar o cadastro de produtos para serem expostos a vendas e realizar promoções. Poderão ser criadas de graça, porém o site lucrará com uma porcentagem de cada venda realizada

