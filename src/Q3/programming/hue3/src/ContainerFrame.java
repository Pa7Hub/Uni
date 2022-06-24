package Q3.programming.hue3.src;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;

import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

public class ContainerFrame extends JFrame {
	private static final String Err1 = "Entry can not be empty";
	private static final String Err2 = "Create container (e.g. a stack) first";
	private static final String Err3 = "You must implement a class with name ";
	private static final String Err4 = "Precondition violated";
	private Container container;
	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JButton buttonCreate = null;
	private javax.swing.JTextField elementToPush = null;
	private javax.swing.JButton buttonPush = null;
	private javax.swing.JButton buttonRemove = null;
	private javax.swing.JTextField removedElement = null;

	private javax.swing.JTextArea jTextArea = null;
	private javax.swing.JTextField message = null;
	private javax.swing.JMenuBar jJMenuBar = null;
	private javax.swing.JMenu menuTesting = null;
	private javax.swing.JMenuItem menuItemExit = null;
	private javax.swing.JMenu menuActions = null;
	private javax.swing.JMenuItem menuItemCreate = null;
	private javax.swing.JMenuItem menuItemPush = null;
	private javax.swing.JMenuItem menuItemRemove = null;
	public ContainerFrame(String title) throws HeadlessException {
		super(title);
		initialize();
	}

	/**
	 * This method initializes this
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getJJMenuBar());
		this.setBounds(100, 100, 450, 280);
		this.setTitle("Visual Testing");
		this.setLocationRelativeTo(null);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			}
		});
	}

/*---------------------- ACTIONS ---------------- */
	private void createAction(){
		String containerClassName = ClassnameDeclarations.ContainerClassName;
		message.setText("");
		try{
			container = (Container)Class.forName(containerClassName).newInstance();
		}catch(ClassNotFoundException cnfe){
			message.setText(Err3 + containerClassName);
			return;
		}catch(IllegalAccessException iae){
			message.setText("Class" + containerClassName + " is invisible");
			return;
		}catch(InstantiationException ie){
			message.setText("Abstract class " + containerClassName + " can not be instantiated");
			return;
		}
		jTextArea.setVisible(true);
		removedElement.setText("");
		updateContainerDisplay();
	}

	private void pushAction(){
		if(elementToPush.getText().equals("")){
			message.setText(Err1);
			return;
		}
		message.setText("");
		if(container == null) {
			sendContainerNotCreatedMessage();
			return;
		}
		container.push(this.createElementAsObject(ClassnameDeclarations.DataClassName));
		updateContainerDisplay();
		elementToPush.setText("");
	}

	private Data createElementAsObject(String elementClassName){
		Class elementClass = null;
		Constructor constr = null;
		try{
			elementClass = Class.forName(elementClassName);
			constr = elementClass.getConstructor(new Class[]{java.lang.String.class});
			return (Data)constr.newInstance(new Object[]{elementToPush.getText()});
		}catch(ClassNotFoundException cnfe){
			message.setText(Err3 + elementClassName);
			return null;
		}catch(Exception ex){
			message.setText("Error when creating instance for class: " + elementClassName);
			return null;
		}
	}

	private void removeAction(){
		if(container == null) {
			sendContainerNotCreatedMessage();
			return;
		}
		if(container.isEmpty()){
			message.setText(Err4);
			return;
		}
		removedElement.setText(container.remove().getContents());
		updateContainerDisplay();
	}
/*---------------------- ACTIONS END ------------ */
/*---------------------- Operations -------------- */
	private void updateContainerDisplay(){
		this.jTextArea.setText(this.container.toString());
	}

	private void sendContainerNotCreatedMessage(){
		message.setText(Err2);
	}
/*---------------------- Operations END----------- */

	/**
	 * This method initializes jContentPane
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getButtonCreate(), null);
			jContentPane.add(getElementToPush(), null);
			jContentPane.add(getButtonPush(), null);
			jContentPane.add(getButtonRemove(), null);
			jContentPane.add(getRemovedElement(), null);
			jContentPane.add(getJTextArea(), null);
			jContentPane.add(getMessage(), null);
			jContentPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		}
		return jContentPane;
	}
	/**
	 * This method initializes buttonCreate
	 */
	private javax.swing.JButton getButtonCreate() {
		if(buttonCreate == null) {
			buttonCreate = new javax.swing.JButton();
			buttonCreate.setBounds(24, 16, 108, 28);
			buttonCreate.setText("Create (F1)");
			buttonCreate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createAction();
				}
			});
		}
		return buttonCreate;
	}

	/**
	 * This method initializes elementToPush
	 */
	private javax.swing.JTextField getElementToPush() {
		if(elementToPush == null) {
			elementToPush = new javax.swing.JTextField();
			elementToPush.setBounds(24, 50, 108, 28);
			elementToPush.setToolTipText("Enter a non-empty string representation of an element here");
		}
		return elementToPush;
	}
	/**
	 * This method initializes buttonPush
	 */
	private javax.swing.JButton getButtonPush() {
		if(buttonPush == null) {
			buttonPush = new javax.swing.JButton();
			buttonPush.setBounds(138, 50,108, 28);
			buttonPush.setText("Push (F2)");
			buttonPush.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pushAction();
				}
			});
		}

		return buttonPush;
	}
	/**
	 * This method initializes buttonRemove
	 */
	private javax.swing.JButton getButtonRemove() {
		if(buttonRemove == null) {
			buttonRemove = new javax.swing.JButton();
			buttonRemove.setBounds(24, 85, 108, 28);
			buttonRemove.setText("Remove (F3)");
			buttonRemove.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					removeAction();
				}
			});
		}
		return buttonRemove;
	}
	/**
	 * This method initializes poppedElement
	 */
	private javax.swing.JTextField getRemovedElement() {
		if(removedElement == null) {
			removedElement = new javax.swing.JTextField();
			removedElement.setBounds(138, 85, 108, 28);				removedElement.setEditable(false);
	}
		return removedElement;
	}
	/**
	 * This method initializes jTextArea
	 */
	private javax.swing.JTextArea getJTextArea() {
		if(jTextArea == null) {
			jTextArea = new javax.swing.JTextArea();
			jTextArea.setBounds(261, 12, 143, 177);
			jTextArea.setEditable(false);
			jTextArea.setVisible(false);
		}
		return jTextArea;
	}

	/**
	 * This method initializes message
	 */
	private javax.swing.JTextField getMessage() {
		if(message == null) {
			message = new javax.swing.JTextField();
			message.setBounds(25, 194, 379, 20);
			message.setEditable(false);
		}
		return message;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("System Look and Feel Failure");
		}
		ContainerFrame frame = new ContainerFrame("Container");
		frame.setVisible(true);
	}

	/**
	 * This method initializes jJMenuBar
	 *
	 * @return javax.swing.JMenuBar
	 */
	private javax.swing.JMenuBar getJJMenuBar() {
		if(jJMenuBar == null) {
			jJMenuBar = new javax.swing.JMenuBar();
			jJMenuBar.add(getMenuContainer());
			jJMenuBar.add(getMenuActions());
		}
		return jJMenuBar;
	}
	/**
	 * This method initializes menuContainer
	 *
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getMenuContainer() {
		if(menuTesting == null) {
			menuTesting = new javax.swing.JMenu();
			menuTesting.add(getMenuItemExit());
			menuTesting.setText("Testing");
		}
		return menuTesting;
	}
	/**
	 * This method initializes menuItemExit
	 *
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuItemExit() {
		if(menuItemExit == null) {
			menuItemExit = new javax.swing.JMenuItem();
			menuItemExit.setText("Exit");
			menuItemExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return menuItemExit;
	}
	/**
	 * This method initializes menuActions
	 *
	 * @return javax.swing.JMenu
	 */
	private javax.swing.JMenu getMenuActions() {
		if(menuActions == null) {
			menuActions = new javax.swing.JMenu();
			menuActions.add(getMenuItemCreate());
			menuActions.add(getMenuItemPush());
			menuActions.add(getMenuItemRemove());
			menuActions.setText("Actions");
		}
		return menuActions;
	}
	/**
	 * This method initializes menuItemCreate
	 *
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuItemCreate() {
		if(menuItemCreate == null) {
			menuItemCreate = new javax.swing.JMenuItem();
			menuItemCreate.setText("Create new Container");
			menuItemCreate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
			menuItemCreate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					createAction();
				}
			});
		}
		return menuItemCreate;
	}
	/**
	 * This method initializes menuItemPush
	 *
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuItemPush() {
		if(menuItemPush == null) {
			menuItemPush = new javax.swing.JMenuItem();
			menuItemPush.setText("Push");
			menuItemPush.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
			menuItemPush.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pushAction();
				}
			});

		}
		return menuItemPush;
	}
	/**
	 * This method initializes menuItemRemove
	 *
	 * @return javax.swing.JMenuItem
	 */
	private javax.swing.JMenuItem getMenuItemRemove() {
		if(menuItemRemove == null) {
			menuItemRemove = new javax.swing.JMenuItem();
			menuItemRemove.setText("Remove");
			menuItemRemove.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					removeAction();
				}
			});
			menuItemRemove.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		}
		return menuItemRemove;
	}
}  //  @jve:visual-info  decl-index=0 visual-constraint="-164,-202"
