package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class SoapTests extends TestBase{
    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());
    }
    @Test
    public void testCreationIssue()throws MalformedURLException, ServiceException, RemoteException{
        Set<Project> projects = app.soap().getProjects();
        Project project = projects.iterator().next();
        Issue issue = new Issue().withSummary("Test issue").withDescription("Test issue description").withProject(project);
        Issue created = app.soap().addissue(issue);
        assertEquals(issue.getSummary(),created.getSummary());
    }
}
