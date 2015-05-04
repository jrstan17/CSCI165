package lab12;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchWindow {
    
    private JFrame mainFrame = new JFrame();
    private JOptionPane jop = new JOptionPane();    
  
    private JTextField txtSearch = new JTextField();
    
    private ButtonGroup group = new ButtonGroup();
    private JRadioButton rbnLName = new JRadioButton();
    
    Object[] returnValues;
    
    public SearchWindow() {
	jop.setOptionType(JOptionPane.OK_CANCEL_OPTION);
	jop.setMessageType(JOptionPane.QUESTION_MESSAGE);
	
	group.add(rbnLName);
	
	jop.setMessage(new Object[] {txtSearch, group});
	JDialog jd = jop.createDialog(mainFrame, "Search For Contact");
	
	jd.setModal(true);
	jd.setVisible(true);
	
	returnValues = {txtSearch.getText(), group.getSelection()};
	

    }
    
    public Object[] getValues(){
	
    }
}