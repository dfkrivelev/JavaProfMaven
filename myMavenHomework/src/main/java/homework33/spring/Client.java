package homework33.spring;

/**
 * Java Prof. Homework #33
 *
 * @author Dzmitry Kryvialeu
 * @version 09.03 - 12.03
 */

import homework33.Games;
import homework33.Sega;
import homework33.SuperMario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Sega sega = context.getBean("sega", Sega.class);
        Games mario = context.getBean("mario", SuperMario.class);
        sega.startGame();

        sega.setGame(mario);
        sega.startGame();
    }
}
