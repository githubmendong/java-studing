package chat.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatWindow {

	// GUI Components
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	// Networking Components
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	// Constructor: 창 생성 및 네트워킹 컴포넌트 초기화
	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.socket = socket;

		// 네트워크 스트림 초기화
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// GUI 생성 및 표시
	public void show() {
		// 메시지 전송 버튼 설정
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMessage();
			}
		});

		// 텍스트 입력 필드 설정
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

		// 패널 설정
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// 텍스트 영역 설정
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// 창 설정
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// 채팅 클라이언트 스레드 시작
		new ChatClientThread().start();
	}




	// 채팅 종료 메서드
	private void finish() {
		pw.println("quit");
		System.exit(0);
	}

	// 메시지 전송 메서드
	private void sendMessage() {
		String message = textField.getText();
		textField.setText("");
		textField.requestFocus();

		if("quit".equals(message)) {
			finish();
		}

		pw.println("chat:" + message);
		updateTextArea("Me >> " + message);
	}

	// 텍스트 영역 업데이트 메서드
	private void updateTextArea(String message) {
		String formattedTime = getCurrentFormattedTime();
		textArea.append(formattedTime + " " + message);
		textArea.append("\n");
	}

	// 현재 시간을 "HH:mm:ss" 형식으로 반환하는 메서드
	private String getCurrentFormattedTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new Date());
	}

	// 클라이언트 채팅 스레드: 서버로부터 메시지를 수신받아 텍스트 영역에 표시
	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}

					if (!"Enter: ".equals(line)) {
						textArea.append(line);
						textArea.append("\n");
					}
				}
			} catch (SocketException e) {
				System.out.println("You have left the chat room!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				finish();
			}
		}
	}
}
