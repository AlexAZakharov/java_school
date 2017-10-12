package ru.stqa.pft.rest;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.sun.org.apache.regexp.internal.RE;
import io.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestAssuredTest extends TestBase {
   /* @BeforeClass
    public void init(){
        RestAssured.authentication = RestAssured.basic("28accbe43ea112d9feb328d2c00b3eed","");
    }*/

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
        String json = RestAssured.get("http://demo.bugify.com/api/issues/search.json?q=Alex&page=1&limit=500").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());
    }

    private int creatIssue(Issue newIssue) throws IOException {
        String json=RestAssured.given().param("subject",newIssue.getSubject())
                .param("description",newIssue
                .getDescription())
                .post("http://demo.bugify.com/api/issues.json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        return parsed.getAsJsonObject().get("issue_id").getAsInt();
    }
}
