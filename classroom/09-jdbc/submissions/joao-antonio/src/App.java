import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        FilmeDAO filmeDao = new FilmeDAO();
        AtorDAO atorDao = new AtorDAO();

        System.out.println("--- INICIANDO TESTES ---");

        try {
            Film novoFilme = new Film("POO e JDBC - Simples", "Exemplo de código simples.", 2026);
            novoFilme = filmeDao.inserir(novoFilme);
            System.out.println("\n[1] INSERÇÃO OK: " + novoFilme);
            int novoFilmeId = novoFilme.getId();

            novoFilme.setTitulo("POO e JDBC - Versao Final!");
            boolean atualizado = filmeDao.atualizar(novoFilme);
            System.out.println("[U] ATUALIZAÇÃO OK: " + atualizado);

            Film filmeEncontrado = filmeDao.buscarPorId(novoFilmeId);
            System.out.println("[2] BUSCA OK: " + filmeEncontrado);

            int idFilmeExistente = 1; 
            System.out.println("\n[3] Atores do Filme ID " + idFilmeExistente + ":");
            filmeDao.listarAtoresPorFilme(idFilmeExistente)
                   .forEach(a -> System.out.println("   - " + a.getNome() + " " + a.getSobrenome()));

            int idAtorParaDeletar = 200; 
            System.out.println("\n[4] Tentando REMOVER Ator ID: " + idAtorParaDeletar);
            atorDao.deletarAtor(idAtorParaDeletar);

            boolean deletado = filmeDao.deletar(novoFilmeId);
            System.out.println("[D] REMOÇÃO Filme OK: " + deletado);


        } catch (SQLException e) {
            System.err.println("\nERRO DE BANCO DE DADOS! Mensagem: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nERRO DE APLICAÇÃO: " + e.getMessage());
        }

        System.out.println("\n--- FIM DOS TESTES. Verifique o arquivo auditoria.log ---");
    }
}