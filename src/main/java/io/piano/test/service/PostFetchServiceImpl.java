package io.piano.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.piano.test.dao.Items;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

/**
 * Created by ilya on 27.03.19.
 */
@Service
public class PostFetchServiceImpl implements PostFetchService {

    protected static final Log LOG = LogFactory.getLog(PostFetchServiceImpl.class);

    private static final String SE_URL_TEMPLATE = "http://api.stackexchange.com/2.2/search?order=desc&sort=activity&site=stackoverflow";
    private static final String QUERY_PARAMETER = "intitle";

    @Override
    public Items fetchPostsByTitle(String queryToSearch) throws IOException {
        String response = requestServer(queryToSearch, QUERY_PARAMETER, SE_URL_TEMPLATE);
        return  mapItems(response);
    }

    private String requestServer(String queryToSearch, String queryParameterKey, String serverUrlTemplate) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        URI searchUrl = addParamToURL(queryParameterKey, queryToSearch, serverUrlTemplate);
        HttpGet request = new HttpGet(searchUrl.toString());
        HttpResponse response = client.execute(request);

        LOG.debug("Got response Code: " + response.getStatusLine().getStatusCode() + " for query: " + queryToSearch);
        return EntityUtils.toString(response.getEntity());
    }

    private Items mapItems(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, Items.class);
    }

    private URI addParamToURL(String paramName, String paramValue, String url) {
        return UriComponentsBuilder.fromUriString(url).queryParam(paramName, paramValue).build().toUri();
    }
}
