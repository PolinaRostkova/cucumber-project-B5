package io.loop.testAI;

import io.loop.utilities.ChatGPTClient;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestAi {
    public static void main(String[] args) {
        String prompt = "Generate me scenarios for www.google.com in Gherkin language, make sure to add negative ones as well"; // you can read it from somewhere else
        String aiResponse = ChatGPTClient.getResponseFromPrompt(prompt);

        System.out.println("\n============================AI Generated Response Start==============================\n");
        System.out.println("AI Response: " + aiResponse);
        System.out.println("\n============================AI Generated Response End================================\n");

        //folder path
        String folderPath = "src/test/resources/ai_suggestions/";

        //dynamic naming
        LocalDateTime now = LocalDateTime.now();
        String timeStamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"));
        String fileName = "AI suggestions_" + timeStamp + ".txt";

        try {
            // create folder if it doesn't exist

            Files.createDirectories(Paths.get(folderPath));

            // write ai output to the file
            PrintWriter out = new PrintWriter(folderPath + fileName);
            out.println(aiResponse);
            out.close();

            System.out.println("Output saved to: " + folderPath + fileName);
        }catch (IOException e){
            System.out.println("Failed to save output to file: " + folderPath + fileName);
            e.printStackTrace();
        }
    }
}
