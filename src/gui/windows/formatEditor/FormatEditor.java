package gui.windows.formatEditor;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.xml.bind.JAXBException;

import editor.Format;
import editor.Library;
import editor.XMLParser;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import javax.swing.JTabbedPane;

import gui.windows.formatEditor.events.AddNewFormatEvent;
import gui.windows.formatEditor.events.CommitChangesEvent;
import gui.windows.formatEditor.events.UpdateFormatPanelEvent;
import gui.windows.formatEditor.panels.FontPanel;
import gui.windows.formatEditor.panels.Footer;
import gui.windows.formatEditor.panels.FormatSpecificPanel;
import gui.windows.formatEditor.panels.TextReplacerPanel.TextReplacerPanel;
import gui.windows.formatEditor.panels.decorator.DecoratorPanel;
import gui.windows.formatEditor.panels.decoratorWrapper.DecoratorWrapperPanel;
import gui.windows.formatEditor.panels.position.PositionPanel;
import gui.windows.formatEditor.panels.positionWrapper.PositionWrapperPanel;
import gui.windows.formatEditor.events.FormatFileEvent;
import gui.windows.formatEditor.events.OpenLibraryEvent;
import gui.windows.formatEditor.events.RemoveFormatEvent;
import gui.windows.formatEditor.events.SaveToFileEvent;

import javax.swing.JButton;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.io.File;
import java.awt.SystemColor;

public class FormatEditor
{
	protected DefaultListModel<String>listModel;
	
	protected Library formatLibrary;
	protected JList<String> list;
	
	protected JLabel lblFormatName;
	protected JLabel lblOpenedFile;
	
	protected FontPanel fontPanel;
	protected DecoratorPanel decoratorPanel;
	protected DecoratorWrapperPanel decoratorWrapperPanel;
	protected PositionPanel positionPanel;
	protected PositionWrapperPanel positionWrapperPanel;
	protected FormatSpecificPanel formatSpecificPanel;
	protected TextReplacerPanel textReplacerPanel;
	
	protected String selectedFormatTag;
	protected Footer footer;
	private JFrame frame;
	
	/**
	 * Create the application.
	 * @throws JAXBException 
	 */
	
	public FormatEditor()
	{
		this.formatLibrary = new Library();
		initialize();
		frame.setVisible(true);
	}
	public void setLibrary(Library library)
	{
		this.formatLibrary = library;
		lblOpenedFile.setText(formatLibrary.getName());
	}
	private void afterInitializations()
	{
		list.setSelectedIndex(0);
		refreshList();
	}
	public void refreshList()
	{
		list.clearSelection();
		listModel.clear();
		Iterator<String>formatTags = formatLibrary.getFormatKeys().iterator();
		while(formatTags.hasNext())
		{
			String tag = formatTags.next();
			listModel.addElement(tag);
		}
	}
	public void openLibrary(File file) throws JAXBException
	{
		Library library = XMLParser.readLibrary(file);
		
		this.formatLibrary = library;
		
		lblOpenedFile.setText(getFormatLibrary().getName());
		
		refreshList();
	}
	public String getSelectedFormatTag()
	{
		return selectedFormatTag;
	}
	public void setSelectedFormatTag(String selectedFormatTag)
	{
		this.selectedFormatTag = selectedFormatTag;
	}
	
	public JLabel getLblFormatName()
	{
		return lblFormatName;
	}
	public PositionWrapperPanel getPositionWrapperPanel()
	{
		return positionWrapperPanel;
	}
	public FontPanel getFontPanel()
	{
		return fontPanel;
	}
	public DecoratorPanel getDecoratorPanel()
	{
		return decoratorPanel;
	}
	public PositionPanel getPositionPanel()
	{
		return positionPanel;
	}
	public Library getFormatLibrary()
	{
		return formatLibrary;
	}
	public DecoratorWrapperPanel getDecoratorWrapperPanel()
	{
		return decoratorWrapperPanel;
	}
	public TextReplacerPanel getTextReplacerPanel()
	{
		 return textReplacerPanel;
	}
	public void updatePanels(Format format)
	{
		getFormatSpecificPanel().getTag().setText(format.getTag());
		
		getDecoratorPanel().update(format);
		getDecoratorWrapperPanel().update(format);
		
		getPositionPanel().update(format);
		getPositionWrapperPanel().update(format);
		
		getFontPanel().update(format);
		
		setSelectedFormatTag(format.getTag());
		
		getTextReplacerPanel().update(format);
		
	}
	public FormatSpecificPanel getFormatSpecificPanel()
	{
		// TODO Auto-generated method stub
		return formatSpecificPanel;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	protected void addListeners()
	{
		list.addListSelectionListener(new UpdateFormatPanelEvent(this));
	}
	public JList<String> getList()
	{
		return list;
	}
	private void initialize()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(0, 630));
		frame.setBounds(100, 100, 540, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		listModel = new DefaultListModel<String>();
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel MainPanel = new JPanel();
		frame.getContentPane().add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_15 = new JPanel();
		MainPanel.add(panel_15, BorderLayout.NORTH);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_15.add(panel_5);
		panel_5.setPreferredSize(new Dimension(10, 35));
		panel_5.setMinimumSize(new Dimension(10, 35));
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		horizontalStrut_7.setPreferredSize(new Dimension(5, 0));
		horizontalStrut_7.setMinimumSize(new Dimension(5, 0));
		horizontalStrut_7.setMaximumSize(new Dimension(5, 32767));
		panel_5.add(horizontalStrut_7);
		
		JLabel lblLibraryName = new JLabel("Library name : ");
		lblLibraryName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblLibraryName);
		
		lblOpenedFile = new JLabel("Opened File name");
		lblOpenedFile.setBorder(null);
		lblOpenedFile.setBackground(SystemColor.control);
		lblOpenedFile.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblOpenedFile);
		
		JPanel panel_16 = new JPanel();
		panel_15.add(panel_16, BorderLayout.EAST);
		
		JButton btnOpenLibrary = new JButton("Open library");
		btnOpenLibrary.addActionListener(new OpenLibraryEvent(this));
		panel_16.add(btnOpenLibrary);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		MainPanel.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		footer = new Footer();
		footer.setPreferredSize(new Dimension(50, 0));
		panel_12.add(footer, BorderLayout.CENTER);
		footer.setBorder(null);
		footer.setRequestFocusEnabled(false);
		footer.setMinimumSize(new Dimension(150, 0));
		
		JPanel panel_13 = new JPanel();
		panel_12.add(panel_13, BorderLayout.EAST);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.X_AXIS));
		
		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);
		
		JButton btnWriteToFile = new JButton("Save Library");
		panel_14.add(btnWriteToFile);
		
		JButton btnNewButton_2 = new JButton("Format File");
		btnNewButton_2.addActionListener(new FormatFileEvent(this));
		panel_14.add(btnNewButton_2);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(11);
		panel_14.add(horizontalStrut_8);
		
		btnWriteToFile.addActionListener(new SaveToFileEvent(this));
		
		JPanel Center = new JPanel();
		MainPanel.add(Center);
		Center.setLayout(new BoxLayout(Center, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		Center.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JPanel panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new AddNewFormatEvent(this));
		btnNewButton.setMaximumSize(new Dimension(75, 23));
		btnNewButton.setMinimumSize(new Dimension(75, 23));
		btnNewButton.setPreferredSize(new Dimension(75, 23));
		panel_9.add(btnNewButton);
		
		JPanel formatPane = new JPanel();
		panel_7.add(formatPane);
		formatPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		formatPane.setPreferredSize(new Dimension(75, 10));
		formatPane.setMinimumSize(new Dimension(75, 10));	
		formatPane.setMaximumSize(new Dimension(75, 32767));
		formatPane.setSize(new Dimension(200, 0));
		formatPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setMaximumSize(new Dimension(75, 2147483647));
		formatPane.add(list);
		list.setVisibleRowCount(-1);
		list.setModel(listModel);
		
		JPanel dataContainer = new JPanel();
		dataContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Center.add(dataContainer);
		dataContainer.setLayout(new BorderLayout(0, 0));
		
		JPanel dataHeader = new JPanel();
		dataHeader.setSize(new Dimension(0, 50));
		dataHeader.setAlignmentY(0.0f);
		dataHeader.setAlignmentX(0.0f);
		dataHeader.setPreferredSize(new Dimension(10, 35));
		dataContainer.add(dataHeader, BorderLayout.NORTH);
		dataHeader.setLayout(new BoxLayout(dataHeader, BoxLayout.X_AXIS));
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		horizontalStrut_6.setMaximumSize(new Dimension(5, 32767));
		horizontalStrut_6.setMinimumSize(new Dimension(5, 0));
		horizontalStrut_6.setPreferredSize(new Dimension(5, 0));
		dataHeader.add(horizontalStrut_6);
		
		lblFormatName = new JLabel("Selected Format");
		dataHeader.add(lblFormatName);
		lblFormatName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panel_10 = new JPanel();
		dataHeader.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_11 = new JPanel();
		panel_10.add(panel_11, BorderLayout.EAST);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new RemoveFormatEvent(this));
		panel_11.add(btnNewButton_1);
		
		JPanel dataForm = new JPanel();
		dataContainer.add(dataForm, BorderLayout.CENTER);
		dataForm.setLayout(new BoxLayout(dataForm, BoxLayout.Y_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("");
		dataForm.add(tabbedPane);
		
		formatSpecificPanel = new FormatSpecificPanel();
		tabbedPane.addTab("Format Specific", null, formatSpecificPanel, null);
		formatSpecificPanel.setBorder(new TitledBorder(null, "FormatSpecific", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		textReplacerPanel = new TextReplacerPanel();
		tabbedPane.addTab("Text Replacer", null, textReplacerPanel, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Font", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		fontPanel = new FontPanel();
		panel.add(fontPanel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setPreferredSize(new Dimension(0, 5));
		panel.add(verticalStrut, BorderLayout.NORTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setPreferredSize(new Dimension(5, 0));
		panel.add(horizontalStrut, BorderLayout.EAST);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setPreferredSize(new Dimension(5, 0));
		panel.add(horizontalStrut_1, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Decorators", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		decoratorWrapperPanel = new DecoratorWrapperPanel();
		decoratorWrapperPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_6.add(decoratorWrapperPanel);
		
		decoratorPanel = new DecoratorPanel();
		decoratorPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_6.add(decoratorPanel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setPreferredSize(new Dimension(0, 5));
		panel_1.add(verticalStrut_1, BorderLayout.NORTH);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setPreferredSize(new Dimension(5, 0));
		panel_1.add(horizontalStrut_2, BorderLayout.EAST);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setPreferredSize(new Dimension(5, 0));
		panel_1.add(horizontalStrut_3, BorderLayout.WEST);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Position", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
		
		positionWrapperPanel = new PositionWrapperPanel();
		positionWrapperPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_8.add(positionWrapperPanel);
		
		positionPanel = new PositionPanel();
		positionPanel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_8.add(positionPanel);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setPreferredSize(new Dimension(0, 5));
		panel_2.add(verticalStrut_2, BorderLayout.NORTH);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setPreferredSize(new Dimension(5, 0));
		panel_2.add(horizontalStrut_4, BorderLayout.EAST);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		horizontalStrut_5.setPreferredSize(new Dimension(5, 0));
		panel_2.add(horizontalStrut_5, BorderLayout.WEST);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setMaximumSize(new Dimension(32767, 25));
		panel_3.setMinimumSize(new Dimension(10, 35));
		dataForm.add(panel_3);
		panel_3.setPreferredSize(new Dimension(10, 35));
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.EAST);
		
		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new UpdateFormatPanelEvent(this));
		panel_4.add(btnRestore);
		
		JButton btnSave = new JButton("Confirm");
		btnSave.addActionListener(new CommitChangesEvent(this));
		panel_4.add(btnSave);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		horizontalStrut_9.setPreferredSize(new Dimension(11, 0));
		panel_4.add(horizontalStrut_9);
		
		addListeners();
		afterInitializations();
	}
}
