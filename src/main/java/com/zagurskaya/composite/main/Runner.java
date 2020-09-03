package com.zagurskaya.composite.main;

import com.zagurskaya.composite.action.Calculation;
import com.zagurskaya.composite.comparator.TriangleComparator;
import com.zagurskaya.composite.creator.TriangleCreator;
import com.zagurskaya.composite.entity.Triangle;
import com.zagurskaya.composite.entity.TriangleParameters;
import com.zagurskaya.composite.entity.Warehouse;
import com.zagurskaya.composite.factory.TriangleFactory;
import com.zagurskaya.composite.factory.impl.TriangleFactoryImpl;
import com.zagurskaya.composite.reader.DataReader;
import com.zagurskaya.composite.repository.TriangleRepository;
import com.zagurskaya.composite.specification.TriangleSpecification;
import com.zagurskaya.composite.specification.impl.RectangularTriangleTriangleSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {

        List<Triangle> triangles = new ArrayList<>();
        DataReader dataReader = new DataReader();
        TriangleCreator triangleCreator = new TriangleCreator();

        List<String> rowsTrianglesList = dataReader.readTextToRowList("data/data1.txt");
        rowsTrianglesList.stream().forEach(row -> {
            Triangle triangle = triangleCreator.create(row);
            if (triangle != null) {
                triangles.add(triangle);
            }
        });
//        int y = 1;
        Calculation calculation = new Calculation();
        List<Double> areas = new ArrayList<>();
        List<Double> perimeters = new ArrayList<>();

//        int i = 2;
        TriangleFactory triangleFactory = new TriangleFactoryImpl();

        Warehouse warehouse = Warehouse.getInstance(); // WHF.getWh через фабрику
        triangles.forEach(triangle -> {
            Double area = calculation.getArea(triangle);
            areas.add(area);
            Double perimeter = calculation.getPerimeter(triangle);
            perimeters.add(perimeter);
            TriangleParameters triangleParameters = new TriangleParameters(perimeter, area);
            warehouse.put(triangle.getTriangleId(), triangleParameters);
        });
        Map<Long, TriangleParameters> warehouseParametersMap = warehouse.getParametersMap();
        int i = 3;

        Triangle updateTriangle = triangles.get(0);
        updateTriangle.getPoint1().setX(1.0);
//        triangleFactory.updateTriangle(updateTriangle, warehouse);


        int a = 4;
        triangles.sort(TriangleComparator.ID);
        System.out.println(triangles);

        triangles.sort(TriangleComparator.X);
        System.out.println(triangles);

        triangles.sort(TriangleComparator.Y);
        System.out.println(triangles);


        TriangleRepository repository = TriangleRepository.getInstance();
        triangles.stream().forEach(t -> repository.add(t));
        TriangleSpecification triangleSpecification = new RectangularTriangleTriangleSpecification();
        List<Triangle> rectangularTriangle = repository.query(triangleSpecification);
        System.out.println("rectangularTriangle");
        System.out.println(rectangularTriangle);

    }
}
