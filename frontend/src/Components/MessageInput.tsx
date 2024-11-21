import { useState, KeyboardEvent } from "react";

interface MessageInputProps {
    onSend: (message: string) => void;
}

export default function MessageInput({ onSend }: MessageInputProps) {
    const [input, setInput] = useState<string>("");

    const handleSend = () => {
        if (input.trim() !== "") {
            onSend(input);
            setInput(""); // Clear input field
        }
    };

    const handleKeyDown = (e: KeyboardEvent<HTMLInputElement>) => {
        if (e.key === "Enter") handleSend();
    };

    return (
        <div>
            <input
                type="text"
                value={input}
                onChange={(e) => setInput(e.target.value)}
                onKeyDown={handleKeyDown}
                style={{ width: "80%", marginRight: "10px" }}
                placeholder="Type your message here..."
            />
            <button onClick={handleSend}>Send</button>
        </div>
    );
}
