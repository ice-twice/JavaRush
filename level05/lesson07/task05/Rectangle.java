package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle {
    //напишите тут ваш код
    int left = 0, top = 0, weight = 0, height = 0;

    public void initialize(int left, int top, int weight, int height) {
        this.left = left;
        this.top = top;
        this.weight = weight;
        this.height = height;

    }

    public void initialize(int left, int top) {
        this.left = left;
        this.top = top;

    }

    public void initialize(int left, int top, int weight) {
        this.left = left;
        this.top = top;
        this.weight = weight;
        this.height = weight;
    }

    public void initialize(Rectangle rectangle) {
        this.left = rectangle.left;
        this.top = rectangle.top;
        this.weight = rectangle.weight;
        this.height = rectangle.height;

    }

}
