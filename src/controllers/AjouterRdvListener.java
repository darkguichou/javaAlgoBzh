package controllers;

import gui.AjouterRdvView;
import metier.AjouterRdvModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by guillaume on 11/04/16.
 */
public class AjouterRdvListener implements MouseListener{


    private AjouterRdvView vue;
    private AjouterRdvModel model;
    private int i = 0;

    public AjouterRdvListener(AjouterRdvView vue, AjouterRdvModel model){


        this.vue = vue;
        this.model = model;

    }


    @Override
    public void mouseClicked(MouseEvent e) {


        if (!vue.getLieuTxt().getText().isEmpty() || !vue.getInterlocuteurTxt().getText().isEmpty()) {


            i++;

            java.sql.Date date = new java.sql.Date(vue.getDateModel().getDate().getTime());
            java.sql.Time time = new java.sql.Time(vue.getTimeModel().getDate().getTime());


            model.addVisite(vue.getChoixClient().getSelectedItem().toString(), model.getCommercial().getCode(), date, time, vue.getLieuTxt().getText(), vue.getInterlocuteurTxt().getText());
            vue.setState("Visite bien créée. (x" + i + ")");
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            vue.getLieuTxt().setText("");
            vue.getLieuTxt().setBorder(border);
            vue.getInterlocuteurTxt().setText("");
            vue.getInterlocuteurTxt().setBorder(border);
            vue.getForm().revalidate();
            vue.getForm().repaint();
            vue.revalidate();
            vue.repaint();
            vue.getParent().validate();

        } else {

            vue.setState("Erreur: tous les champs n'ont pas été remplis");
            Border border = BorderFactory.createLineBorder(Color.red);
            vue.getLieuTxt().setBorder(border);
            vue.getInterlocuteurTxt().setBorder(border);
            vue.getForm().revalidate();
            vue.getForm().repaint();
            vue.revalidate();
            vue.repaint();
            vue.getParent().validate();


        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
