"use client";

import { useState } from "react";

interface Message {
  id: number;
  content: string;
}

export default function Home() {
  const [messages, setMessages] = useState<Message[]>([]);
  const [input, setInput] = useState<string>("");

  const sendMessage = () => {
    if (input.trim() !== "") {
      const newMessage: Message = { id: Date.now(), content: input };
      setMessages((prev) => [...prev, newMessage]); // Add message to state
      setInput(""); // Clear input field
    }
  };

  return (
      <div style={{ padding: "20px" }}>
        <h1>Swapped Game - Chat</h1>
        <div
            style={{
              border: "1px solid #ccc",
              padding: "10px",
              height: "300px",
              overflowY: "scroll",
              marginBottom: "10px",
            }}
        >
          {messages.map((msg) => (
              <p key={msg.id}>{msg.content}</p>
          ))}
        </div>
        <input
            type="text"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            onKeyDown={(e) => e.key === "Enter" && sendMessage()}
            style={{ width: "80%", marginRight: "10px" }}
            placeholder="Type your message here..."
        />
        <button onClick={sendMessage}>Send</button>
      </div>
  );
}
