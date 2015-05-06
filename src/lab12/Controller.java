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
    view.updateViewWithContact(firstContact, contactIndex + 1, cs
        .getContacts().size());

    bDayCheck(firstContact);
  }

  private boolean isBDayToday(final Contact c) {
    GregorianCalendarExtended today = new GregorianCalendarExtended();
    if (c.getBirthday() != null) {
      return (today.get(Calendar.MONTH) == c.getBirthday().
          get(Calendar.MONTH) && today
          .get(Calendar.DATE) == c.getBirthday().get(Calendar.DATE));
    }
    else {
      return false;
    }
  }

  private void bDayCheck(final Contact contact) {
    if (isBDayToday(contact)) {
      Messages.showBDayMessage(view.getMainFrame(), view.getTxtFName()
          .getText());
    }
  }

  private class WListener implements WindowListener {
    public void windowOpened(final WindowEvent e) {
    }

    @Override
    public void windowClosing(final WindowEvent e) {
      int returnCode = saveContact();

      if (returnCode == ReturnCode.SUCCESSFUL) {
        view.getMainFrame().dispose();
        System.exit(0);
      }
    }

    public void windowClosed(final WindowEvent e) {
    }

    public void windowIconified(final WindowEvent e) {
    }

    public void windowDeiconified(final WindowEvent e) {
    }

    public void windowActivated(final WindowEvent e) {
    }

    public void windowDeactivated(final WindowEvent e) {
    }
  }

  private class AListener implements ActionListener {
    public void actionPerformed(final ActionEvent e) {
      if (e.getSource() == view.getBtnFirst()) {
        btnFirstPressed();
      }
      else if (e.getSource() == view.getBtnPrevious()) {
        btnPreviousPressed();
      }
      else if (e.getSource() == view.getBtnNext()) {
        btnNextPressed();
      }
      else if (e.getSource() == view.getBtnLast()) {
        btnLastPressed();
      }
      else if (e.getSource() == view.getBtnNew()) {
        btnNewPressed();
      }
      else if (e.getSource() == view.getBtnDelete()) {
        btnDeletePressed();
      }
      else if (e.getSource() == view.getBtnFind()) {
        btnFindPressed();
      }
    }
  }

  public final void btnFindPressed() {
    SearchWindow searchWindow = new SearchWindow();
    searchWindow.run();

    if (searchWindow.getDialogOKCancelResult() == JOptionPane.OK_OPTION) {

      SearchService searchService = new SearchService(
          searchWindow.getReturnValues(), cs.getContacts());

      int resultIndex = searchService.search();

      if (resultIndex != ReturnCode.NOT_FOUND) {
        view.updateViewWithContact(cs.getContacts().get(resultIndex),
            resultIndex + 1, cs.getContacts().size());
        contactIndex = resultIndex;
      }
      else {
        Messages.showSearchNotFoundMessage(view.getMainFrame());
        btnFindPressed();
      }
    }
  }

  public final void btnDeletePressed() {
    int messageResult = Messages.showDeleteContactMessage(view.getMainFrame(),
        view.getTxtFName().getText(), view.getTxtLName().getText());

    if (messageResult == ReturnCode.SUCCESSFUL) {
      cs.getContacts().remove(contactIndex);
      if (contactIndex < cs.getContacts().size()) {
        Contact c = cs.getContacts().get(contactIndex);
        view.updateViewWithContact(c, contactIndex + 1, cs.getContacts()
            .size());
      }
      else {
        contactIndex--;
        Contact c = cs.getContacts().get(contactIndex);
        cs.writeContactsToFile();
        view.updateViewWithContact(c, contactIndex + 1, cs.getContacts()
            .size());
      }
      if (cs.getContacts().size() == 1) {
        view.getBtnDelete().setEnabled(false);
      }
    }
  }

  public final void btnNewPressed() {
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

  public final int saveContact() {
    String birthdayText = view.getTxtBirthday().getText();
    boolean isSuccessful = true;

    if (!Pattern.matches(GregorianCalendarExtended.DATE_FORMAT, birthdayText)
        && !birthdayText.isEmpty()) {
      Messages.showDateIncorrectFormatMessage(view.getMainFrame());
      view.getTxtBirthday().requestFocusInWindow();
      view.getTxtBirthday().selectAll();
      isSuccessful = false;
    }

    if (view.getTxtLName().getText().isEmpty() && (isSuccessful)) {

      Messages.showLNameMissingMessage(view.getMainFrame());
      view.getTxtLName().requestFocusInWindow();

      isSuccessful = false;
    }

    if (isSuccessful) {
      Contact contact = cs.getContacts().get(contactIndex);

      contact.setFName(view.getTxtFName().getText());
      contact.setLName(view.getTxtLName().getText());
      contact.getAddress().setStreet(view.getTxtStreet().getText());
      contact.getAddress().setCity(view.getTxtCity().getText());
      contact.getAddress().setState(
          (String) view.getCmbState().getSelectedItem());
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

    return ReturnCode.UNSUCCESSFUL;
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

  public final void btnLastPressed() {
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

  public final void btnNextPressed() {
    int returnCode = saveContact();

    if (returnCode == ReturnCode.SUCCESSFUL) {
      contactIndex++;
      Contact contact = cs.getContacts().get(contactIndex);
      view.updateViewWithContact(contact, contactIndex + 1, cs.getContacts()
          .size());
      bDayCheck(contact);
    }
  }

  public final void btnPreviousPressed() {
    int returnCode = saveContact();

    if (returnCode == ReturnCode.SUCCESSFUL) {
      contactIndex--;
      Contact contact = cs.getContacts().get(contactIndex);
      view.updateViewWithContact(contact, contactIndex + 1, cs.getContacts()
          .size());
      bDayCheck(contact);
    }
  }
}
