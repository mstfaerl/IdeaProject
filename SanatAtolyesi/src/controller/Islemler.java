package controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

abstract interface Islemler {

    abstract void ekle();
    abstract void olustur();
    abstract void duzenle();
    abstract void listele();
    abstract void sil();
    abstract ArrayList <?> read();
    abstract void show();

}
