//ChatWindow.java

package chat.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatWindow {
	private Socket socket;
	private PrintWriter pw;
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		this.socket = socket;
		try {
			this.pw = new PrintWriter(socket.getOutputStream(), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		new ChatClientThread(socket).start();

	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		// ChatClientThread 생성하고 실행
	}

	private void finish() {
		// quit 프로토콜 구현
		pw.println("QUIT:");

		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		// exit java(JVM)
		System.exit(0);
	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로코톨 구현:" + message);

		textField.setText("");
		textField.requestFocus();

		// ChatClientThread 에서 서버로 부터 받은 메세지가 있다고 치고~~
		updateTextArea("마이콜: " + message);
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		private Socket socket;
		public ChatClientThread(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			try {
				Scanner scanner = new Scanner(socket.getInputStream());
				while (scanner.hasNextLine()) {
					updateTextArea(scanner.nextLine());
				}
				scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}