### Instruções gerais para entrega das atividades

* Configurar repositório da disciplina, caso ainda não tenha feito
    * Realizar fork do repositório da disciplina
        ```bash
        gh repo fork fabriciosantana/poo
        ```
   
    * Clonar seu repositório que você acabou de clonar (substituir `seu-usuario` por seu login no github)
        ```bash
        git clone https://github.com/seu-usuario/poo.git
        ```
   
    * Adicionar o repositório original como remoto
        ```bash
        git remote add upstream https://github.com/fabriciosantana/poo.git
        ```
   
    * Verificar a configuração dos repositórios remotos
        ```bash
        git remote -v
        ```

* Atualizar fork para evitar conflitos
```bash
git fetch upstream
git checkout 2025.2
git merge upstream/2025.2
```

```bash
gh repo set-default fabriciosantana/poo
```

```bash
gh repo sync
```

* Criar um diretório com seu nome e sobrenome dentro do diretório da atividade, conforme exemplo abaixo(o nome do último diretório deve ser seu nome e sobrenome em caixa baixa):
```bash
mkdir poo/assignments/00-hello/submissions/fabricio-santana/src  
```
* Desenvolver programa Java dentro do seu diretório atendendo os requisitos da especificação e os requisitos de implementação
* Comitar alterações em seu repositório
```bash
git add .   
git commit -m "minha solução da tarefa"
git push
```
* Enviar um pull request
```bash
gh pr create --base 2025.1 --head seu-usuario:2025.1 --title "Minha tarefa XXX" --body "Descrição das alterações realizadas."
```
* Observar se os testes do pull request rodaram com sucesso
* Submeter link do pull request no [ambiente virtual](https://ambientevirtual.idp.edu.br/)
* Cumprir prazo de entrega conforme ambiente virtual