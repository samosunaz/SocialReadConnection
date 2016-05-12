/**
 * @author María Fernanda López Cárdenas	A01229740
 * @author Samuel Osuna Zatarain			A01630427
 * FrameView.java
 * May 8, 2016
 * Version 2.0
 */

package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameView extends JFrame{
	
	private PanelControl panelControl;
	
	public FrameView() {
		super("Reading Connection");
		this.panelControl = new PanelControl();
		this.add(this.panelControl);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Sets the Control Panel to the Frame 
	 * @param panelControl a Control Panel object
	 */
	public void setPanelControl(JPanel panelControl) {
		this.panelControl = new PanelControl();
	}
	
	/**
	 * 
	 * @return the Control Panel
	 */
	public JPanel getPanelControl() {
		return this.panelControl;
	}
}
