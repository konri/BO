package GUI;

import exceptions.GeneticAlgorithmExeptions;
import geneticAlgorithm.GeneticAlgorithm;
import geneticAlgorithm.Population;
import geneticAlgorithm.Tour.MethodFitness;
import graph.Node;
import graph.NodeManager;
import hamiltonAlgorithm.HamiltonAlgorithm;
import hamiltonAlgorithm.MatrixPermission;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.SpinnerListModel;

import geneticAlgorithm.Tour;
public class InterfaceHamilton extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * GUI elements
	 */
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	//up panel:
	private JDesktopPane upPanel;
		private JPanel nodePanel; // nodePanel
			private JButton btnNodeGenerate; //button for generate nodes.
			private JSpinner nodeSpinner; // spinner from nodePanel
		private JPanel permissionPanel;
			private JButton btnZaznacz;
			private JButton btnZakocz;
			private JButton btnGeneruj; 
			private JButton btnShowArray;
		private JPanel geneticAlgorithPanel; 
			private JSpinner populationSpinner; 
			private JSpinner muttationSpinner; 
			private JSpinner tournamentSpinner;
			private JSpinner iterationSpinner;
		private JPanel hamiltonPanel;
			private JPanel hamiltonPanel_1;
				private JSpinner hamiltonSpinner;
			private JPanel eliminacjaPanel;
				private JRadioButton rdbtnWszystkieMiasta; 
				private JRadioButton rdbtnMiastaLiczoneZ;
			private JButton btnUruchom;
			private JButton btnExportbutton;
		private JPanel panel;
			
	/*
	 * elements of algorithm
	 */
	private NodeManager nodeManager = null;
	private MatrixPermission matrix = null;
	private Node tabNodes[];
	private GeneticAlgorithm geneticAlgorithm = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceHamilton frame = new InterfaceHamilton();
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
	public InterfaceHamilton() {
		
		/*
		 * default information about GUI view
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Up Panel 
		 */
		upPanel = new JDesktopPane();
		upPanel.setBackground(Color.LIGHT_GRAY);
		upPanel.setBounds(9, 11, 877, 128);
		contentPane.add(upPanel);
		/*
		 * Generate node panel
		 */
		nodePanel = new JPanel();
		nodePanel.setBackground(Color.LIGHT_GRAY);
		nodePanel.setBorder(new TitledBorder(null, "W\u0119z\u0142y", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		nodePanel.setForeground(Color.LIGHT_GRAY);
		nodePanel.setBounds(9, 11, 147, 106);
		upPanel.add(nodePanel);
		nodePanel.setLayout(null);
		
		nodeSpinner = new JSpinner();
		nodeSpinner.setModel(new SpinnerNumberModel(new Integer(3), new Integer(3), null, new Integer(1)));
		nodeSpinner.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nodeSpinner.setBounds(37, 23, 76, 28);
		nodePanel.add(nodeSpinner);
		
				
		btnNodeGenerate = new JButton("Generuj");
		btnNodeGenerate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNodeGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int amountNodes = (Integer) nodeSpinner.getValue();
				if(amountNodes < 0 ){
					JOptionPane.showMessageDialog(
							null,
							"Nie mo¿e byæ ujemna iloœæ wez³ów",
							"ErrorException -- nie ma mozliwosci wygenerowania",
							JOptionPane.ERROR_MESSAGE);
					
				}else{
					tabNodes = new Node[amountNodes];
					
					matrix = new MatrixPermission();
					nodeManager = new NodeManager(matrix);
					
					for (int i = 0; i < amountNodes; i++)
					{
					tabNodes[i] = new Node();
					nodeManager.addNode(tabNodes[i]); //add Node for NodeManager.
					}
					
				} 
				
			}
		});
		btnNodeGenerate.setBounds(24, 62, 99, 33);
		nodePanel.add(btnNodeGenerate);
		
		/*
		 * Permission Panel 
		 */
		permissionPanel = new JPanel();
		permissionPanel.setBorder(new TitledBorder(null, "Uprawnienia", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		permissionPanel.setBackground(Color.LIGHT_GRAY);
		permissionPanel.setBounds(165, 11, 323, 106);
		upPanel.add(permissionPanel);
		permissionPanel.setLayout(null);
		
		btnZaznacz = new JButton("Zaznacz");
		btnZaznacz.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnZaznacz.setBounds(12, 18, 91, 33);
		permissionPanel.add(btnZaznacz);
		
		btnZakocz = new JButton("Zako\u0144cz");
		btnZakocz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				matrix.addPermission(0, 1);
//				matrix.addPermission(0, 4);
//				matrix.addPermission(1, 2);
//				matrix.addPermission(2, 4);
//				matrix.addPermission(2, 3);
//				matrix.addPermission(4, 3);
//				matrix.addPermission(4, 6);
//				matrix.addPermission(3, 6);
//				matrix.addPermission(3, 5);
//				matrix.addPermission(5, 7);
//				matrix.addPermission(7, 4);
//				matrix.addPermission(5, 2);
//				matrix.addPermission(6, 7);
				matrix.setReady();
				HamiltonAlgorithm.setMatrixPermission(matrix);
				
			}
		});
		btnZakocz.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnZakocz.setBounds(60, 62, 91, 33);
		permissionPanel.add(btnZakocz);
		
		btnGeneruj = new JButton("Generuj");
		btnGeneruj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(matrix != null){
//					matrix.randomPermission();
				}else{
					JOptionPane.showMessageDialog(
							null,
							"Nale¿y pierw wygenerowaæ iloœæ wêz³ów",
							"ErrorException -- nie ma mozliwosci wygenerowania",
							JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnGeneruj.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGeneruj.setBounds(111, 18, 91, 33);
		permissionPanel.add(btnGeneruj);
		
		btnShowArray = new JButton("Poka\u017C \r\ntablice");
		btnShowArray.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(matrix);
			}
		});
		btnShowArray.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnShowArray.setBounds(212, 42, 101, 33);
		permissionPanel.add(btnShowArray);
		
		/*
		 * Genetic Algorithm parameters panel. 
		 */
		
		geneticAlgorithPanel = new JPanel();
		geneticAlgorithPanel.setBackground(Color.LIGHT_GRAY);
		geneticAlgorithPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Genetic Algorithm", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		geneticAlgorithPanel.setBounds(497, 11, 371, 106);
		upPanel.add(geneticAlgorithPanel);
		geneticAlgorithPanel.setLayout(null);
		
		 
		populationSpinner = new JSpinner();
		populationSpinner.setModel(new SpinnerNumberModel(new Integer(20), new Integer(10), null, new Integer(5)));
		populationSpinner.setBounds(25, 48, 61, 28);
		geneticAlgorithPanel.add(populationSpinner);
		
		JLabel lblWielkoPopulacji = new JLabel("wielko\u015B\u0107 populacji");
		lblWielkoPopulacji.setBounds(10, 32, 90, 14);
		geneticAlgorithPanel.add(lblWielkoPopulacji);
		
		muttationSpinner = new JSpinner();
		muttationSpinner.setModel(new SpinnerNumberModel(new Double(0.1), new Double(0.05), new Double(1), new Double(0.05)));

		muttationSpinner.setBounds(120, 48, 61, 28);
		geneticAlgorithPanel.add(muttationSpinner);
		
		JLabel lblMuttationSeek = new JLabel("muttation seek\r\n");
		lblMuttationSeek.setBounds(110, 32, 80, 14);
		geneticAlgorithPanel.add(lblMuttationSeek);
		
		tournamentSpinner = new JSpinner();
		tournamentSpinner.setModel(new SpinnerNumberModel(new Integer(10), new Integer(2), null, new Integer(5)));
		tournamentSpinner.setBounds(214, 48, 61, 28);
		geneticAlgorithPanel.add(tournamentSpinner);
		
		JLabel lblTournamentSize = new JLabel("tournament size");
		lblTournamentSize.setBounds(204, 32, 80, 14);
		geneticAlgorithPanel.add(lblTournamentSize);
		
		iterationSpinner = new JSpinner();
		iterationSpinner.setModel(new SpinnerNumberModel(new Integer(100), new Integer(0), null, new Integer(100)));
		iterationSpinner.setBounds(298, 48, 61, 28);
		geneticAlgorithPanel.add(iterationSpinner);
		
		
		JLabel lblIloIteracji = new JLabel("ilo\u015B\u0107 iteracji");
		lblIloIteracji.setBounds(298, 32, 61, 14);
		geneticAlgorithPanel.add(lblIloIteracji);


		/*
		 * Hamilton parameters panel.
		 */
		hamiltonPanel = new JPanel();
		hamiltonPanel.setBackground(Color.LIGHT_GRAY);
		hamiltonPanel.setBounds(657, 150, 229, 456);
		contentPane.add(hamiltonPanel);
		hamiltonPanel.setLayout(null);
		
		hamiltonPanel_1 = new JPanel();
		hamiltonPanel_1.setBorder(new TitledBorder(null, "Hamilton Path", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		hamiltonPanel_1.setBackground(Color.LIGHT_GRAY);
		hamiltonPanel_1.setBounds(10, 11, 209, 434);
		hamiltonPanel.add(hamiltonPanel_1);
		hamiltonPanel_1.setLayout(null);
		
		JLabel lblIloOtrzymanychTras = new JLabel("ilo\u015B\u0107 otrzymanych tras");
		lblIloOtrzymanychTras.setBounds(48, 34, 113, 14);
		hamiltonPanel_1.add(lblIloOtrzymanychTras);
		
		hamiltonSpinner = new JSpinner();
		hamiltonSpinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		hamiltonSpinner.setFont(new Font("Tahoma", Font.BOLD, 14));
		hamiltonSpinner.setBounds(10, 49, 189, 34);
		hamiltonPanel_1.add(hamiltonSpinner);
		
		eliminacjaPanel = new JPanel();
		eliminacjaPanel.setBorder(new TitledBorder(null, "metoda eliminacji", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		eliminacjaPanel.setBackground(Color.LIGHT_GRAY);
		eliminacjaPanel.setBounds(10, 94, 189, 114);
		hamiltonPanel_1.add(eliminacjaPanel);
		eliminacjaPanel.setLayout(null);
		
		rdbtnWszystkieMiasta = new JRadioButton("wszystkie miasta \r\n(bez przeskok\u00F3w)");
		rdbtnWszystkieMiasta.setSelected(true);
		rdbtnWszystkieMiasta.setBackground(Color.LIGHT_GRAY);
		rdbtnWszystkieMiasta.setActionCommand("allCity");
		buttonGroup.add(rdbtnWszystkieMiasta);
		rdbtnWszystkieMiasta.setBounds(6, 24, 177, 36);
		eliminacjaPanel.add(rdbtnWszystkieMiasta);
		
		rdbtnMiastaLiczoneZ = new JRadioButton("miasta liczone z przeskokami\r\n");
		rdbtnMiastaLiczoneZ.setBackground(Color.LIGHT_GRAY);
		rdbtnMiastaLiczoneZ.setActionCommand("cityToPause");
		buttonGroup.add(rdbtnMiastaLiczoneZ);
		rdbtnMiastaLiczoneZ.setBounds(6, 63, 177, 44);
		eliminacjaPanel.add(rdbtnMiastaLiczoneZ);
		
		
		btnUruchom = new JButton("Uruchom");
		btnUruchom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int populationSize = (Integer) populationSpinner.getValue();
				int populationSizeCorrectPaths = (Integer) hamiltonSpinner.getValue();
				double muttationSeek = (Double) muttationSpinner.getValue();
				int tournamentSize = (Integer) tournamentSpinner.getValue();
				int amountIteration = (Integer) iterationSpinner.getValue();
				MethodFitness method;
				
				if(buttonGroup.getSelection().getActionCommand().equals("allCity"))
					method = MethodFitness.getAllConnect;
				else
					method = MethodFitness.getAfterAnotherConnect;
				
				
				
				Population testPopulacji = new Population(populationSize, true);
				geneticAlgorithm = new GeneticAlgorithm(populationSizeCorrectPaths,muttationSeek,tournamentSize,method);
				/******************* Test population *************************/
				System.out.println();
				for (int i = 0; i < amountIteration; i++)
					if (!geneticAlgorithm.isFull()) {
						try {
							testPopulacji = geneticAlgorithm.solvePopulation(testPopulacji);
						} catch (GeneticAlgorithmExeptions err) {
							err.printStackTrace();
						}

					}
				
				
				Population hamiltonPaths = geneticAlgorithm.getHamiltonPaths(); //population of correct non-duplicated paths. 
				System.out.println("Correct paths: " + geneticAlgorithm.getAmountGoodPath());
				for (int i = 0; i < geneticAlgorithm.getAmountGoodPath(); i++) {
					System.out.println(HamiltonAlgorithm.checkHamilton(hamiltonPaths
							.getTour(i)) + " : " + hamiltonPaths.getTour(i));
				}
			}
		});
		btnUruchom.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUruchom.setBounds(10, 219, 189, 34);
		hamiltonPanel_1.add(btnUruchom);
		
		btnExportbutton = new JButton("Eksport\r\n");
		btnExportbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExportbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExportbutton.setBounds(10, 301, 189, 34);
		hamiltonPanel_1.add(btnExportbutton);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(9, 150, 638, 456);
		contentPane.add(panel);
	}
}
