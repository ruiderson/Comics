# comics
Android Comics App Sample

# Build

Estrutura de build está no buildComposite
- Possui os plugins específico para o App e módulos de Data, Domain e Presentation
- Todas as libs e plugins estão em gradle/libs.versions.toml


# Separação de módulos

Core
- Data: responsável por utilizar os clients HTTP (Ktor + OkHttp) e servir de 
abstração para a camada de Data das Features. Assim evita o acomplamento e dependência de libs HTTP
em futuros outros módulos.

- Design System: Responsável por definir os temas, cores, tipografia e etc. Também deve ser o centro
da criação de componentes estilizáveis do app, como botões customizados e etc

- Domain: Responsável por definir models que podem ser reaproveitáveis em demais módulos. Lib somente
Kotlin, não possui as libs do Android

- Navigation: Responsável por gerenciar a navegação entre as telas do app

- Presentation: Responsável por centralizar métodos, e funcões que serão utilizadas nos módulos de
Design System e/ou Features Presentations

Feature
- Todas as features do projeto devem ser quebrados em 3 módulos: Data, Domain e Presentation.
Presentation deve implementar Domain, mas não implementar Data. 
Data deve implementar Domain, mas não implementar Presentation.
Domain não pode implementar nenhum outro módulo, que não seja o Core/Domain

# Dependências

O App foi desenvolvido utilizando o Koin para Injeção de dependência, Ktor para chamadas HTTP, Coil
para exibição de imagens via HTTP, Paging3 para paginação e Jetpack Compose para a UI.

# Arquitetura

O App utiliza um Mix de MVVM e MVI, onde a ViewModel possui Events, Effects e States.
Todo evento deverá ser direcionado à ViewModel, e somente ela pode alterar o state, e iniciar novos
effects. As regras de negócio ficam separadas em UseCases, que utilizam Repositories e DataSources 
consecutivamente.

# Todos:
Pontos importantes para melhoria do app:

Build:
- Reorganização do buildComposite, separando funcões para arquivos específicos
- Substituir o gradle/libs.versions.toml para outros arquivos no buildComposite, separando em libs
officiais (Android, Compose, etc), libs ThirdParty (Koin, Ktor, etc), e plugins do projeto 
(Data, Domain, etc.)

UI:
- Criar estrutura correta de cores, tipografias, shapes para o AppTheme
- Suporte ao DarkTheme (remover isDarkTheme = false da Activity) após configurar as cores corretamente
- Criação correta do HomeScaffold, utilizando uma TopBar com efeito de transparência, ocultando o
conteúdo da tela que navega por de trás.
- Dividir conteúdos da tela em arquivos diferentes, melhorando a organização dos Composables

Comportamento
- Implementar Cache para acesso offline
- Implementar tela de detalhes
- Testes unitários e testes de UI
