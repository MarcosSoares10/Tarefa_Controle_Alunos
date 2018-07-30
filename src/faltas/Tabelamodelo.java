/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faltas;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Tabelamodelo extends AbstractTableModel {

    private final List<Aluno> lista;

    public Tabelamodelo(List<Aluno> lista) {//construtor da classe 
        this.lista = lista;//recebe a lista 
    }

    @Override
    public int getRowCount() {//metodo que retorna a quantidade de linhas da tabela a ser exibida 
        return lista.size();
    }

    @Override
    public int getColumnCount() {//retona a quantidade de colunas da tabela 
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//metodo que preenche a tabela com os dados da lista 
        Aluno eq = lista.get(rowIndex);//recupera o elemento pelo seu indice na lista 
        switch (columnIndex) {
            case 0:
                return eq.getAluno();
            case 1:
                return Situacao(eq);
            case 2:
                return eq.getMatricula();
            case 3:
                return eq.getDisciplina();
            case 4:
                return eq.getCurso();
            case 5:
                return eq.getBimestral1();
            case 6:
                return eq.getBimestral2();
            case 7:
                return eq.getBimestral3();
            case 8:
                return eq.getBimestral4();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {//metodos que adiciona a descrição da coluna 
        switch (column) {
            case 0:
                return "Aluno";
            case 1:
                return "Situação";
            case 2:
                return "Matricula";
            case 3:
                return "Disciplina";
            case 4:
                return "Curso";
            case 5:
                return "Bimestral 1";
            case 6:
                return "Bimestral 2";
            case 7:
                return "Bimestral 3";
            case 8:
                return "Bimestral 4";

        }
        return "";
    }

    public Aluno getAlunos(int ind) {
        return lista.get(ind);
    }
    
    public String Situacao(Aluno e){
    Long resultado = ((e.getBimestral1()+e.getBimestral2()+e.getBimestral3()+e.getBimestral4())/4);
        if(resultado>=7){
        return "Aprovado";
        }else if(resultado>=4 && resultado<7){
        return "Prova Final";
        }else{
        return "Reprovado";
        } 
    }
}
