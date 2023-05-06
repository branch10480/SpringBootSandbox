package com.example.command_line_runner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class CommandLineRunnerApplication implements CommandLineRunner {

// 	public static void main(String[] args) {
// 		SpringApplication.run(CommandLineRunnerApplication.class, args);
// 	}
	
// 	@Override
// 	public void run(String... args) throws Exception {
// 		System.out.println("------- Command Line Runner ------- ");
// 		System.out.println("[" + String.join(",", args) + "]");
// 	}

// }

@SpringBootApplication
public class CommandLineRunnerApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(CommandLineRunnerApplication.class);
		app.setBannerMode(Mode.OFF);
		app.setHeadless(false);
		app.run(args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// System.out.println("------- Command Line Runner ------- ");
		// System.out.println("[" + String.join(",", args.getSourceArgs()) + "]");
		// System.out.println("[" + String.join(",", args.getOptionNames()) + "]");
		// System.out.println("[" + String.join(",", args.getNonOptionArgs()) + "]");
		
		JFrame frame = new JFrame("Hoge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		frame.add(new JLabel("Spring Boot Application"));
		frame.setVisible(true);
	}
}