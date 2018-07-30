/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faltas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Marquinhos
 */
public class AlunoDAO {
    
    private Connection conn;
   
   AlunoDAO(Connection conn) {
        this.conn = conn;
    }

    void Adicionar(Aluno f) {
   PreparedStatement stmfunc=null;
        
    try {
            String sql = "INSERT INTO bd_alu (matricula, disciplina, curso,bimestral1,bimestral2,bimestral3,bimestral4,aluno) VALUES (?,?,?,?,?,?,?,?)";
           
            stmfunc = conn.prepareStatement(sql);
            stmfunc.setLong(1, f.getMatricula());
            stmfunc.setString(2, f.getDisciplina());
            stmfunc.setString(3,f.getCurso());
            stmfunc.setLong(4,f.getBimestral1());
            stmfunc.setLong(5, f.getBimestral2());
            stmfunc.setLong(6, f.getBimestral3());
            stmfunc.setLong(7, f.getBimestral4());
            stmfunc.setString(8, f.getAluno());
            stmfunc.execute();
            
            JOptionPane.showMessageDialog(null, "Cadastrado Concluído", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                      
                       } catch (SQLException  e) {
                   e.printStackTrace();
        }
    }

    void Deleta(Aluno f) {
        PreparedStatement stmt = null;
        try {
            String sql = "DELETE From bd_alu WHERE matricula=? && disciplina=?";
           
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, f.getMatricula());
            stmt.setString(2, f.getDisciplina());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado Excluído", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            
                       
                } catch (SQLException  e) {
                   e.printStackTrace();
        }
    }

    List<Aluno> ListarAlunos() {
    List<Aluno> alunos = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM bd_alu";
        try {
            
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Aluno a = new Aluno();
               a.setAluno(rs.getString("aluno"));
               a.setDisciplina(rs.getString("disciplina"));
              a.setMatricula( rs.getInt("matricula"));
              a.setBimestral1(rs.getLong("bimestral1"));
              a.setBimestral2(rs.getLong("bimestral2"));
              a.setBimestral3(  rs.getLong("bimestral3"));
              a.setBimestral4(  rs.getLong("bimestral4"));
              a.setCurso(rs.getString("curso"));
              alunos.add(a);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 return alunos;
    }
    
}
