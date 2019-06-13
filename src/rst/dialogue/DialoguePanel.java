package rst.dialogue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import rst.assets.AssetRegistry;

public class DialoguePanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private DialogueEntry dialogue;
	
	private final JLabel text;
	private final JButton option1, option2, option3, option4;
	
	public DialoguePanel() {
		setLayout(new BorderLayout());
		text = new JLabel("Dialogue...");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setAlignmentX(CENTER_ALIGNMENT);
		
		option1 = new JButton();
		option1.setActionCommand("1");
		option1.addActionListener(this);
		option2 = new JButton();
		option2.addActionListener(this);
		option2.setActionCommand("2");
		option3 = new JButton();
		option3.addActionListener(this);
		option3.setActionCommand("3");
		option4 = new JButton();
		option4.addActionListener(this);
		option4.setActionCommand("4");
		setDialogue(null);
		
		AssetRegistry.getFonts().onLoad(() -> {
			setFont(text);
			setFont(option1);
			setFont(option2);
			setFont(option3);
			setFont(option4);
		});
		
		JPanel top = new JPanel();
		top.setLayout(new BorderLayout());
		top.add(text, BorderLayout.CENTER);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 4));
		bottom.add(option1);
		bottom.add(option2);
		bottom.add(option3);
		bottom.add(option4);
		
		add(top, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int selection = Integer.parseInt(e.getActionCommand()) - 1;
		
		dialogue.execute(this, selection);
	}
	
	public void setDialogue(DialogueEntry d) {
		this.dialogue = d;
		
		if(d == null) {
			text.setText(" ");
			option1.setVisible(true);
			option1.setText(" ");
			option1.setEnabled(false);
			option2.setText(" ");
			option2.setEnabled(false);
			option3.setText(" ");
			option3.setEnabled(false);
			option4.setText(" ");
			option4.setEnabled(false);
		}
		else {
			text.setText(d.getDialogue());
			option1.setText(d.getResponses()[0]);
			option1.setEnabled(true);
			option2.setEnabled(false);
			option2.setText(" ");
			option3.setEnabled(false);
			option3.setText(" ");
			option4.setEnabled(false);
			option4.setText(" ");
			if(d.getResponses().length > 1) {
				option2.setText(d.getResponses()[1]);
				option2.setEnabled(true);
				if(d.getResponses().length > 2) {
					option3.setText(d.getResponses()[2]);
					option3.setEnabled(true);
					if(d.getResponses().length > 3) {
						option4.setText(d.getResponses()[3]);
						option4.setEnabled(true);
					}
				}
			}
		}
	}
	
	private static void setFont(JComponent field) {
		field.setFont(AssetRegistry.getFonts().get("Montserrat-Regular").getFont().deriveFont(20.0f));
	}
	
	public boolean isInDialogue() {
		return dialogue != null;
	}
	
	public String getDialogueName() {
		return dialogue.getDialogue();
	}
}
