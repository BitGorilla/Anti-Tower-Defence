package Main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class TileCreator {

    public static Tile createTile(String type,
                           Direction direction,
                           Position centerPos,
                           Position upperLeft,
                           Position lowerRight) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        System.out.println(type);
        Class<?> tileClass = Class.forName("Main." + type);
        Method landOn;
        if (!TileInterface.class.isAssignableFrom(tileClass) ||
                !Tile.class.isAssignableFrom(tileClass)) {
            throw new ClassNotFoundException();
        }
        if(tileClass.getConstructors().length != 1 ||
                tileClass.getConstructors()[0].getParameterCount() != 4) {
            throw new ClassNotFoundException();
        }
        Constructor constructor = tileClass.getConstructors()[0];
        Class<?>[] parameters =
                tileClass.getConstructors()[0].getParameterTypes();
        if (parameters[0] != Direction.class ||
                parameters[1] != Position.class ||
                parameters[2] != Position.class ||
                parameters[3] != Position.class) {
            throw new ClassNotFoundException();
        }
        landOn = tileClass.getMethod("landOn", Creature.class);
        if(landOn.getParameterCount() != 1 ||
                landOn.getParameterTypes()[0] != Creature.class) {
            throw new ClassNotFoundException();
        }

        return (Tile) constructor.newInstance(direction, centerPos, upperLeft,
                lowerRight);
    }
}
