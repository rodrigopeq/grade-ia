package br.projeto.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import br.projeto.grade.Controller;
import br.projeto.grade.DesenhaGrade;
import br.projeto.models.Disciplina;
import br.projeto.models.Docente;

import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class ResultadoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JTable table;
	private JPanel panel_1;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoView frame = new ResultadoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResultadoView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
		);
		
		panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		
		Controller app = new Controller();
		try {
			app.resultProblem();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum resultado possivel", "Alerta",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		DesenhaGrade grade = new DesenhaGrade(app.getDisciplinas());

		Object[][] data = { { "13:00h-13:50h", grade.SEG1, grade.TER1, grade.QUA1, grade.QUI1, grade.SEX1 },
				{ "14:00h-14:50h", grade.SEG2, grade.TER2, grade.QUA2, grade.QUI2, grade.SEX2 },
				{ "15:00h-15:50h", grade.SEG3, grade.TER3, grade.QUA3, grade.QUI3, grade.SEX3 },
				{ "16:00h-16:50h", grade.SEG4, grade.TER4, grade.QUA4, grade.QUI4, grade.SEX4 },
				{ "17:00h-17:50h", grade.SEG5, grade.TER5, grade.QUA5, grade.QUI5, grade.SEX5 },
				{ "18:00h-18:50h", grade.SEG6, grade.TER6, grade.QUA6, grade.QUI6, grade.SEX6 }, };

		table = new JTable(data, getColuumnName()) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				component.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				
				return component;
			}
		};

		table.setShowVerticalLines(true);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		resizeColumnWidth(table);
		panel.add(table);
		
		panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		
		List<Docente> docentes = app.getxDocentes();
		Object[][] dado = new Object[docentes.size()][3];
		for(int i=0;i<docentes.size();i++) {
			dado[i][0] = docentes.get(i).getNome();
			dado[i][1] = getCarga(app.getDisciplinas(),docentes.get(i));
		    dado[i][2] = docentes.get(i).preferencias;
					
					
		}
//				{ docentes.get(1).getNome(), getCarga(app.getDisciplinas(),docentes.get(1)), docentes.get(1).preferencias},
//				{ docentes.get(2).getNome(), getCarga(app.getDisciplinas(),docentes.get(2)), docentes.get(2).preferencias},
//				{ docentes.get(3).getNome(), getCarga(app.getDisciplinas(),docentes.get(3)), docentes.get(3).preferencias},
//				{ docentes.get(4).getNome(), getCarga(app.getDisciplinas(),docentes.get(4)), docentes.get(4).preferencias},
//				{ docentes.get(5).getNome(), getCarga(app.getDisciplinas(),docentes.get(5)), docentes.get(5).preferencias},
//				{ docentes.get(6).getNome(), getCarga(app.getDisciplinas(),docentes.get(6)), docentes.get(6).preferencias},
//				};
		
		table_1 = new JTable(dado, getDocProf()) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {

				JComponent component = (JComponent) super.prepareRenderer(renderer, row, column);
				component.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

				return component;
			}
		};

		table_1.setShowVerticalLines(true);
		table_1.setIntercellSpacing(new Dimension(0, 0));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		resizeColumnWidth(table_1);
		panel_1.add(table_1);
		contentPane.setLayout(gl_contentPane);
	}
	
	public String[] getColuumnName() {
		String[] columnNames = { "Horarios", "Segunda-Feira", "Terça-Feira", "Quarta-feira", "Quinta-feira",
				"Sexta-feira" };
		return columnNames;
	}
	
	public String[] getDocProf() {
		String[] columnNames = { "Nome", "Carga Horaria", "Preferencias"};
		return columnNames;
	}
	
	public int getCarga(List<Disciplina> disciplinas, Docente docente) {
		int cargaTotal = 0;
		for( var di : disciplinas) {
			if(di.getDocente().getNome() == docente.getNome()) {
				cargaTotal += di.getCargaHoraria();
			}
		}
		return cargaTotal;
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15;
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 50, width);
			}
			if (width > 500)
				width = 500;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}
