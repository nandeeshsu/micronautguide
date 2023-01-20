package demo.cli.app;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "demo-cli-app", description = "...",
        mixinStandardHelpOptions = true)
public class DemoCliAppCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(DemoCliAppCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Welcome to micronaut command line applicatin");
        }
    }
}
