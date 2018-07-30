/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faltas;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Marquinhos
 */
public class Alunoctrl {
    private Connection conn;
    
   public Alunoctrl(){
   this.conn= new ConexaoFactory().getConexao();
           }
   
   public void salvarAluno(Aluno f) {
   AlunoDAO daoAluno = new AlunoDAO(conn);
    daoAluno.Adicionar(f);
    }
    
    public void deletaAluno(Aluno f){
    AlunoDAO daoAluno = new AlunoDAO(conn);
    daoAluno.Deleta(f);
    }

    public List<Aluno> listarAluno(){
        AlunoDAO daoAluno = new AlunoDAO(conn);
        List<Aluno> lista = daoAluno.ListarAlunos();
        return lista;
    }

}
