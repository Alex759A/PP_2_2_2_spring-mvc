package web.serviceCar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.CarDaoImpl;
import web.model.Car;
import web.dao.CarDao;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    @Autowired
    CarDao carDao;


    @Override
    public List<Car> getCars() {
        return carDao.getCarsDao();
    }

    @Override
    public List<Car> getCarsList( long count) {
//        System.out.println(count);
//        System.out.println(carList.stream().limit(count).collect(Collectors.toList()));
        return getCars().stream().limit(count).collect(Collectors.toList()); //
    }
}
