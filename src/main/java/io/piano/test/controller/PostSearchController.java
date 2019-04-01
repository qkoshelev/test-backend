package io.piano.test.controller;

import io.piano.test.dao.Items;
import io.piano.test.service.PostFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by ilya on 27.03.19.
 */
@RestController
public class PostSearchController {

    @Autowired
    PostFetchService postFetchService;

    @RequestMapping(
            value = {"/api/stackoverflow/search/{query}"},
            method = RequestMethod.GET
    )
    @ResponseBody
    public ResponseEntity<Items> getPostsByQuery(@PathVariable("query") String query) throws IOException {

        Optional<Items> resultOpt = Optional.ofNullable(postFetchService.fetchPostsByTitle(query));

        return new ResponseEntity(resultOpt.orElse(new Items()).toJsonString(), HttpStatus.OK);
    }
}
