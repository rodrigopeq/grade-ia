package br.projeto.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import br.projeto.grade.Controller;
import br.projeto.grade.DesenhaGrade;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Te extends JFrame {

	private JPanel contentPane;
	private JTable tableGrade;
	private JTable tableDocente;
	Controller app = new Controller();
	DefaultTableModel x = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Te frame = new Te();
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
	public Te() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		

		JPanel panelButons = new JPanel();
		
//		tableGrade.setModel(x);
		tableGrade = setRowClear();
		tableGrade.setRowSelectionAllowed(false);

		JPanel description = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(tableGrade, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
						.addComponent(panelButons, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
						.addComponent(description, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelButons, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tableGrade, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(description, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(21))
		);

		tableDocente = new JTable(40, 4);
		description.add(tableDocente);

		JButton btnHorario = new JButton("Gerar Horario");
		btnHorario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					app.resultProblem();
					DesenhaGrade grade = new DesenhaGrade(app.getDisciplinas());
					tableGrade = setGrade(grade);
					x.fireTableRowsUpdated(0, 6);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Não foi encontrado nenhum resultado possivel", "Alerta", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});

		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tableGrade = setRowClear();
				x.fireTableRowsUpdated(0, 6);
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		GroupLayout gl_panelButons = new GroupLayout(panelButons);
		gl_panelButons.setHorizontalGroup(gl_panelButons.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelButons.createSequentialGroup().addContainerGap().addComponent(btnHorario)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnResetar)
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnSair)
						.addContainerGap(40, Short.MAX_VALUE)));
		gl_panelButons
				.setVerticalGroup(gl_panelButons.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelButons.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panelButons.createParallelGroup(Alignment.LEADING)
										.addComponent(btnHorario, Alignment.TRAILING).addGroup(Alignment.TRAILING,
												gl_panelButons.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnResetar).addComponent(btnSair)))
								.addContainerGap()));
		panelButons.setLayout(gl_panelButons);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup()
						.addGap(26).addComponent(panel, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE).addGap(32)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(panel,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(74, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		
	}

	private JTable setGrade(DesenhaGrade grade) {
		Object[][] data = { { "13:00h-13:50h", grade.SEG1, grade.TER1, grade.QUA1, grade.QUI1, grade.SEX1 },
				{ "14:00h-14:50h", grade.SEG2, grade.TER2, grade.QUA2, grade.QUI2, grade.SEX2 },
				{ "15:00h-15:50h", grade.SEG3, grade.TER3, grade.QUA3, grade.QUI3, grade.SEX3 },
				{ "16:00h-16:50h", grade.SEG4, grade.TER4, grade.QUA4, grade.QUI4, grade.SEX4 },
				{ "17:00h-17:50h", grade.SEG5, grade.TER5, grade.QUA5, grade.QUI5, grade.SEX5 },
				{ "18:00h-18:50h", grade.SEG6, grade.TER6, grade.QUA6, grade.QUI6, grade.SEX6 }, };
		return new JTable(data, getColuumnName());

	}

	public JTable setRowClear() {
		Object[][] data = { { "13:00h-13:50h", " ", " ", " ", " ", " " }, { "14:00h-14:50h", " ", " ", " ", " ", " " },
				{ "15:00h-15:50h", " ", " ", " ", " ", " " }, { "16:00h-16:50h", " ", " ", " ", " ", " " },
				{ "17:00h-17:50h", " ", " ", " ", " ", " " }, { "18:00h-18:50h", " ", " ", " ", " ", " " }, };

		return new JTable(data, getColuumnName());
	}

	public String[] getColuumnName() {
		String[] columnNames = { "Horarios", "Segunda-Feira", "Terça-Feira", "Quarta-feira", "Quinta-feira",
				"Sexta-feira" };
		return columnNames;
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15; // Min width
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
