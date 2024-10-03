function sendMessage() {
  const userInput = document.getElementById("user-input").value;
  if (userInput.trim() === "") return;

  const chatBody = document.getElementById("chat-body");

  // Create user message element
  const userMessage = document.createElement("div");
  userMessage.classList.add("chat-message", "user-message");
  userMessage.textContent = userInput;
  chatBody.appendChild(userMessage);

  // Clear input field
  document.getElementById("user-input").value = "";

  // Scroll to the bottom
  chatBody.scrollTop = chatBody.scrollHeight;

  // Send user message to the backend
  fetch("/api/chat/message", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ message: userInput }),
  })
    .then((response) => response.json())
    .then((data) => {
      // Create bot message element
      const botMessage = document.createElement("div");
      botMessage.classList.add("chat-message", "bot-message");
      botMessage.textContent = data.reply;
      chatBody.appendChild(botMessage);

      // Scroll to the bottom
      chatBody.scrollTop = chatBody.scrollHeight;
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}
