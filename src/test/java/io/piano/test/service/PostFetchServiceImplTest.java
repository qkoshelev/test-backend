package io.piano.test.service;

import io.piano.test.dao.Items;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class PostFetchServiceImplTest {

    private static final String SE_RESPONSE = "{\"items\":[{\"tags\":[\"java\"],\"owner\":{\"reputation\":1,\"user_id\"" +
            ":8996023,\"user_type\":\"registered\",\"profile_image\"" +
            ":\"https://www.gravatar.com/avatar/48f5fa5bf0154431c2be90f7939e2c09?s=128&d=identicon&r=PG&f=1\",\"" +
            "display_name\":\"CCma\",\"link\":\"https://stackoverflow.com/users/8996023/ccma\"},\"is_answered\"" +
            ":false,\"view_count\":138,\"answer_count\":0,\"score\":0,\"last_activity_date\":1554124935,\"" +
            "creation_date\":1554124935,\"question_id\":55456201,\"link\":\"" +
            "https://stackoverflow.com/questions/55456201/read-gmail-primary-category-mails-only-using-java-and-of-selected-date\",\"" +
            "title\":\"Read Gmail Primary Category mails only using Java and of selected date\"}]}";

    private PostFetchServiceImpl postFetchService;

    @Before
    public void init() throws IOException {
        this.postFetchService = spy(PostFetchServiceImpl.class);
        doReturn(SE_RESPONSE).when(postFetchService).requestServer(any(), any(), any());
    }

    @Test
    public void fetchPostsByTitle() throws IOException {
        Items items = postFetchService.fetchPostsByTitle("");
        assertTrue(items.getItems().size() == 1);
    }
}