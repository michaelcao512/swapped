import type { Message } from "@/types/common";


export default function MessageList({ messages }: { messages: Message[] }) {
    return (
        <ul>
            {messages.map((message) => (
                <li key={message.id}>
                    <strong>{message.user.name}:</strong> {message.content}
                </li>
            ))}
        </ul>
    );
}