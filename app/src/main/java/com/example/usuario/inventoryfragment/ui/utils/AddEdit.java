package com.example.usuario.inventoryfragment.ui.utils;

/**
 * Created by mamorky on 29/11/17.
 */

public class AddEdit {
    //interface AddEdit
    public static final int ADD_MODE = 0;
    public static final int EDIT_MODE = 0;
    public int mode;

    public AddEdit(){
        this.mode = ADD_MODE;
    }

    public AddEdit(int mode){
        if(mode < ADD_MODE || mode > EDIT_MODE)
            throw new IllegalMonitorStateException("Invalid AddEditMode: "+mode);
        this.mode = mode;
    }

    public int getMode(){
        return mode;
    }

    public void setMode(int mode){
        this.mode = mode;
    }
}
