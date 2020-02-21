package br.projeto.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import br.projeto.grade.Controller;
import br.projeto.grade.DesenhaGrade;

public class ResultadoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

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
		setBounds(100, 100, 800, 700);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 900, 660);
		contentPane.add(scrollPane);

		Controller app = new Controller();
		try {
			app.resultProblem();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum resultado possivel", "Alerta",
					JOptionPane.ERROR_MESSAGE);
			this.dispose();
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
		scrollPane.setViewportView(table);

	}

	public String[] getColuumnName() {
		String[] columnNames = { "Horarios", "Segunda-Feira", "Terça-Feira", "Quarta-feira", "Quinta-feira",
				"Sexta-feira" };
		return columnNames;
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
