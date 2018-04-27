# Ramon Vaz de Mello Larivoir - 201776018 - Sistemas de Informação

---

### Cenário
- Este trabalho foi desenvolvido para o cenário de uma lanchonete onde o usuário inicia um novo pedido indicando a mesa e qual será o primeiro item, além da quantidade e o preço.

---

### Modelo de dados
- Foram criadas as classes de **Mesa**, **Pedido** e **Item**, cada uma com suas próprias variaveis.
- Foram criadas as classes de **ListaDeMesas** e **ListaDePedidos** onde são armazenadas todas as mesas existentes e pedidos novos e existentes.
- Foram criadas as classes de **PedidoServlet** e **ItemServlet**. O *PedidoServlet* faz o tratamento das requisições e respostas para a manipulação dos pedidos, como a criação de novo pedido, a listagem e o fechamento de um pedido. O *ItemServelet* faz o tratamento das requisições e respostas para a manipulação dos item, como a adição de um novo item no pedido e a listagem dos itens do pedido.

---

### Construção das telas
- PedidoServlet
  - Esta classe redireciona o usuário para as páginas *index.html*, *novo-pedido.html*, *lista-pedidos.html* e *finalizar-pedido.html*.
  - Faz o tratamento dos dados recebidos pelo formulário de cadastro de novo pedido pelo método **POST** e acidiona os itens para o novo pedido e adiciona o novo pedido na lista de pedidos.
  - Para finalizar um pedido, esta classe faz a verificação se o pedido já está fechado ou se ainda está aberto. Se estiver aberto faz o fechamento e exite a lista dos pedidos com o pedido ja finalizado. Se estiver fechado redireciona o usuário para uma página que informa que o pedido já está fechado.
- ItemServlet
  - Esta classe redireciona o usuário para as páginas *lista-itens.html* e *adiciona-item.html*.
  - Caso o usuário clique para adicionar um item em um pedido já finalizado, esta classe faz esta verificação e caso o pedido esteja finalizado redireciona o usuário para uma página com esta informação, impossibilitando de adicionar novos item a este pedido. Esta mesma verificação é feita na validação do formulário de adicionar novo item ao pedido.
  - Na listagem dos itens, esta classe faz a soma dos valores dos itens e gera o total através da função ***listaItens***.
  
---

### Interface
- A página inicial deve possuir dois botões *"Novo Pedido"*, que levará para a página que cria um novo pedido, e *"Lista de Pedidos"*, que levará para a página que lista todos os pedidos registrados.
- Existe um menu de navegação na parte superior de todas as páginas com as opções para a página inicial, novo pedido e listagem dos pedidos.
- A página de *Novo Pedido* contém um formulário para a criação de um novo pedido com todos os campos obrigatórios.
- A página de *Lista de Pedidos* exibe uma tabela com todos os pedidos registrados onde é possível finalizar o pedido, adicionar novo item ou vizualizar os itens.
- A página de *Lista  de Itens* exite uma tabela com todos os itens do pedido.

---

### Dificuldades
- Uma dificuldade foi tentar passar através do método **POST** o id do pedido para a listagem dos itens para que possa bloquear algum tipo de erro que o usuário tente forçar. Porém, no final, foi adotado o método de **GET** para passar o id do pedido por parâmetro.

---

### Melhorias Futuras
- Uma coisa que pode ser melhorada é a alteração e exclusão dos itens dos pedidos.
- Outra melhoria pode ser a criação de um formulário para a adição de novas mesas no sistema.
- Pode ser pensado uma forma de passar o id do pedido por parâmetro através do método **POST** para a listagem dos itens.
