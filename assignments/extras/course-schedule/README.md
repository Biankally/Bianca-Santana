## Problema: Course Schedule

É fornecido um número inteiro, `numCourses`, representando o número total de disciplinas que você precisa concluir, numeradas de `0` a `numCourses - 1`.

É fornecido também um array de pré-requisitos, onde `prerequisites[i] = [a[i], b[i]]` indica que você deve cursar a disciplina `b[i]` primeiro para poder cursar a disciplina `a[i]`. Por exemplo, o par `[1,0]` indica que para cursar a disciplina `1`, você precisa primeiro cursar a disciplina `0`.

Retorne `true` se todas as disciplinas puderem ser concluídas. Caso contrário, retorne `false`.

Restrições:

- 1≤ `numCourses` ≤1500
- 0≤ `prerequisites.length` ≤1000
- prerequisites[i].length = 2
- 0≤ `a[i]`, `b[i]` < `numCourses`
- Todos os pares prerequisites[i] são únicos.
