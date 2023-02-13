package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {

    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("Volvo","Green",15));
        carList.add(new Car("BMW", "Black", 12));
        carList.add(new Car("Mersedes", "White", 16));
        carList.add(new Car("Mersedes", "Gray", 17));
        carList.add(new Car("Nissan", "Red", 18));
    }

    public CarDaoImpl() {}
    @Override
    public List<Car> getCarsDao() {
        return carList;
    }
}
