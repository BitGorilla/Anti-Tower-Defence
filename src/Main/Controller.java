package Main;

import formatters.Animator;
import formatters.XMLReader;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;


public class Controller {

    private GameFieldTest gui;
    private GameManager gameM;
    private String levelName;
    private int windowWidth;
    private XMLReader reader;
    private ArrayList<Map> map;
    private Animator animator;

    public Controller(){
        XMLReader reader = new XMLReader(100);
        //reader.setSource(new FileInputStream(new File("")));
        createGUI();

    }

    public void createGUI(){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new GameFieldTest();

                gui.show();
            }
        });
    }



}
