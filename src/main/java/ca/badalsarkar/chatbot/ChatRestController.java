package ca.badalsarkar.chatbot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatRestController {

    @PostMapping("/message")
    public ChatResponse processMessage(@RequestBody ChatMessage chatMessage) {
        // Simple bot logic, you can replace it with actual logic
        String userMessage = chatMessage.getMessage();
        String botReply = "You said: " + userMessage + ". I'm still learning!";

        // Return the bot's response
        return new ChatResponse(botReply);
    }

    // Class to represent the user message
    public static class ChatMessage {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    // Class to represent the bot response
    public static class ChatResponse {
        private String reply;

        public ChatResponse(String reply) {
            this.reply = reply;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }
    }
}
