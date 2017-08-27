package inzynierka.lukkero.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SpringConfig {
    @Bean
    public CorsFilter corsFilter () {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource ( );
        CorsConfiguration config = new CorsConfiguration ( );
        config.setAllowCredentials ( true );
        config.addAllowedOrigin ( "*" );
        config.addAllowedHeader ( "*" );
        config.addAllowedMethod ( "OPTIONS" );
        config.addAllowedMethod ( "GET" );
        config.addAllowedMethod ( "POST" );
        config.addAllowedMethod ( "PUT" );
        config.addAllowedMethod ( "DELETE" );
        source.registerCorsConfiguration ( "/**", config );
        return new CorsFilter ( source );
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}