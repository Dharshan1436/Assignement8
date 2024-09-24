package assignment8.realtimeExample;

import java.util.HashMap;
import java.util.Map;

class InvalidFeedbackContentException extends RuntimeException {
    public InvalidFeedbackContentException(String message) {
        super(message);
    }
}

class FeedbackNotFoundException extends Exception {
    public FeedbackNotFoundException(String message) {
        super(message);
    }
}

class Feedback {
    private String feedbackId;
    private String content;

    public Feedback(String feedbackId, String content) {
        this.feedbackId = feedbackId;
        this.content = content;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public String getContent() {
        return content;
    }
}

public class Program10 {
    private Map<String, Feedback> feedbackDatabase = new HashMap<>();

    public void submitFeedback(String feedbackId, String content) {
        validateFeedbackContent(content);
        Feedback feedback = new Feedback(feedbackId, content);
        feedbackDatabase.put(feedbackId, feedback);
        System.out.println("Feedback submitted successfully with ID: " + feedbackId);
    }

    private void validateFeedbackContent(String content) {
        if (content == null || content.trim().isEmpty()) {
            throw new InvalidFeedbackContentException("Feedback content cannot be empty.");
        }
        if (content.contains("inappropriate")) {
            throw new InvalidFeedbackContentException("Feedback contains inappropriate content.");
        }
    }

    public Feedback getFeedback(String feedbackId) throws FeedbackNotFoundException {
        Feedback feedback = feedbackDatabase.get(feedbackId);
        if (feedback == null) {
            throw new FeedbackNotFoundException("Feedback with ID " + feedbackId + " not found.");
        }
        return feedback;
    }

    public static void main(String[] args) {
        Program10 feedbackSystem = new Program10();

        try {
            feedbackSystem.submitFeedback("FB001", "Great service!");
            feedbackSystem.submitFeedback("FB002", "inappropriate feedback here");
        } catch (InvalidFeedbackContentException e) {
            System.err.println("Feedback submission error: " + e.getMessage());
        }

        try {
            Feedback feedback = feedbackSystem.getFeedback("FB001");
            System.out.println("Retrieved feedback: " + feedback.getContent());
            
            feedbackSystem.getFeedback("FB003");
        } catch (FeedbackNotFoundException e) {
            System.err.println("Error retrieving feedback: " + e.getMessage());
        }
    }
}
