package com.anasantanapedrosaprdro.dassblogs.services.exeptions;

import javax.swing.text.html.parser.Entity;

public class EntityNotFoundExcepion extends RuntimeException{
    private static final long serialVersionUID=1L;
    public EntityNotFoundExcepion(String msg){
        super(msg);
    }
}
