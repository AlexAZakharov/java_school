package ru.alexazakharov.javaschool.sandbox;

public class Point {
    static String name = "Точка";
    public double x;
    public double y;

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    //выводит координаты точки
    public String displayPoin() {
       return " с координатами по х: "+this.x +" и по y: "+ this.y;
    }
    //метод вычисления расстояния между точками
    public double distance(Point p) {
        return Math.sqrt((this.x-p.x)*(this.x-p.x)+(this.y-p.y)*(this.y-p.y));
    }
}

