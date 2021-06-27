import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main{

    public static void main(String[] args) throws IOException{

        int counter_of_adjectives = 0;
        int counter_of_verb = 0;
        int counter_of_adverb = 0;

        String text_file = "./info";
        String contents = readUsingScanner(text_file);

        System.out.println("Text from file: " + contents);

        Pattern adjective_pattern = Pattern.compile("(\\b[А-Яа-я]+(ого|его|ому|ему|ой|ый|ым|им|ом|ем|ей|ую|юю|ое|ее|ий)+( |\\.))");
        Pattern verb_pattern = Pattern.compile("(\\b[А-Яа-я]+(ешь|ет|ем|ете|ишь|ит|им|ите|и|тся|ться|ись|ть)+( |\\.))");
        Pattern adverb_pattern = Pattern.compile("(\\b[А-Яа-я]+(о|а)+( |\\.))");

        Matcher adjective_matcher = adjective_pattern.matcher(contents);
        while(adjective_matcher.find()){
            System.out.println("Program find: " + adjective_matcher.group());
            counter_of_adjectives = counter_of_adjectives+1;
            System.out.println();
        }

        Matcher verb_matcher = verb_pattern.matcher(contents);
        while(verb_matcher.find()){
            System.out.println("Program find: " + verb_matcher.group());
            counter_of_verb = counter_of_verb+1;
            System.out.println();
        }

        Matcher adverb_matcher = adverb_pattern.matcher(contents);
        while(adverb_matcher.find()){
            System.out.println("Program find: " + adverb_matcher.group());
            counter_of_adverb = counter_of_adverb+1;
            System.out.println();
        }

        System.out.println("This text contains " + counter_of_adjectives + " adjectives");
        System.out.println("This text contains " + counter_of_verb + " verbs");
        System.out.println("This text contains " + counter_of_adverb + " adverbs");
    }

    public static String readUsingScanner(String readingFile) throws IOException {
        Scanner scanner = new Scanner(Paths.get(readingFile), StandardCharsets.UTF_8.name());
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }
}