package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;

import java.util.Set;

public class TestBase {
    @BeforeClass
    public void init(){
        RestAssured.authentication = RestAssured.basic("28accbe43ea112d9feb328d2c00b3eed","");}

    public boolean isIssueOpen(int issueId){
        String json = RestAssured.get(
                String.format("http://demo.bugify.com/api/issues/%s.json",issueId)).asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        Set<Issue> newIssues = new Gson().fromJson(issues,new TypeToken<Set<Issue>>(){}.getType());
        String s = newIssues.iterator().next().getState_name();
        if(s.equals("Resolved")){return false;}
        return true;
    }
    public void skipIfNotFixed(int issueId) {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

}
