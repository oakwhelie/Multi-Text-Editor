package runnable;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class ErrorDialog extends JDialog 
{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try 
		{
			ErrorDialog dialog = new ErrorDialog("n/a");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ErrorDialog(String code) {
		setTitle("error occurred");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{424, 0};
		gbl_contentPanel.rowHeights = new int[]{218, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel errorD = new JLabel("errorD");
			GridBagConstraints gbc_errorD = new GridBagConstraints();
			gbc_errorD.gridx = 0;
			gbc_errorD.gridy = 0;
			contentPanel.add(errorD, gbc_errorD);
			if(code.equals("001")) errorD.setText("one or more parameters are empty");
			if(code.equals("002")) errorD.setText("options ");
			if(code.equals("999")) errorD.setText("Succesful Execution");
			if(code.equals("003")) errorD.setText("\"add to...\" option is not choosen");
			if(code.equals("004")) errorD.setText("cant accept letters in Line field");
		}
	}
	/**
	 * @wbp.parser.constructor
	 */
	public static void errorDial(String code)
	{
		//001 = insufficient parameter
		try 
		{
			ErrorDialog dialog = new ErrorDialog(code);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}	
}
