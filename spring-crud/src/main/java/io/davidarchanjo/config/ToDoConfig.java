package io.davidarchanjo.config;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class ToDoConfig {

    @Bean
    public EasyRandom easyRandom() {
        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.randomize(Integer.class, () -> ThreadLocalRandom.current().nextInt(1, 100));
        return new EasyRandom(parameters);
    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

}
