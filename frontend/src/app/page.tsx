"use client";

import { useEffect, useState } from "react";
import MessageInput from "@/components/MessageInput";
import MessageList from "@/components/MessageList";
import type { Message } from "@/types/common";

import { Stomp } from '@stomp/stompjs';
import {json} from "node:stream/consumers";

export default function ChatApp() {
    const [client, setClient] = useState<any>(null);
    const [messages, setMessages] = useState<Message[]>([]);
    const [idMessageCounter, setIdMessageCounter] = useState<number>(0);

    // Establish WebSocket connection
    const connectWebSocket = () => {
        const client = Stomp.client('ws://localhost:8080/ws');
        client.connect({}, () => {
            const destination = "/topic/messages/1";
            client.subscribe(destination, (message) => {
                console.log("received message", message);
                const newMessage: Message = JSON.parse(message.body);
                setMessages((prevMessages) => [...prevMessages, newMessage]);
            });
        });
        setClient(client);
    };

   const handleSendMessage = (text: string) => {
        const newMessage: Message = {
            id: idMessageCounter,
            user: { id: 1, name: "you"},
            timestamp: new Date(),
            content: text,
        };
        const destination = '/app/sendMessage/1';
        client.send(destination, {}, JSON.stringify(newMessage));
        setIdMessageCounter(idMessageCounter + 1);

   }
    useEffect(() => {
        connectWebSocket();
        return () => {
            client && client.disconnect();
        };
    }, []);

    useEffect (() => {

    }, [messages]);


    return (
        <div style={{ padding: "20px" }}>
            <h1>Swapped Game - Chat</h1>
            <MessageList messages={messages} />
            <MessageInput onSend={handleSendMessage} />
        </div>
    );
}
