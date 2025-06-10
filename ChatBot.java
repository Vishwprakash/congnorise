import java.util.*;

public class ChatBot {
    private Map<String, String> responses;
    private Scanner scanner;
    private List<String> fallbackResponses;

    public ChatBot() {
        this.responses = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.fallbackResponses = new ArrayList<>();
        initializeResponses();
        initializeFallbacks();
    }

    private void initializeResponses() {
        // Greetings
        responses.put("hi", "Hello! How can I assist you today?");
        responses.put("hello", "Hi there! Need any help?");
        responses.put("hey", "Hey! How can I help you?");
        responses.put("good morning", "Good morning! Hope you have a great day.");
        responses.put("good evening", "Good evening! What can I do for you?");
        responses.put("good night", "Good night! Talk to you soon.");
        responses.put("how are you", "I'm doing great, thanks! How about you?");
        responses.put("what's up", "Just here to help. What's going on?");
        responses.put("who are you", "I'm your virtual assistant, here to make your day easier!");
        responses.put("what can you do", "I can chat, tell jokes, and help with general queries!");

        // Assistance
        responses.put("help", "Sure! Please tell me what you're looking for.");
        responses.put("i need help", "I'm here for you. What's the issue?");
        responses.put("can you help me", "Absolutely! Just let me know the problem.");

        // Fun
        responses.put("tell me a joke", "Why don’t skeletons fight each other? Because they don’t have the guts! 😂");
        responses.put("joke", "Why did the computer go to therapy? Too many bytes of emotion.");

        // Personal
        responses.put("what is your name", "I'm ChatBot, your AI companion.");
        responses.put("thank you", "You're welcome! 😊");
        responses.put("thanks", "Anytime!");

        // Tech
        responses.put("reset password", "Click on 'Forgot Password' and follow the instructions.");
        responses.put("change password", "Go to settings > security to update your password.");
        responses.put("technical issue", "I'm sorry! Please describe the issue in detail so I can assist.");

        // Info
        responses.put("location", "I'm available everywhere — online 24/7!");
        responses.put("hours", "I'm always here. 24 hours, every day.");
        responses.put("contact", "Reach us at: support@example.com.");
        responses.put("email", "You can email us at: support@example.com.");

        // Exit
        responses.put("bye", "Goodbye! It was great talking to you.");
        responses.put("exit", "See you next time. Take care!");
        responses.put("quit", "Session ended. Have a nice day!");
        responses.put("goodbye", "Goodbye! Hope to chat again soon.");
    }

    private void initializeFallbacks() {
        fallbackResponses.add("Hmm... I didn’t get that. Could you rephrase?");
        fallbackResponses.add("I'm still learning. Try asking something else?");
        fallbackResponses.add("Interesting! Can you clarify a bit more?");
        fallbackResponses.add("Let me think... Can you try saying it differently?");
    }

    private void simulateTyping(String response) {
        for (char c : response.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(30); // typing delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public void startChat() {
        System.out.println("Welcome! I'm ChatBot. Type 'exit' to end the conversation.");
        System.out.print("Before we start, what's your name? ");
        String userName = scanner.nextLine().trim();
        System.out.println("Nice to meet you, " + userName + "! 😊 Let's chat.\n");

        while (true) {
            System.out.print(userName + ": ");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("exit") || input.equals("bye") || input.equals("quit")) {
                simulateTyping(responses.getOrDefault(input, "Goodbye! It was nice talking to you."));
                break;
            }

            boolean matched = false;
            for (String key : responses.keySet()) {
                if (input.contains(key)) {
                    simulateTyping("Bot: " + responses.get(key));
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                String fallback = fallbackResponses.get(new Random().nextInt(fallbackResponses.size()));
                simulateTyping("Bot: " + fallback);
            }
        }
    }

    public static void main(String[] args) {
        new ChatBot().startChat();
    }
}