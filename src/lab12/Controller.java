package lab12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Controller {
  // create view
  private View view = new View();
  // create services
  private ContactService cs = new ContactService();
  private int contactIndex = 0;
  
  public static void main(final String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            @SuppressWarnings("unused")
            Controller c = new Controller();
        }
    });
}

  public Controller() {
    this.view.getMainFrame().setVisible(true);
    this.view.addActionListener(new AListener());
    this.view.getMainFrame().addWindowListener(new WListener());
    Contact firstContact = cs.getContacts().get(0);
    view.updateViewWithContact(firstContact, contactIndex + 1, cs.getContacts()
        .size());

    bDayCheck(firstContact);
  }

  private boolean isBDayToday(Contact c) {
    GregorianCalendarExtended today = new GregorianCalendarExtended();
    if (c.getBirthday() != null) {
      return (today.get(Calendar.MONTH) == c.getBirthday().get(Calendar.MONTH) && today
          .get(Calendar.DATE) == c.getBirthday().get(Calendar.DATE));
    } else {
      return false;
    }
  }

  private void bDayCheck(Contact contact) {
    if (isBDayToday(contact)) {
      Messages.showBDayMessage(view.getMainFrame(), view.getTxtFName()
          .getText());
    }
  }

  private class WListener implements WindowListener {
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
      int returnCode = saveContact();

      if (returnCode == ReturnCode.SUCCESSFUL) {
        view.getMainFrame().dispose();
        System.exit(0);
      }
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }
  }

  private class AListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == view.getBtnFirst()) {
        btnFirstPressed();
      } else if (e.getSource() == view.getBtnPrevious()) {
        btnPreviousPressed();
      } else if (e.getSource() == view.getBtnNext()) {
        btnNextPressed();
      } else if (e.getSource() == view.getBtnLast()) {
        btnLastPressed();
      } else if (e.getSource() == view.getBtnNew()) {
        btnNewPressed();
      } else if (e.getSource() == view.getBtnDelete()) {
        btnDeletePressed();
      } else if (e.getSource() == view.getBtnFind()) {
        btnFindPressed();
      }
    }
  }

  public void btnFindPressed() {
    SearchWindow searchWindow = new SearchWindow();
    searchWindow.run();

    if (searchWindow.getDialogOKCancelResult() == JOptionPane.OK_OPTION) {

      SearchService searchService = new SearchService(
          searchWindow.getReturnValues(), cs.getContacts());

      int resultIndex = searchService.search();

      if (searchService.search() == ReturnCode.FOUND) {
        view.updateViewWithContact(cs.getContacts().get(resultIndex),
            resultIndex + 1, cs.getContacts().size());
        contactIndex = resultIndex;
      } else {
        Messages.showSearchNotFoundMessage(view.getMainFrame());
        btnFindPressed();
      }
    }
  }

  public void btnDeletePressed() {
    int messageResult = Messages.showDeleteContactMessage(view.getMainFrame(),
        view.getTxtFName().getText(), view.getTxtLName().getText());
    
    if (messageResult == ReturnCode.SUCCESSFUL) {
      cs.getContacts().remove(contactIndex);
      if (contactIndex < cs.getContacts().size()) {
        Contact c = cs.getContacts().get(contactIndex);
        view.updateViewWithContact(c, contactIndex + 1, cs.getContacts().size());
      } else {
        contactIndex--;
        Contact c = cs.getContacts().get(contactIndex);
        cs.writeContactsToFile();
        view.updateViewWithContact(c, contactIndex + 1, cs.getContacts().size());
      }
      if (cs.getContacts().size() == 1) {
        view.getBtnDelete().setEnabled(false);
      }
    }
  }

  public void btnNewPressed() {
    int savedResult = saveContact();

    if (savedResult == ReturnCode.SUCCESSFUL) {
      view.toggleFirstAndPrevButtons(true);
      view.toggleLastAndNextButtons(false);
      view.clearFields();
      contactIndex = cs.getContacts().size();
      cs.getContacts().add(new Contact());
      if (!view.getBtnDelete().isEnabled()) {
        view.getBtnDelete().setEnabled(true);
      }

      view.getTxtFName().requestFocusInWindow();
    }
  }

  public int saveContact() {
    String birthdayText = view.getTxtBirthday().getText();
    if (!Pattern.matches(GregorianCalendarExtended.DATE_FORMAT, birthdayText)
        && !birthdayText.isEmpty()) {
      Messages.showDateIncorrectFormatMessage(view.getMainFrame());
      view.getTxtBirthday().requestFocusInWindow();
      view.getTxtBirthday().selectAll();
      return ReturnCode.UNSUCCESSFUL;
    }

    if (view.getTxtLName().getText().isEmpty()) {

      Messages.showLNameMissingMessage(view.getMainFrame());
      view.getTxtLName().requestFocusInWindow();

      return ReturnCode.UNSUCCESSFUL;
    }

    Contact contact = cs.getContacts().get(contactIndex);

    contact.setFName(view.getTxtFName().getText());
    contact.setLName(view.getTxtLName().getText());
    contact.getAddress().setStreet(view.getTxtStreet().getText());
    contact.getAddress().setCity(view.getTxtCity().getText());
    contact.getAddress()
        .setState((String) view.getCmbState().getSelectedItem());
    contact.getAddress().setZip(view.getTxtZip().getText());
    contact.setEmail(view.getTxtEmail().getText());
    contact.getPhone().setPhoneNumber(view.getTxtPhone().getText());

    if (!birthdayText.isEmpty()) {
      contact.setBirthday(new GregorianCalendarExtended(birthdayText));
    }

    contact.setNotes(view.getNotesText().getText());

    cs.writeContactsToFile();
    Collections.sort(cs.getContacts());
    return ReturnCode.SUCCESSFUL;
  }

  private void btnFirstPressed() {
    int returnCode = saveContact();

    if (returnCode == ReturnCode.SUCCESSFUL) {
      if (contactIndex != 0) {
        contactIndex = 0;
        Contact contact = cs.getContacts().get(contactIndex);
        view.updateViewWithContact(contact, contactIndex + 1, cs.getContacts()
            .size());
        bDayCheck(contact);
      }
    }
  }

  public void btnLastPressed() {
    int returnCode = saveContact();

    if (returnCode == ReturnCode.SUCCESSFUL) {
      if (contactIndex != cs.getContacts().size() - 1) {
        contactIndex = cs.getContacts().size() - 1;
        Contact contact = cs.getContacts().get(contactIndex);
        view.updateViewWithContact(contact, contactIndex + 1, cs.getContacts()
            .size());
        bDayCheck(contact);
      }
    }
  }

  public void btnNextPressed() {
    int returnCode = saveContact();

    if (returnCode == ReturnCode.SUCCESSFUL) {
      contactIndex++;
      Contact contact = cs.getContacts().get(contactIndex);
      view.updateViewWithContact(contact, contactIndex + 1, cs.getContacts()
          .size());
      bDayCheck(contact);
    }
  }

  public void btnPreviousPressed() {
    int returnCode = saveContact();

    if (returnCode == ReturnCode.SUCCESSFUL) {
      contactIndex--;
      Contact contact = cs.getContacts().get(contactIndex);
      view.updateViewWithContact(contact, contactIndex + 1, cs.getContacts()
          .size());
      bDayCheck(contact);
    }
  }
  // public static void main(String[] args) {
  // ContactService cs = new ContactService();
  // Random rnd = new Random();
  //
  // for (int i = 0; i <= 1000; i++){
  // cs.getContacts().add(new Contact());
  //
  // Contact c = cs.getContacts().get(i);
  //
  // c.setFName(Integer.toString(i));
  // c.setLName(Integer.toString(rnd.nextInt(1000000) + 100000));
  // c.getAddress().setCity(Integer.toString(rnd.nextInt(1000000) + 100000));
  // c.getAddress().setState(States.NY);
  // c.getAddress().setStreet(Integer.toString(rnd.nextInt(1000000) + 100000)
  // + " Buck Road");
  // c.getAddress().setZip(Integer.toString(rnd.nextInt(1000000) + 100000));
  // c.setBirthday(new GregorianCalendarExtended("12/30/1982"));
  // c.setEmail(Integer.toString(rnd.nextInt(1000000) + 100000));
  // c.setNotes(Integer.toString(rnd.nextInt(1000000) + 100000));
  // c.setPhone(new PhoneNumber(Integer.toString(rnd.nextInt(1000000) +
  // 100000)));
  // }
  //
  // cs.writeContactsToFile();
  // }
}
