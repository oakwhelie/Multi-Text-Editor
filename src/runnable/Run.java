package runnable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class Run extends JFrame {

	private JPanel contentPane;
	private JTextField Pathfield;
	private JTextField FilenameContains;
	private JTextField TextContains;
	private JTextField FieldOne;
	private JTextField FieldTwo;
	private JTextField findfield;
	private JTextField replacefield;
	private JTextField FieldThree;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private char radio = 0;
	private byte OperationSuccess = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Run frame = new Run();
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
	public Run() {
		setResizable(false);
		setBackground(Color.GRAY);
		setTitle("Multi text editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{35, 90, 79, 25, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{95, 305, 107, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel path = new JLabel("Path:");
		GridBagConstraints gbc_path = new GridBagConstraints();
		gbc_path.insets = new Insets(0, 0, 0, 5);
		gbc_path.anchor = GridBagConstraints.EAST;
		gbc_path.gridx = 0;
		gbc_path.gridy = 0;
		panel.add(path, gbc_path);
		
		Pathfield = new JTextField();
		GridBagConstraints gbc_Pathfield = new GridBagConstraints();
		gbc_Pathfield.insets = new Insets(0, 0, 0, 5);
		gbc_Pathfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_Pathfield.gridx = 1;
		gbc_Pathfield.gridy = 0;
		panel.add(Pathfield, gbc_Pathfield);
		Pathfield.setColumns(10);
		
		JButton BrowsePath = new JButton("Browse...");
		BrowsePath.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				JFileChooser browse = new JFileChooser();
				browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				browse.setMultiSelectionEnabled(true);
				int browsereturn = browse.showOpenDialog(null);
				
				if(browsereturn == JFileChooser.APPROVE_OPTION)
				{
					Pathfield.setText(browse.getSelectedFile().getPath());
				}
			}
		});
		GridBagConstraints gbc_BrowsePath = new GridBagConstraints();
		gbc_BrowsePath.gridx = 2;
		gbc_BrowsePath.gridy = 0;
		panel.add(BrowsePath, gbc_BrowsePath);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{95, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblFileFilter = new JLabel("File filter");
		GridBagConstraints gbc_lblFileFilter = new GridBagConstraints();
		gbc_lblFileFilter.insets = new Insets(0, 0, 5, 0);
		gbc_lblFileFilter.gridx = 1;
		gbc_lblFileFilter.gridy = 0;
		panel_1.add(lblFileFilter, gbc_lblFileFilter);
		
		JLabel lblNameContains = new JLabel("Filename contains:");
		GridBagConstraints gbc_lblNameContains = new GridBagConstraints();
		gbc_lblNameContains.insets = new Insets(0, 0, 5, 5);
		gbc_lblNameContains.anchor = GridBagConstraints.EAST;
		gbc_lblNameContains.gridx = 0;
		gbc_lblNameContains.gridy = 1;
		panel_1.add(lblNameContains, gbc_lblNameContains);
		
		FilenameContains = new JTextField();
		GridBagConstraints gbc_FilenameContains = new GridBagConstraints();
		gbc_FilenameContains.insets = new Insets(0, 0, 5, 0);
		gbc_FilenameContains.fill = GridBagConstraints.HORIZONTAL;
		gbc_FilenameContains.gridx = 1;
		gbc_FilenameContains.gridy = 1;
		panel_1.add(FilenameContains, gbc_FilenameContains);
		FilenameContains.setColumns(10);
		
		JLabel lblTextContains = new JLabel("Text contains:");
		GridBagConstraints gbc_lblTextContains = new GridBagConstraints();
		gbc_lblTextContains.anchor = GridBagConstraints.EAST;
		gbc_lblTextContains.insets = new Insets(0, 0, 0, 5);
		gbc_lblTextContains.gridx = 0;
		gbc_lblTextContains.gridy = 2;
		panel_1.add(lblTextContains, gbc_lblTextContains);
		
		TextContains = new JTextField();
		GridBagConstraints gbc_TextContains = new GridBagConstraints();
		gbc_TextContains.fill = GridBagConstraints.HORIZONTAL;
		gbc_TextContains.gridx = 1;
		gbc_TextContains.gridy = 2;
		panel_1.add(TextContains, gbc_TextContains);
		TextContains.setColumns(10);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 2;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add to...", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_2.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{95, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel LabelOne = new JLabel("Line:");
		GridBagConstraints gbc_LabelOne = new GridBagConstraints();
		gbc_LabelOne.anchor = GridBagConstraints.EAST;
		gbc_LabelOne.insets = new Insets(0, 0, 5, 5);
		gbc_LabelOne.gridx = 0;
		gbc_LabelOne.gridy = 0;
		panel_5.add(LabelOne, gbc_LabelOne);
		
		FieldOne = new JTextField();
		GridBagConstraints gbc_FieldOne = new GridBagConstraints();
		gbc_FieldOne.insets = new Insets(0, 0, 5, 0);
		gbc_FieldOne.fill = GridBagConstraints.HORIZONTAL;
		gbc_FieldOne.gridx = 1;
		gbc_FieldOne.gridy = 0;
		panel_5.add(FieldOne, gbc_FieldOne);
		FieldOne.setColumns(10);
		
		JLabel LabelTwo = new JLabel("Text to add:");
		GridBagConstraints gbc_LabelTwo = new GridBagConstraints();
		gbc_LabelTwo.anchor = GridBagConstraints.EAST;
		gbc_LabelTwo.insets = new Insets(0, 0, 5, 5);
		gbc_LabelTwo.gridx = 0;
		gbc_LabelTwo.gridy = 1;
		panel_5.add(LabelTwo, gbc_LabelTwo);
		
		FieldTwo = new JTextField();
		GridBagConstraints gbc_FieldTwo = new GridBagConstraints();
		gbc_FieldTwo.insets = new Insets(0, 0, 5, 0);
		gbc_FieldTwo.fill = GridBagConstraints.HORIZONTAL;
		gbc_FieldTwo.gridx = 1;
		gbc_FieldTwo.gridy = 1;
		panel_5.add(FieldTwo, gbc_FieldTwo);
		FieldTwo.setColumns(10);
		
		JLabel LabelThree = new JLabel("Contained text:");
		GridBagConstraints gbc_LabelThree = new GridBagConstraints();
		gbc_LabelThree.anchor = GridBagConstraints.EAST;
		gbc_LabelThree.insets = new Insets(0, 0, 0, 5);
		gbc_LabelThree.gridx = 0;
		gbc_LabelThree.gridy = 2;
		panel_5.add(LabelThree, gbc_LabelThree);
		
		FieldThree = new JTextField();
		GridBagConstraints gbc_FieldThree = new GridBagConstraints();
		gbc_FieldThree.fill = GridBagConstraints.HORIZONTAL;
		gbc_FieldThree.gridx = 1;
		gbc_FieldThree.gridy = 2;
		panel_5.add(FieldThree, gbc_FieldThree);
		FieldThree.setColumns(10);
		
		JRadioButton FileLine = new JRadioButton("File line");
		buttonGroup.add(FileLine);
		FileLine.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LabelOne.setText("Line:");
				LabelOne.setVisible(true);
				FieldOne.setVisible(true);
				LabelThree.setVisible(false);
				FieldThree.setVisible(false);
				radio = '1';
			}
		});
		GridBagConstraints gbc_FileLine = new GridBagConstraints();
		gbc_FileLine.insets = new Insets(0, 0, 0, 5);
		gbc_FileLine.gridx = 0;
		gbc_FileLine.gridy = 0;
		panel_4.add(FileLine, gbc_FileLine);
		
		JRadioButton LinesAfterContainedText = new JRadioButton("Lines after contained text");
		buttonGroup.add(LinesAfterContainedText);
		LinesAfterContainedText.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LabelOne.setText("after ... lines:");
				LabelOne.setVisible(true);
				FieldOne.setVisible(true);
				LabelThree.setVisible(true);
				FieldThree.setVisible(true);
				radio = '2';
			}
			
		});
		GridBagConstraints gbc_LinesAfterContainedText = new GridBagConstraints();
		gbc_LinesAfterContainedText.insets = new Insets(0, 0, 0, 5);
		gbc_LinesAfterContainedText.gridx = 1;
		gbc_LinesAfterContainedText.gridy = 0;
		panel_4.add(LinesAfterContainedText, gbc_LinesAfterContainedText);
		
		JRadioButton AppendToExisting = new JRadioButton("Append to existing text");
		buttonGroup.add(AppendToExisting);
		AppendToExisting.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				LabelOne.setVisible(false);
				FieldOne.setVisible(false);
				LabelThree.setVisible(true);
				FieldThree.setVisible(true);
				radio = '3';
			}
		});
		GridBagConstraints gbc_AppendToExisting = new GridBagConstraints();
		gbc_AppendToExisting.gridx = 2;
		gbc_AppendToExisting.gridy = 0;
		panel_4.add(AppendToExisting, gbc_AppendToExisting);
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Replace...", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{95, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblfind = new JLabel("Find:");
		GridBagConstraints gbc_lblfind = new GridBagConstraints();
		gbc_lblfind.insets = new Insets(0, 0, 5, 5);
		gbc_lblfind.anchor = GridBagConstraints.EAST;
		gbc_lblfind.gridx = 0;
		gbc_lblfind.gridy = 0;
		panel_3.add(lblfind, gbc_lblfind);
		
		findfield = new JTextField();
		GridBagConstraints gbc_findfield = new GridBagConstraints();
		gbc_findfield.insets = new Insets(0, 0, 5, 0);
		gbc_findfield.fill = GridBagConstraints.HORIZONTAL;
		gbc_findfield.gridx = 1;
		gbc_findfield.gridy = 0;
		panel_3.add(findfield, gbc_findfield);
		findfield.setColumns(10);
		
		JLabel lblreplace = new JLabel("Replace:");
		GridBagConstraints gbc_lblreplace = new GridBagConstraints();
		gbc_lblreplace.anchor = GridBagConstraints.EAST;
		gbc_lblreplace.insets = new Insets(0, 0, 0, 5);
		gbc_lblreplace.gridx = 0;
		gbc_lblreplace.gridy = 1;
		panel_3.add(lblreplace, gbc_lblreplace);
		
		replacefield = new JTextField();
		GridBagConstraints gbc_replacefield = new GridBagConstraints();
		gbc_replacefield.fill = GridBagConstraints.HORIZONTAL;
		gbc_replacefield.gridx = 1;
		gbc_replacefield.gridy = 1;
		panel_3.add(replacefield, gbc_replacefield);
		replacefield.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 3;
		contentPane.add(panel_6, gbc_panel_6);
		
		JButton apply = new JButton("Apply");
		apply.setEnabled(false);
		apply.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				File mainfolder = new File(Pathfield.getText());
				if(panel_3.isVisible())
				{					
					if(findfield.getText().length()==0) ErrorDialog.errorDial("001");
					else
					{
						isDir(mainfolder);	
					}
				}
				
				if(panel_2.isVisible())
				{
					if(radio=='1')
					{
						if(FieldOne.getText().length()==0 || FieldTwo.getText().length()== 0) ErrorDialog.errorDial("001");
						else 
						{
							try
							{
								Integer.parseInt(FieldOne.getText());
								isDir(mainfolder, radio);
							} catch(NumberFormatException e)
							{
								ErrorDialog.errorDial("004");
							}
						}
					}
					if(radio=='2')
					{
						if(FieldOne.getText().length()==0 || FieldTwo.getText().length()== 0 || FieldThree.getText().length()== 0) 
							ErrorDialog.errorDial("001");
						else 
						{
							try
							{
								Integer.parseInt(FieldOne.getText());
								isDir(mainfolder, radio);
							} catch(NumberFormatException e)
							{
								ErrorDialog.errorDial("004");
							}
						}
					}
					if(radio=='3')
					{
						if(FieldThree.getText().length()==0 || FieldTwo.getText().length()== 0) ErrorDialog.errorDial("001");
						else 
						{
							isDir(mainfolder, radio);
						}
					}
					if(radio=='0')
					{
						ErrorDialog.errorDial("003");
					}
				}
				
				if(OperationSuccess == 1)
				{
					ErrorDialog.errorDial("999");
				}
				if(OperationSuccess == 2)
				{
					FailedOperation.main();
				}
				OperationSuccess = 0;
			}
		});
		
		ButtonModel model = apply.getModel();
        Document document1 = FieldOne.getDocument();
        Document document2 = FieldTwo.getDocument();
        Document document3 = FieldThree.getDocument();
        Document document4 = findfield.getDocument();
        Document document5 = replacefield.getDocument();

        ButtonEnablement buttonEnablement = new ButtonEnablement(model);
        buttonEnablement.addDocument(document1);
        buttonEnablement.addDocument(document2);
        buttonEnablement.addDocument(document3);
        buttonEnablement.addDocument(document4);
        buttonEnablement.addDocument(document5);

		
		apply.setBounds(10, 0, 89, 23);
		panel_6.add(apply);
	}
	
	public void isDir(File file)	//replace...
	{
		if(file.isDirectory())
		{
			File files[] = file.listFiles(); 
			for(int x=0; x<files.length; x++)
			{
				isDir(files[x]);
			}
		}
		else
		{
			if(		FilenameContains.getText().length() == 0 &&
					TextContains.getText().length() == 0)
			{
				OperationSuccess = Operation.replace(file, findfield, replacefield);
			}
			
			else if(FilenameContains.getText().length() > 0 &&
					TextContains.getText().length() == 0)
			{
				if( file.getPath().contains(FilenameContains.getText()) )
					OperationSuccess = Operation.replace(file, findfield, replacefield);
			}
			
			else if(FilenameContains.getText().length() == 0 &&
					TextContains.getText().length() > 0)
			{
				boolean write = false;
				write = Operation.checkLines(file, TextContains);
				if(write)
				{
					OperationSuccess = Operation.replace(file, findfield, replacefield);
				}
			}
			
			else if(FilenameContains.getText().length() > 0 &&
					TextContains.getText().length() > 0)
			{
				boolean write = false;
				if( file.getPath().contains(FilenameContains.getText()) )
				{
					write = Operation.checkLines(file, TextContains);
				}
				
				if(write)
				{
					OperationSuccess = Operation.replace(file, findfield, replacefield);
				}
			}
		}
	}
	
	public void isDir(File file, char radio)	//add to...
	{
		if(file.isDirectory())
		{
			File files[] = file.listFiles(); 
			for(int x=0; x<files.length; x++)
			{
				isDir(files[x], radio);
			}
		}
		else
		{
			if(		FilenameContains.getText().length() == 0 &&
					TextContains.getText().length() == 0)
			{
				OperationSuccess = Operation.addTo(file, radio, FieldOne, FieldTwo, FieldThree);
			}
			
			else if(FilenameContains.getText().length() > 0 &&
					TextContains.getText().length() == 0)
			{
				if( file.getPath().contains(FilenameContains.getText()) )
					OperationSuccess = Operation.addTo(file, radio, FieldOne, FieldTwo, FieldThree);
			}
			
			else if(FilenameContains.getText().length() == 0 &&
					TextContains.getText().length() > 0)
			{
				boolean write = false;
				write = Operation.checkLines(file, TextContains);
				if(write)
				{
					OperationSuccess = Operation.addTo(file, radio, FieldOne, FieldTwo, FieldThree);
				}
			}
			
			else if(FilenameContains.getText().length() > 0 &&
					TextContains.getText().length() > 0)
			{
				boolean write = false;
				if( file.getPath().contains(FilenameContains.getText()) )
				{
					write = Operation.checkLines(file, TextContains);
				}
				
				if(write)
				{
					OperationSuccess = Operation.addTo(file, radio, FieldOne, FieldTwo, FieldThree);
				}
			}
		}
	}
}
