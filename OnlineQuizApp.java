import java.net.http.*;
import java.net.URI;
import java.util.*;
import com.google.gson.*; // For JSON parsing

public class OnlineQuizApp {

    static class Question {
        String question;
        List<String> options;
        String correctAnswer;

        Question(String question, List<String> options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("🌐 Welcome to the Online Quiz Game!");
        System.out.println("----------------------------------");

        boolean play = true;

        while (play) {
            // Fetch a random question from Open Trivia API
            Question q = fetchQuestion();

            if (q == null) {
                System.out.println("⚠️ Failed to load question. Please check your internet connection.");
                break;
            }

            System.out.println("\nQuestion: " + htmlDecode(q.question));

            char optionLetter = 'A';
            for (String opt : q.options) {
                System.out.println(optionLetter + ". " + htmlDecode(opt));
                optionLetter++;
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            char userAns = Character.toUpperCase(sc.next().charAt(0));

            int ansIndex = userAns - 'A';
            if (ansIndex >= 0 && ansIndex < q.options.size()) {
                String selected = q.options.get(ansIndex);
                if (selected.equals(q.correctAnswer)) {
                    System.out.println("✅ Correct!");
                    score++;
                } else {
                    System.out.println("❌ Wrong! Correct answer: " + htmlDecode(q.correctAnswer));
                }
            } else {
                System.out.println("❌ Invalid option!");
            }

            System.out.print("\nDo you want to continue the game? (yes/no): ");
            String choice = sc.next().trim().toLowerCase();

            if (choice.equals("no")) {
                play = false;
            }
        }

        System.out.println("\n----------------------------------");
        System.out.println("🏁 Game Over!");
        System.out.println("Your Final Score: " + score);
        System.out.println("----------------------------------");

        sc.close();
    }

    // Function to fetch a random question from API
    public static Question fetchQuestion() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://opentdb.com/api.php?amount=1&type=multiple"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON using Gson
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonArray results = json.getAsJsonArray("results");
            JsonObject qObj = results.get(0).getAsJsonObject();

            String question = qObj.get("question").getAsString();
            String correct = qObj.get("correct_answer").getAsString();

            JsonArray incorrectArr = qObj.getAsJsonArray("incorrect_answers");
            List<String> options = new ArrayList<>();
            for (int i = 0; i < incorrectArr.size(); i++) {
                options.add(incorrectArr.get(i).getAsString());
            }
            options.add(correct);
            Collections.shuffle(options); // randomize order

            return new Question(question, options, correct);
        } catch (Exception e) {
            return null;
        }
    }

    // Decode HTML entities (like &quot; or &#039;)
    public static String htmlDecode(String text) {
        return text.replace("&quot;", "\"")
                   .replace("&#039;", "'")
                   .replace("&amp;", "&")
                   .replace("&lt;", "<")
                   .replace("&gt;", ">");
    }
}
