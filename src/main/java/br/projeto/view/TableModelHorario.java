package br.projeto.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelHorario extends AbstractTableModel{
	
	 /**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private List<String> dados;
	 private String[] colunas = { "Horarios", "Segunda-Feira", "Terça-Feira", "Quarta-feira", "Quinta-feira",
		"Sexta-feira" };
	 
	 public TableModelHorario(List<String> dados){
		 this.dados = dados;
	 }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha);
            case 1:
                return dados.get(linha);
            case 2: 
                return dados.get(linha);
            case 3: 
                return dados.get(linha);
            case 4: 
                return dados.get(linha);
            case 5: 
                return dados.get(linha);
                
        }
        
        return null;
        
    }
    
    

}
