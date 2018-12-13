package Tiles;

import Creatures.Creature;
import Main.Direction;
import Main.Position;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.ServerError;

public final class TileCreator {

    public static Tile createTile(String type, Image image,
                           Direction direction,
                           Position centerPos,
                           Position upperLeft,
                           Position lowerRight) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        Class<?> tileClass = BlankTile.class;
        try {
             tileClass = getTileClassFromString(type);
        } catch(ClassNotFoundException e) {
            System.err.println("No tile with name " + type + " creating " +
                    "blankTile");
        }
        Constructor constructor = tileClass.getConstructors()[0];
        checkTileClassConstructor(constructor);

        checkLandOnMethod(tileClass.getMethod("landOn", Creature.class));

        return (Tile) constructor.newInstance(image, direction, centerPos,
                upperLeft,
                lowerRight);
    }

    private static Class<?> getTileClassFromString(String type) throws ClassNotFoundException {
        Class<?> tileClass = Class.forName("Tiles." + type);
        if (!TileInterface.class.isAssignableFrom(tileClass) ||
                !Tile.class.isAssignableFrom(tileClass)) {
            throw new ClassNotFoundException(type + "Not extending Tile or not implementing TileInterface");
        }
        if(tileClass.getConstructors().length != 1 ||
                tileClass.getConstructors()[0].getParameterCount() != 5) {
            throw new ClassNotFoundException(type + "Constructor not correct");
        }
        return tileClass;
    }

    private static void checkTileClassConstructor(Constructor constructor) throws ClassNotFoundException {
        boolean correctConstructor = false;
        Class<?>[] parameters =
                constructor.getParameterTypes();
        if (parameters[0] != Image.class || parameters[1] != Direction.class ||
                parameters[2] != Position.class ||
                parameters[3] != Position.class ||
                parameters[4] != Position.class) {

            throw new ClassNotFoundException(constructor.getDeclaringClass().getName() +
                    " Wrong parameters in Constructor ");
        }
    }

    private static void checkLandOnMethod(Method landOn) throws ClassNotFoundException {
        if(landOn.getParameterCount() != 1 ||
                landOn.getParameterTypes()[0] != Creature.class) {
            throw new ClassNotFoundException(landOn.getDeclaringClass().getName() +
                    " LandOn method not correct");
        }
    }
}
