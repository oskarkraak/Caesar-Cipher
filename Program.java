import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Program extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea = new JTextArea("");
	private JScrollPane textAreaScrollPane = new JScrollPane(textArea);
	private JButton btn_encode = new JButton();
	private JButton btn_decode = new JButton();

	public Program() {
		super();
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		int frameWidth = 537;
		int frameHeight = 525;
		setSize(frameWidth, frameHeight);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (d.width - getSize().width) / 2;
		int y = (d.height - getSize().height) / 2;
		setLocation(x, y);
		setTitle("Caesar cipher");
		setResizable(false);
		Container cp = getContentPane();
		cp.setLayout(null);

		textAreaScrollPane.setBounds(16, 16, 337, 449);
		textArea.setFont(new Font("Dialog", Font.BOLD, 16));
		cp.add(textAreaScrollPane);
		
		btn_encode.setBounds(376, 32, 129, 41);
		btn_encode.setText("Encode");
		btn_encode.setMargin(new Insets(2, 2, 2, 2));
		btn_encode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btn_encode_ActionPerformed(evt);
			}
		});
		cp.add(btn_encode);
		
		btn_decode.setBounds(376, 96, 129, 41);
		btn_decode.setText("Decode");
		btn_decode.setMargin(new Insets(2, 2, 2, 2));
		btn_decode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btn_decode_ActionPerformed(evt);
			}
		});
		cp.add(btn_decode);

		setVisible(true);
	}

	public static void main(String[] args) {
		new Program();
	}

	public void btn_encode_ActionPerformed(ActionEvent evt) {
		String text = textArea.getText();
		text = Coder.encode(text);
		textArea.setText(text);
	}

	public void btn_decode_ActionPerformed(ActionEvent evt) {
		String text = textArea.getText();
		text = Coder.decode(text);
		textArea.setText(text);
	}

}
