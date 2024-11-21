export type User = {
    id: number;
    name: string;
};

export type Message = {
    id: number;
    user: User;
    timestamp: Date;
    content: string;
};

export type Room = {
    id: number;
    name: string;
    users: User[];
    messages: Message[];
};

