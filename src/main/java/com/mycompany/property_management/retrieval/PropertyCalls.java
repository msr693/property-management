package com.mycompany.property_management.retrieval;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;


@NoArgsConstructor
@Getter
@Setter
@Service
public class PropertyCalls {

//    private static final Logger log = LoggerFactory.getLogger(PropertyCalls.class);

    public ResponseEntity<String> callHello() throws URISyntaxException {
        RestTemplate restTemplate = null;

        String url = "http://localhost:8080/api/v1/hello";

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(new URI(url),String.class);


//        log.info(responseEntity.getBody().toString());

        return responseEntity;

//        Optional<ResponseEntity<String>> forEntity = Optional.of(restTemplate.getForEntity(url, String.class));
//
//        if(forEntity.isPresent()){
//            ResponseEntity<String> responseEntity = new ResponseEntity<>(forEntity.get().getStatusCode());
//        }
//

    }

}
