```markdown
# Online Shopping Management System

This Java project implements an Online Shopping Management System with a client-server architecture. Users can add products to their cart, view the cart, and submit orders. The system uses JavaFX for the client-side GUI and MySQL for the server-side database.

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/aspo29/JavaProject.git
   cd your-repository
   ```

2. **Compile the project:**

   ```bash
   javac -d bin src/*/*.java
   ```

3. **Run the server:**

   ```bash
   java com.example.onlineshopingmanagementsystem.project.serverside.Main
   ```

4. **Run the client:**

   ```bash
   java com.example.onlineshopingmanagementsystem.project.clientside.Main
   ```

## Project Structure

```
.
├── bin           # Compiled bytecode
├── lib           # Jar files
└── src
    ├── client    # Client-side implementation
    ├── server    # Server-side implementation
    ├── messages  # Serializable classes for client-server communication
    └── utils     # Common classes for client and server
```

## Server Side

### `Main` Class

The `Main` class on the server side serves as the entry point for starting the server.

### `ServerSockets` Class

The `ServerSockets` class handles incoming client connections, creates a `ClientHandler` for each connected client, and manages the list of connected clients.

### `ClientHandler` Class

The `ClientHandler` class handles communication with individual clients. It implements the `Runnable` interface for concurrent handling of multiple clients.

### `ServerData` Class

The `ServerData` class performs database operations on the server side, including saving products, retrieving all products, deleting all data, and submitting orders.

## Client Side

### `Main` Class

The `Main` class on the client side serves as the entry point for starting the JavaFX application.

### `ClientGUI` Class

The `ClientGUI` class implements the JavaFX application for the client. It allows users to add products to their cart, view the cart, and submit orders.

### `ClientSocket` Class

The `ClientSocket` class handles communication with the server. It establishes a connection, sends data, and receives data from the server.

## Usage

1. Start the server using the `Main` class on the server side.

2. Start the client using the `Main` class on the client side.

3. Use the client GUI to interact with the Online Shopping Management System.

## License

This project is licensed under the MIT License. © Aashutosh Poudel, 2024.
```
