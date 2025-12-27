package ru.ablaeva.geometry;

import java.util.Objects;

public class Line<P> implements Cloneable {
    private P A, B;

    // создание линии через 2 точки
    public Line(P A, P B) {
        this.A = A;
        this.B = B;
    }

    // получение точек начала A и конца B линии
    public P getStart() { 
        return A; 
    }

    public P getEnd() { 
        return B; 
    } 

    // изменение координат точек
    public void setStart(P start) { 
        this.A = start; 
    }

    public void setEnd(P end) { 
        this.B = end; 
    }

    // метод для сдвига точки начала на 10 единиц по оси х
    public void shiftStartX() {
        if (A instanceof Point) {
            Point pointA = (Point) A;
            int newX = pointA.getX() + 10;
            A = (P) new Point(newX, pointA.getY());
        }
        if (A instanceof Point3D) {
            Point3D pointA = (Point3D) A;
            int newX = pointA.getX() + 10;
            A = (P) new Point3D(newX, pointA.getY(), pointA.getZ());
        }
    }

    // вывод текстового представления сущности Линия
    @Override
    public String toString() {
        return "Линия от " + A + " до " + B;
    }
}
