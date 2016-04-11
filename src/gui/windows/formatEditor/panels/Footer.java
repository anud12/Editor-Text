package gui.windows.formatEditor.panels;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Footer extends JPanel
{
	protected JLabel inLocation;
	protected JLabel outLocation;
	
	public Footer()
	{
		super();
		//this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setPreferredSize(new Dimension(50, 50));
		this.setRequestFocusEnabled(false);
		this.setMinimumSize(new Dimension(150, 150));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
	}
	
	
}
