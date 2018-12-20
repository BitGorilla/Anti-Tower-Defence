package tiles;

import creatures.Creature;
import gameLogic.Direction;
import gameLogic.Position;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Static class responsible for verifying that a tiletype and its information is
 * correct and creating the specified tile by use of reflection.
 * @author oi16ohn, oi16jsn
 * @since 2018-12-18
 */
public final class TileCreator {

    /**
     *
     * @param type, String with the classname for the tile class.
     * @param image The image of the tile that is to be created.
     * @param direction, the direction of the tile that is to be created.
     * @param centerPos, the centerposition of the tile.
     * @param upperLeft, the most upperleft position of the tile.
     * @param lowerRight, the most lowerright position of the tile.
     * @return Tile object of the type specified.
     * @throws ClassNotFoundException, if the given tiletype does not exist.
     * @throws NoSuchMethodException, if the constructor needed does not exist.
     * @throws IllegalAccessException, if any of the methods needed are not
     * accessible.
     * @throws InvocationTargetException, if an exception is thrown from the
     * methods in the specified tile.
     * @throws InstantiationException, if the specified tile cannot be
     * instantiated.
     */
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
        }
        Constructor constructor = tileClass.getConstructors()[0];
        checkTileClassConstructor(constructor);

        checkLandOnMethod(tileClass.getMethod("landOn", Creature.class));

        return (Tile) constructor.newInstance(image, direction, centerPos,
                upperLeft,
                lowerRight);
    }

    /**
     * Verifies and then gets the class specified in the type string.
     * @param type, string with a classname of a tileclass.
     * @return Class of the tileClass found from the type string.
     * @throws ClassNotFoundException, if the classname in the type string is
     * not found to be a tileClass.
     */
    private static Class<?> getTileClassFromString(String type)
            throws ClassNotFoundException {
        Class<?> tileClass = Class.forName("tiles." + type);
        if (!TileInterface.class.isAssignableFrom(tileClass) ||
                !Tile.class.isAssignableFrom(tileClass)) {
            throw new ClassNotFoundException(type + "Not extending Tile or" +
                    " not implementing TileInterface");
        }
        if(tileClass.getConstructors().length != 1 ||
                tileClass.getConstructors()[0].getParameterCount() != 5) {
            throw new ClassNotFoundException(type + "Constructor not correct");
        }
        return tileClass;
    }

    /**
     * Verifies that the constructor of a tileclass follows the correct schema
     * set for them. Should contain the following 5 parameters in this order,
     * Image, Direction, Center position, upperleft position, lowerright pos.
     * @param constructor, the constructor of the class to be verified.
     * @throws ClassNotFoundException, if the parameters in the constructor are
     * incorrect.
     */
    private static void checkTileClassConstructor(Constructor constructor)
            throws ClassNotFoundException {
        boolean correctConstructor = false;
        Class<?>[] parameters =
                constructor.getParameterTypes();
        if (parameters[0] != Image.class || parameters[1] != Direction.class ||
                parameters[2] != Position.class ||
                parameters[3] != Position.class ||
                parameters[4] != Position.class) {

            throw new ClassNotFoundException(
                    constructor.getDeclaringClass().getName() +
                    " Wrong parameters in Constructor ");
        }
    }

    /**
     * Verified that the landOn method in the tileClass exists and is correct.
     * Should have one parameter of the type Creature.
     * @param landOn, the landOn method of the class.
     * @throws ClassNotFoundException, if the landOn method of the class is
     * incorrect.
     */
    private static void checkLandOnMethod(Method landOn) throws
            ClassNotFoundException {
        if(landOn.getParameterCount() != 1 ||
                landOn.getParameterTypes()[0] != Creature.class) {
            throw new ClassNotFoundException(
                    landOn.getDeclaringClass().getName() +
                    " LandOn method not correct");
        }
    }
}
