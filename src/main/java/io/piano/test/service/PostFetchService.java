package io.piano.test.service;

import io.piano.test.dao.Items;

import java.io.IOException;

/**
 * Created by ilya on 27.03.19.
 */
public interface PostFetchService {
    Items fetchPostsByTitle(String queryToSearch) throws IOException;
}
