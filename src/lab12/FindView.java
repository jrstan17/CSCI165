package lab12;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FindView extends JFrame {

    private JFrame mainFrame;

    // define GUI elements
    // NORTH AREA
    private JPanel north = new JPanel();
    private JTextField txtSearch = new JTextField();

    // CENTER AREA
    private JPanel center = new JPanel(new GridLayout(1, 1, 5, 5));
    private JRadioButton rbnLName = new JRadioButton("Last Name");

    // SOUTH AREA
    private JPanel south = new JPanel(new FlowLayout());
    private JButton btnSearch = new JButton("SEARCH");

    public FindView() {

	mainFrame = new JFrame();
	mainFrame.setSize(400, 400);
	mainFrame.setLayout(new BorderLayout());

	// add buttons to NORTH panel
	north.add(txtSearch);

	// add NORTH panel to JFrame via the ContentPane
	mainFrame.add(north, BorderLayout.NORTH);

	// add buttons to SOUTH panel
	south.add(btnSearch);

	// add SOUTH panel to JFrame via the ContentPane
	mainFrame.add(south, BorderLayout.SOUTH);

	// add buttons to CENTER panel
	center.add(rbnLName);

	// add CENTER panel to JFrame via the ContentPane
	mainFrame.add(center, BorderLayout.CENTER);

	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	pack();

	WListener w = new WListener();
	mainFrame.addWindowListener(w);

	mainFrame.setVisible(true);

    }

    public void addListener(ActionListener al) {

	// btnFirst.addActionListener(al);
	// btnPrevious.addActionListener(al);
	// btnNext.addActionListener(al);
	// btnLast.addActionListener(al);
	// btnSave.addActionListener(al);
	// btnAdd.addActionListener(al);
	// btnDelete.addActionListener(al);
	// btnFind.addActionListener(al);
    }

    class WListener implements WindowListener {
	public void windowActivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {

	    e.
	    mainFrame.dispose();
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}
    }
}
