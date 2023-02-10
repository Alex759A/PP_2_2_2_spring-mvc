package web.model;

public class Car {
    private String name;
    private String colorCar;
    private Integer carSeria;

    public Car() {
    }

    public Car(String name, String colorCar, Integer carSeria) {
        this.name = name;
        this.colorCar = colorCar;
        this.carSeria = carSeria;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }

    public Integer getCarSeria() {
        return carSeria;
    }

    public void setCarSeria(Integer carSeria) {
        this.carSeria = carSeria;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", colorCar='" + colorCar + '\'' +
                ", carSeria=" + carSeria +
                '}';
    }
}


