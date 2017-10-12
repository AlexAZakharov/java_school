package ru.stqa.pft.rest;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTest {
    @Test
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssue();
        Issue newIssue= new Issue().withSubject("Alex").withDescription("NovoNovo");
        int issueId = creatIssue(newIssue);
        Set<Issue> newIssues = getIssue();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues,oldIssues);
    }

    private Set<Issue> getIssue() throws IOException {
        String json= getExecutor().execute(Request.Get("http://demo.bugify.com/api/issues/search.json?q=Alex&page=1&limit=500"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());
    }

    private Executor getExecutor() {
        return Executor.newInstance().auth("28accbe43ea112d9feb328d2c00b3eed","");
    }

    private int creatIssue(Issue newIssue) throws IOException {
        String json= getExecutor().execute(Request.Post("http://demo.bugify.com/api/issues.json")
                .bodyForm(new BasicNameValuePair("subject",newIssue.getSubject()),
                        new BasicNameValuePair("description",newIssue.getDescription())))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();
    }
}
