package runnable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JTextField;

public class Operation 
{
	public static byte replace(File file, JTextField findfield, JTextField replacefield) // 0 nothing/ 1 success/ 2 failure/
	{
		try 
		{
			List<String> lines = Files.readAllLines(file.toPath());
			boolean textExist = false;
			for(int index=0; index<lines.size(); index++)
			{
				if( lines.get(index).contains(findfield.getText()) )
				{
					String newtext = lines.get(index);
					lines.remove(index);
					newtext = newtext.replace(findfield.getText(), replacefield.getText());
					lines.add(index, newtext);
					textExist = true;
				}
			}
			if(textExist)
			{
				Files.write(file.toPath(), lines);
				return 1;
			}
			else 
			{
				FailedOperation.appendFilePath("222", file.getPath());
				return 2;
			}
			
		} 	catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				return 2;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
	}
	
	public static boolean checkLines(File file, JTextField TextContains)
	{
		try 
		{
			List<String> lines = Files.readAllLines(file.toPath());
			for(int index=0; index<lines.size(); index++)
			{
				if( lines.get(index).contains(TextContains.getText()) )
				{
					return true;
				}
			}
			return false;
			
		} 	catch (FileNotFoundException e) 
			{
				e.printStackTrace();
				return false;
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static byte addTo(File file, char radio, JTextField FieldOne, JTextField FieldTwo, JTextField FieldThree)
	{																			// 0 nothing/ 1 success/ 2 failure/
		try 
		{
			List<String> lines = Files.readAllLines(file.toPath());
			
			if(radio=='1')
			{
				try
				{
					lines.add(Integer.parseInt(FieldOne.getText())-1, FieldTwo.getText());
				} catch(IndexOutOfBoundsException e)
				{
					int newlines = Integer.parseInt(FieldOne.getText())-lines.size();
					
					for(int x=0; x<newlines; x++)
					{
						lines.add(lines.size(), "");
					}
					lines.add(Integer.parseInt(FieldOne.getText())-1, FieldTwo.getText());

				}
			}
			if(radio=='2')
			{
				boolean textexist = false;
				for(int index=0; index<lines.size(); index++)
				{
					if( lines.get(index).contains(FieldThree.getText()) )
					{
						try
						{
							lines.add(index+Integer.parseInt(FieldOne.getText()), FieldTwo.getText());
							textexist = true;
						} catch(IndexOutOfBoundsException e)
						{
							int newlines = index+Integer.parseInt(FieldOne.getText())-lines.size();
							
							for(int x=0; x<newlines; x++)
							{
								lines.add(lines.size(), "");
							}
							lines.add(index+Integer.parseInt(FieldOne.getText()), FieldTwo.getText());
							textexist = true;
						}
					}
				}
				if(textexist==false)
				{
					FailedOperation.appendFilePath("222", file.getPath());
					return 2;
				}
			}
			if(radio=='3')
			{
				boolean textexist = false;
				for(int index=0; index<lines.size(); index++)
				{
					if( lines.get(index).contains(FieldThree.getText()) )
					{
						String thisline = lines.get(index);
						lines.remove(index);
						lines.add(index, thisline+FieldTwo.getText());
						textexist = true;
					}
				}
				if(textexist==false) 
				{
					FailedOperation.appendFilePath("222", file.getPath());
					return 2;
				}
			}
			if(radio=='0')
			{
				ErrorDialog.errorDial("001");
				return 2;
			}
			Files.write(file.toPath(), lines);
			return 1;
			
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return 2;
		} catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		} 
}
}
