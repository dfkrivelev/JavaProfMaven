package homework33.spring;

import homework33.Games;
import homework33.MortalKombat;
import homework33.PrinceOfPersia;
import homework33.Sega;
import homework33.SuperMario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean(name = "prince")
    public Games princeOfPersia() {
        return new PrinceOfPersia();
    }

    @Bean(name = "mortal kombat")
    public Games mortalKombat() {
        return new MortalKombat();
    }

    @Bean(name = "mario")
    public Games superMario() {
        return new SuperMario();
    }

    @Bean
    public Sega sega(Games prince) {
        Sega sega = new Sega();
        sega.setGame(prince);
        return sega;
    }
}
