package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class MantisIntegrarionTest extends TestBase {
    @Test
    public void testRun() throws RemoteException, ServiceException, MalformedURLException {
        int issueId = 4;
        skipIfNotFixed(issueId);
        System.out.println("Run Test "+issueId);// печатается
    }
    @Test
    public void testFaled() throws RemoteException, ServiceException, MalformedURLException {
        int issueId = 1;
        skipIfNotFixed(issueId);
        System.out.println("Run Test "+issueId);// не печатается
    }

}
