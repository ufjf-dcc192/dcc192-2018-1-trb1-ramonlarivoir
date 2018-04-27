# Ramon Vaz de Mello Larivoir - 201776018 - Sistemas de Informação

---

### Cenário
- Este trabalho foi desenvolvido para o cenário de uma lanchonete onde o usuário inicia um novo pedido indicando a mesa e qual será o primeiro item, além da quantidade e o preço.

---

### Modelo de dados
- Foram criadas as classes de **Mesa**, **Pedido** e **Item**, cada uma com suas próprias variaveis.
- Foram criadas as classes de **ListaDeMesas** e **ListaDePedidos** onde são armazenadas todas as mesas existentes e pedidos novos e existentes.
- Foram criadas as classes de **PedidoServlet** e **ItemServlet**. O *PedidoServlet* faz o tratamento das requisições e respostas para a manipulação dos pedidos, como a criação de novo pedido, a listagem e o fechamento de um pedido. O *ItemServelet* faz o tratamento das requisições e respostas para a manipulação dos item, como a adição de um novo item no pedido e a listagem dos itens do pedido.

### Construção das telas
- PedidoServlet
  - Esta classe redireciona o usuário para as páginas *index.html*, *novo-pedido.html*, *lista-pedidos.html* e *finalizar-pedido.html*
  - Faz o tratamento dos dados recebidos pelo formulário de cadastro de novo pedido pelo método **POST** e acidiona os itens para o novo pedido e adiciona o novo pedido na lista de pedidos

### Interface
- A página inicial deve possuir dois botões *"Novo Pedido"*, que levará para a página que cria um novo pedido, e *"Lista de Pedidos"*, que levará para a página que lista todos os pedidos registrados.
- Existe um menu de navegação na parte superior de todas as páginas com as opções para a página inicial, novo pedido e listagem dos pedidos.
- A página de *Novo Pedido* contém um formulário para a criação de um novo pedido com todos os campos obrigatórios.
- A página de *Lista de Pedidos* exibe uma tabela com todos os pedidos registrados onde é possível finalizar o pedido, adicionar novo item ou vizualizar os itens.
- A página de *Lista  de Itens* exite uma tabela com todos os itens do pedido.
