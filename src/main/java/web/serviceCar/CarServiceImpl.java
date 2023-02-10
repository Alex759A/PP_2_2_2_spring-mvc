package web.serviceCar;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("Volvo","Green",15));
        carList.add(new Car("BMW", "Black", 12));
        carList.add(new Car("Mersedes", "White", 16));
        carList.add(new Car("Mersedes", "Gray", 17));
        carList.add(new Car("Nissan", "Red", 18));
    }
    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarsList( long count) {
//        System.out.println(count);
//        System.out.println(carList.stream().limit(count).collect(Collectors.toList()));
        return carList.stream().limit(count).collect(Collectors.toList()); //
    }
}
