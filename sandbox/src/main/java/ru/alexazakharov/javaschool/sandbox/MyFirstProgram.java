package ru.alexazakharov.javaschool.sandbox;

public class MyFirstProgram {
	public static void main(String[] args) {
		//создаем обьект p1
		Point p1 = new Point(-1, 3);

		// создаем обьект p2
		Point p2 = new Point(-4, 7);

		//System.out.println("Yellow");
		//выводим координаты точки-обьекта p1
		System.out.println(p1.name+p1.displayPoin());

		//выводим координаты точки-обьекта p2
		System.out.println(p2.name+p2.displayPoin());

		//выводим расстояние между точками через функцию
		System.out.println("Расстояние между "+p1.name+p1.displayPoin()+" и "+p2.name+p2.displayPoin()+" равно "+distance(p1,p2));

		//выводим расстояние между точками через метод в классе Point
		System.out.println("Расстояние между "+p1.name+p1.displayPoin()+" и "+p2.name+p2.displayPoin()+" равно "+p1.distance(p2));

		//выводим расстояние между точками через метод в классе Point(Наоборот)
		System.out.println("Расстояние между "+p2.name+p2.displayPoin()+" и "+p1.name+p1.displayPoin()+" равно "+p2.distance(p1));
	}

	//функция для вычисления  расстояния между двумя точками
	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	}
}