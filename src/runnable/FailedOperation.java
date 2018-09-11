package runnable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class FailedOperation extends JDialog 
{

	private final JPanel contentPanel = new JPanel();
	private static FailedOperation dialog;
	
	private static String filepaths = "";
	/**
	 * Launch the application.
	 */
	public static void main() 
	{
		try 
		{
			dialog = new FailedOperation();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void appendFilePath(String code, String path)
	{
		filepaths = filepaths.concat(path);
		if(code.equals("111")) filepaths = filepaths.concat(" : - File line exceeded\n");
		if(code.equals("222")) filepaths = filepaths.concat(" : - Text not found\n");
	}

	/**
	 * Create the dialog.
	 */
	public FailedOperation() 
	{
		setTitle("Task failed");
		setBounds(100, 100, 700, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblTaskFail = new JLabel("Task failed to be performed on these files:");
			contentPanel.add(lblTaskFail, BorderLayout.NORTH);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				JTextArea FileList = new JTextArea();
				scrollPane.setViewportView(FileList);
				FileList.setText(filepaths);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						filepaths = "";
						dialog.dispatchEvent(new WindowEvent(dialog, WindowEvent.WINDOW_CLOSING));
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
            	filepaths = "";
            }
        });
	}

}
