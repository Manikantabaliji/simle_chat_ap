## GitHub Report for "chatapplication" Code

### Overview:
The provided code consists of two Java classes named "Reciver" and "Server," representing a simple chat application. The application allows two users to exchange messages in real-time using Java Swing components and sockets for communication. The "Reciver" class is designed to receive messages from the server and display them on the client-side, while the "Server" class handles the communication and message distribution between clients.

### Reciver Class:
The "Reciver" class is responsible for displaying the messages received from the server and enabling users to send messages to the server. It extends the JFrame class and implements the ActionListener interface to handle the "Send" button's action. The class sets up the user interface with a text field for entering messages, a chat panel to display messages, and a "Send" button for message submission. The "Reciver" class also establishes a socket connection to the server for communication.

### Server Class:
The "Server" class acts as the server for the chat application. It extends the JFrame class and implements the ActionListener interface to handle messages from the client-side. The server sets up the user interface similar to the "Reciver" class, allowing the server user to send and receive messages. It creates a ServerSocket on port 6001 and listens for incoming client connections. When a client connects, the server sets up a DataInputStream and a DataOutputStream to send and receive messages. The server uses the "formatLabel" method to format and display messages on the chat panel.

### User Interface:
Both the "Reciver" and "Server" classes create a user interface with similar components. The top panel contains profile and call icons, along with the user's name and online status. The chat panel is below the top panel, where messages are displayed in a vertical box layout. The user can type messages in the text field at the bottom, and the "Send" button allows them to send messages to the server.

### Functionality:
- The "Reciver" class receives messages from the server and displays them on the chat panel.
- The "Server" class receives messages from the "Reciver" and "Server" users and distributes them accordingly to both clients.
- Users can send messages by typing in the text field and clicking the "Send" button.
- Messages are displayed with a timestamp indicating the time of message arrival.

