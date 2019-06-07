package rst.window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import rst.assets.AssetRegistry;
import rst.render.RenderPanel;

public class MainContext extends Context {

	private static final long serialVersionUID = 1L;
	
	private final RenderPanel panel;
	
	public MainContext() {
		super(true,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - 424,
				(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - 239,
				 new Dimension(848, 477), JFrame.MAXIMIZED_BOTH);
		
		setLayout(new BorderLayout());
		
		JButton exit = new JButton("Exit");
		AssetRegistry.getFonts().onLoad(() -> exit.setFont(AssetRegistry.getFonts().get("Montserrat-Regular").getFont().deriveFont((float)exit.getFont().getSize())));
		exit.addActionListener((event) -> System.exit(0));
		
		panel = new RenderPanel();
		
		add(exit, BorderLayout.SOUTH);
		add(panel, BorderLayout.CENTER);
	}
	
	@Override
	public void makeContextForFrame(JFrame frame) {
		super.makeContextForFrame(frame);
		
		panel.requestFocus();
		
		panel.startPainting();
	}
	
	@Override
	public void transferContext(Context other) {
		super.transferContext(other);
		
		panel.stopPainting();
	}
}
