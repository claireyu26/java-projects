import java.util.*;

public class Main {
    //12/9/24
    //State capital quiz
    //Java classes practice
    public static void main(String[] args) {
        var quiz = new Quiz();

        quiz.addQuestion("alabama", "montgomery");
        quiz.addQuestion("alaska", "juneau");
        quiz.addQuestion("arizona", "phoenix");
        quiz.addQuestion("arkansas", "little rock");
        quiz.addQuestion("california", "sacramento");
        quiz.addQuestion("colorado", "denver");
        quiz.addQuestion("connecticut", "hartford");
        quiz.addQuestion("delaware", "dover");
        quiz.addQuestion("florida", "tallahassee");
        quiz.addQuestion("georgia", "atlanta");

        quiz.runQuiz();
    }
}

class Question {
    // Keep track of the question and answer text, as
    // well as the response from the user

    String question;
    String answer;
    String response;

    // Share one scanner instance between all Questions
    static Scanner scanner = new Scanner(System.in);

    Question(String question, String answer) {
        // Your code goes here !!
        this.question=question;
        this.answer=answer;
        //this.response=response;
    }

    void ask() {
        // Display the question text, get and store the user response
        // Your code goes here !!

        System.out.println("what is the capital of "+ question+"? ");
        response=scanner.nextLine();

        // Prompt the user to enter a response and return
        // the resulting string
        // Your code goes here !!
    }

    boolean isCorrect() {
        // Check if the response is correct
        if (response.equalsIgnoreCase(answer)){ //case insensitive
            return true;
        } else{
            return false; // Your code goes here !!
        }
    }

    public String toString() {
        // Display the question text, the user response,
        // the status (Correct or Incorrect), and the answer if
        // the response is incorrect
        var result = "";

        // Your code goes here !!

        result = "Question: What is the capital of " + question + "?\n";
        result += "Your answer: " + response + "\n";
        result += isCorrect() ? "Correct!" : "Incorrect. The correct answer is " + answer;
        return result;
    }
}

// Quiz keep track of a list of questions and handles
// handles asking the questions sequentially

class Quiz {
    List<Question> questions = new ArrayList<>();

    void runQuiz() {
        // Have the user respond to each question, then
        // print out the results for each question and
        // calculate the number of correct responses

        var score = 0;
        var total = questions.size();

        for (var question : questions) {
            // Ask each question and update the score
            // Your code goes here !!

            question.ask();

            //var questionClass= new Question(question, answer);
            //questionClass.ask();

            //updating score
            if (question.isCorrect()){
                score++;
            }
            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        for (var question : questions) {
            // Show the results for each question and submission
            // Your code goes here !!

            //var questionClass= new Question(question, sdfs);
            //System.out.println(questionClass.toString());

            System.out.println(question); //calls toString() from Question
        }
        System.out.println("Score: " + score + " of " + total);
    }

    void addQuestion(String question, String answer) {
        // Add a new question to the quiz for
        // the given question and answer pair

        // Your code goes here !!

        //var quiz = new Quiz();
       // Question.ask(question,answer);

        //questions is the global list in class Quiz
        questions.add(new Question(question, answer)); //questions = [Question("alabama", "montgomery"), Question("alaska", "juneau")]
    }
}
