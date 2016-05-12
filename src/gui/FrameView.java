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
	public void setPanelControl(JPanel panelControl) {
		this.panelControl = new PanelControl();
	}
	
	public JPanel getPanelControl() {
		return this.panelControl;
	}
}
