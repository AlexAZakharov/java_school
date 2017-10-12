package ru.stqa.pft.rest;

import org.testng.annotations.Test;

public class BugifyIntegration extends TestBase{

    @Test
    public void testRunResolved()  {
        int issueId=234;
        skipIfNotFixed(issueId);
        System.out.println("RUN THE Test"+issueId);// печатается
    }
    @Test
    public void testRunOpen()  {
        int issueId=235;
        skipIfNotFixed(issueId);
        System.out.println("RUN THE Test"+issueId);// игнорируется
    }
}
