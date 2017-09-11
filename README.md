# Marco - VirtualStiker
Essa aplicação será desenvolvida como forma de trabalho final para a matéria de DesignPatters ministrada pelo professor Marco Antônio Araujo.

# Virtual Stiker
Virtual Stiker é um sistema web que permite um usuário realizar o pedido de adesivos e estampas online, podendo tanto enviar seus próprios adesivos quanto solicitar a criação de um novo.

# Tecnologias
A aplicação web será construida utilizando a linguagem Java e o padrao MVC, deverá ser desenvolvida utilizando dos padrões de projeto aprendidos em sala.
(Até o momento: MVC, Singleton, DAO, Front Controller, Factory Method, Action, Strategy, State).
<br />
<br />
<b>Frameworks?:</b><br />
   Materialize, Spring
   
# Funcionalidades
  1. O sistema permitira que o usuário possa se cadastrar no site.
  2. O sistema deverá permitir que o usuário cadastrado realize o pedido de adesivos ou estampas em lotes.
  3. O sistema deverá conter um carrinho de compras para armazenar os pedidos(Metodos de pagamento: Cartão de crédito e Boleto).
  4. O sistema deverá permitir que o usuário cadastrado visualize o andamento dos seus pedidos de adesivos(Os estados do pedido são: Em Análise, Na fila/Em espera, Em  Atraso, Em Fabricação, Cancelado e Finalizado).
  5. O sistema deverá permitir ao usuário cadastrado realizar o envio de uma imagem para a impressão.
  6. O sistema deverá permitir ao usuário opitar pela criação de uma imagem informando suas ideias a respeito da imagem, após isso será gerada uma cobrança para a criação da mesma(Metodos de pagamento: Cartão de crédito e Boleto). 
  7. O sistema deverá permitir ao usuário realizar a avaliação da imagem criada, podendo pedir alterações na mesma.
  8. O sistema deverá alertar o usuário quando a criação da sua imagem for finalizada(E-mail).
  
# Padroes
   MVC: Padrão utilizado para o desenvolvimento das camadas.
<br />
   Singleton: Utilizacoes atuais: Criar a conexão com o banco.
<br />
   DAO: Utilizado na aplicacão para realizar o acesso ao banco e a execucão de tarefas.
<br />
   Front Controller: Utilizado na aplicacão para controlar as ações.
<br />
   Facade: Será utilizado em conjunto ao Front Controller e os Action.
<br />
   Action: Será utilizado em conjunto ao Front Controller, controlará as ações do sistema.
<br />
   Strategy: Sera utilizado na definicão de promocões, descontos por compra em lotes.
<br />
   State: Utilizado para controlar os estados dos pedidos dos clientes(Compras e Imagem).
<br />
   Template Method: Será utilizado na forma de exibicão dos produtos em destaque.
<br />
   Observer: ?
<br />
