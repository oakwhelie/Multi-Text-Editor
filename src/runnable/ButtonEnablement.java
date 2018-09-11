package runnable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class ButtonEnablement implements DocumentListener {

    private ButtonModel buttonModel;
    private List<Document> documents = new ArrayList<Document>();
    private List<Boolean> enabler = new ArrayList<Boolean>();

    public ButtonEnablement(ButtonModel buttonModel) 
    {
        this.buttonModel = buttonModel;
    }

    public void addDocument(Document document) 
    {
        document.addDocumentListener(this);
        this.documents.add(document);
        enabler.add(new Boolean(false));
        documentChanged();
    }

    public void documentChanged() 
    {
    	boolean enableButton = false;
        for (int x=0; x<documents.size(); x++) 
        {
            if (documents.get(x).getLength() > 0) 
            {
            	enableButton = true;
            	break;
            }
        }
        buttonModel.setEnabled(enableButton);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        documentChanged();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        documentChanged();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        documentChanged();
    }
}
