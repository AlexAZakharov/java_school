package ru.alexazakharov.javaschool.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

//import static ru.alexazakharov.javaschool.sandbox.MyFirstProgram.distance;

public class PointTests {

    @Test
    //проверяем метод по у
    public void testAreea1(){
        Point p1= new Point(0.0,7.0);
        Point p2= new Point(0.0,0.0);
        Assert.assertEquals(p1.distance(p2) ,7.0);
    }

    @Test
    //проверяем метод по х
    public void testAreea2(){
        Point p1= new Point(5.0,0.0);
        Point p2= new Point(0.0,0.0);
        Assert.assertEquals(p1.distance(p2) , 5.0);
    }

    @Test
    //проверяем функцию
    public void testAreea3(){
        Point p1= new Point(5.0,0.0);
        Point p2= new Point(0.0,0.0);
        Assert.assertEquals( MyFirstProgram.distance(p1,p2) , 5.0);
    }

    @Test
    // проверяем метод - общий
    public void testAreea4(){
        Point p1= new Point(5.0,0.0);
        Point p2= new Point(8.0,4.0);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }

    @Test
    // проверяем метод - общий
    public void testAreea5(){
        Point p1= new Point(-2.0,-1.0);
        Point p2= new Point(1.0,3.0);
        Assert.assertEquals(p1.distance(p2) , 5.0);
    }
}
